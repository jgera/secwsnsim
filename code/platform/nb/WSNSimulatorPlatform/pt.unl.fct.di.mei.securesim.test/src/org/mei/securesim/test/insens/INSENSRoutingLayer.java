package org.mei.securesim.test.insens;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mei.securesim.components.crypto.CryptoFunctions;
import org.mei.securesim.test.insens.utils.INSENSConstants;
import org.mei.securesim.test.insens.messages.APPMsg;
import org.mei.securesim.core.application.Application;
import org.mei.securesim.core.engine.Event;
import org.mei.securesim.core.engine.Simulator;
import org.mei.securesim.core.layers.routing.RoutingLayer;
import org.mei.securesim.test.insens.messages.FDBKMsg;
import org.mei.securesim.test.insens.messages.INSENSMsg;
import org.mei.securesim.test.insens.messages.INSENSMessage;
import org.mei.securesim.test.insens.utils.ByteArrayDataInputStream;
import org.mei.securesim.test.insens.utils.ByteArrayDataOutputStream;

import org.mei.securesim.test.insens.utils.INSENSFunctions;
import org.mei.securesim.test.insens.utils.MACS;
import org.mei.securesim.test.insens.utils.graph.Dijkstra;
import org.mei.securesim.test.insens.utils.graph.WeightedGraph;
import static org.mei.securesim.test.insens.utils.INSENSFunctions.cloneMAC;

/**
 *
 * @author pedro
 */
public class INSENSRoutingLayer extends RoutingLayer {

    private int countMessages = 0;

    public enum TimeoutAction {

        WAIT_FEEDBACK, WAIT_BUILD_ROUTING
    }

    public enum ProtocolState {

        STABLE, ROUTE_REQUEST, BUILD_ROUTING_INFO;
    }
    /**
     * COMMON ATTRIBUTES
     */
    private ProtocolState state;
    private HashMap neighboorsSet = new HashMap();
    private long currentOWS = -1; // currente OWS value
    private byte[] myMACR; // record the mac sent for each first INSENSMessage received
    /**
     * SINKNODE ATTRIBUTES
     */
    private Set feedbackMessagesSet = new HashSet();
    private Hashtable tableOfNetworkNeighbors = new Hashtable();
    private Hashtable tableOfNetworkNodes = new Hashtable();
    private Hashtable tableOfForwardingTables = new Hashtable();
    private HashSet edges;
    private HashSet vertix;
    private int roundNumber = -1; // helper for sink node start new round
    /**
     * NODE ATTRIBUTES
     */
    private RREQData parentRREQMsg; // message received from parent
    /*
     * Base methods
     */

    public INSENSRoutingLayer() {
        setState(ProtocolState.ROUTE_REQUEST);
    }

    @Override
    public synchronized  void receiveMessage(Object message) {
        if (message instanceof INSENSMsg) {
            INSENSMessage msg = (INSENSMessage) message;
            handleMessageReceive(msg);
        } else {
            System.out.println("Not a INSENS Message");
        }
    }

    @Override
    public void sendMessageDone() {
//        System.out.println("Message " + getNode().getMessage() + "   done...");
    }

    @Override
    public boolean sendMessage(Object message, Application app) {
        if (message instanceof INSENSMsg) {
            this.application = app;
            handleMessageSend(message);
            return true;
        } else {
            return false;
        }
    }

    public ProtocolState getState() {
        return state;
    }

    public void setState(ProtocolState state) {
        this.state = state;
    }

    /**
     * Working Methods for handling messages
     */
    private void handleMessageSend(Object message) {
        if (message instanceof APPMsg) {
            handleAPPSend(message);
        }
    }

    private void handleMessageReceive(INSENSMessage message) {

        int type = getMessageType(message.getPayload());
        if (type == INSENSConstants.MSG_RREQ) {

            handleRREQReceive(message);
        } else if (type == INSENSConstants.MSG_FDBK) {
//            System.out.println(getTimeAndNodeId() + "\tReceived FDBKMessage: " + message.getMessageNumber() + " From " + message.getOrigin());
            handleFDBKReceive(message);
        } else if (type == INSENSConstants.MSG_RUPD) {
            handleRUPDReceive(message);
        }
    }

    private void handleRUPDReceive(Object message) {
    }

    /**
     * tratamento de recepção de mensagem de Route Requests
     * @param message
     */
    private void handleRREQReceive(Object message) {
        INSENSMessage msg = (INSENSMessage) message;

        RREQData m = new RREQData(msg.getPayload());
        if (getNode().isSinkNode()) {
            // DESCARTO AS MENSAGENS RECEBIDAS
        } else {
            if (verifyOWS(m.ows)) {
                System.out.println(getTimeAndNodeId() + "\tReceived REQMessage: " + msg.getMessageNumber() + " From " + msg.getOrigin());
                currentOWS = m.ows;
                saveFirstRREQMessage(msg.getPayload());
                newRouteDiscovery(m);
            }
        }
        addToNeighboorSet(m.id, extractMACFromPayload(msg.getPayload()));
    }

    /**
     *
     * @param message
     */
    private void handleFDBKReceive(Object message) {
        INSENSMessage m = (INSENSMessage) message;

        if (getNode().isSinkNode()) {
            saveFeedbackMessage(m);
        } else {
            // verifica se eu sou o pai do vizinho que enviou a mensagem
            if (isFromMyChild(m)) {
                  System.out.println("[" + getNode().getId() + "]\t Forward message Origem: " + m.getOrigin());
                forwardMessage2BaseStation(m);
            } else {
//                System.out.println("[" + getNode().getId() + "]\t Não é meu filho... descarto Origem: " + m.getOrigin());
            }
        }
    }

    /**
     * permite controlar se se pode utilizar o encaminhamento para
     * comunicação de dados ou se encontra em fase de organização da rede
     * @return
     */
    public boolean isStable() {
        return state == ProtocolState.STABLE;
    }

    /**
     * Mensagens especiais para interacção com a camada de aplicação
     * @param message
     */
    private void handleAPPSend(Object message) {
        APPMsg appMsg = (APPMsg) message;

        if (appMsg.getAction() == INSENSConstants.ACTION_START) {
            if (getNode().isSinkNode()) {
                // this is a base station so... lets start protocol
                reorganizeNetwork();
            }
        }
    }

    /**
     * Inicio de uma nova organização da rede
     */
    private void reorganizeNetwork() {
        roundNumber++;
        currentOWS = INSENSFunctions.getNextOWS(roundNumber);
        startNetworkOrganization();
    }

    /**
     * Mensagem inicial de reorganização da rede
     */
    private void startNetworkOrganization() {
        /* create a initial route request message */
        INSENSMessage m = new INSENSMessage(createPayloadRREQ(currentOWS, (short) 0, null, null));
        m.setOrigin(getNode().getId());
        myMACR = extractMACFromPayload(m.getPayload());
        sendDelayedMessage(m);
//        waitToCalculateRoutingTables();
    }

    /**
     *
     * @param id
     * @param mac
     */
    private void addToNeighboorSet(short id, byte[] mac) {
        neighboorsSet.put(id, mac);
    }

    /**
     *
     * @param reqMessage
     */
    private void newRouteDiscovery(RREQData reqMsg) {
        resetNeighboorSet();

        setState(ProtocolState.BUILD_ROUTING_INFO);

       INSENSMessage m = new INSENSMessage(createPayloadRREQ(reqMsg.ows, reqMsg.size, reqMsg.path, reqMsg.mac));
        m.setOrigin(getNode().getId());
        
        myMACR = extractMACFromPayload(m.getPayload());
        sendDelayedMessage(m);

        waitToSendFeedBack();
    }

    /**
     * Reinicia os dados referentes aos vizinhos conhecidos
     */
    private void resetNeighboorSet() {
        neighboorsSet.clear();
    }

    /**
     * Temporizador que controla o tempo de inicio de envio de Mensagem de
     * Feedback
     */
    private void waitToSendFeedBack() {
        Event e = new TimeoutWaitEvent();
        e.setTime(getNode().getSimulator().getSimulationTime() + INSENSConstants.FEEDBACK_WAITING_TIME);
        getNode().getSimulator().addEvent(e);
    }

    /**
     * 
     */
    private void sendFeedbackMessage() {
        INSENSMessage message = new INSENSMessage(createPayloadFDBK());
        message.setOrigin(getNode().getId());
        sendDelayedMessage(message);
    }

    /**
     * 
     * @param m
     * @return
     */
    private boolean isFromMyChild(INSENSMessage m) {
        FDBKData msg = new FDBKData(m.getPayload());
       
        boolean result = (Arrays.equals(msg.parent_info, myMACR));
        if (!result) {
//            System.out.println(m.getOrigin()+"\tParentMAC in message: " + INSENSFunctions.toHex(msg.parent_info));
//            System.out.println(getTimeAndNodeId()+"\tMyMAC: " + INSENSFunctions.toHex(myMACR));
        }

        return result;
    }

    /**
     * Ao receber uma mensagem de um nó descendente, é necessário copiar a msg
     * por forma a não arrastar referencias
     * @param m
     */
    private void forwardMessage2BaseStation(INSENSMessage m) {
        INSENSMessage message = new INSENSMessage(createPayloadForForwardFDBK(m));
        message.setOrigin(m.getOrigin());
        message.setForwardBy(getNode().getId());
        sendDelayedMessage(message);
    }

    /**
     * enviar uma mensagem usando um temporizador
     * @param m
     */
    private void sendDelayedMessage(INSENSMsg m) {
        Event e = new DelayedMessageEvent(m);
        getNode().getSimulator().addEvent(e);
    }

    /**
     *
     */
    private void computeForwardingTables() {
        // TODO MUST VALIDATE EDGE AND VERTIX SETS*/
        int numberOfNodes = vertix.size();
        System.out.println("Number of knowned nodes: " + numberOfNodes);
        WeightedGraph graph = new WeightedGraph(numberOfNodes);
//        Vector vertices= new Vector();
//        for (Object vertice : vertix) {
//            Vertex v = new Vertex((String) vertice);
//            vertices.add(v);
//        }
//
//
//        for (Object edge : edges) {
//            Edge e= (Edge) edge;
//
//
//        }
        Vector nodeTable = new Vector();
        nodeTable.addAll(vertix);
        //for debug porpuse only
        for (Object object : vertix) {
            int n1 = nodeTable.indexOf(object);
            graph.setLabel(n1, object);
        }

        for (Object edge : edges) {
            Edge e = (Edge) edge;
            graph.addEdge(nodeTable.indexOf(e.node1), nodeTable.indexOf(e.node2));
        }

        int node = 2;
        getNodeDijkstraPaths(graph, nodeTable, numberOfNodes, node);

//        for (Object key : tableOfNetworkNodes.keySet()) {
//            int node = ((Integer) key).intValue();
//            //getNodeDijkstraPaths(graph, nodeTable, numberOfNodes, node);
//        }
    }

    private void saveFeedbackMessage(INSENSMessage m) {
        countMessages++;

//        if (state == ProtocolState.BUILD_ROUTING_INFO) {
//            return;
//        }
        if (sinkNodeVerificationOfMACFx(m)) {
            System.out.println(getTimeAndNodeId()+"\t" + countMessages +"Saved Message From "+m.getOrigin() + " forward by "+ m.getForwardBy());
            feedbackMessagesSet.add(m);
        }else{
            System.out.println("NOT VERIFIED:"+getTimeAndNodeId()+" from"+m.getOrigin()+ " forward by "+ m.getForwardBy());
        }
    }

    /**
     * 
     * @param msg
     */
    private void saveFirstRREQMessage(byte[] payloadRREQ) {
        parentRREQMsg = new RREQData(payloadRREQ);
    }

    /**
     * 
     * @param m
     * @return
     */
    private boolean sinkNodeVerificationOfMACFx(INSENSMessage m) {
        if (getNode().isSinkNode()) {
            try {
                FDBKData msg = new FDBKData(m.getPayload());
                ByteArrayDataOutputStream data2mac = new ByteArrayDataOutputStream();
                data2mac.writeByte(msg.type);
                data2mac.writeLong(msg.ows);
                data2mac.writeShort(msg.path_id);
                data2mac.writeShort(msg.path_size);
                data2mac.write(msg.path);
                data2mac.write(msg.path_mac);
                data2mac.writeShort(msg.nbr_info_size);
                data2mac.write(msg.nbr_info);
                byte[] data = data2mac.toByteArray();
                boolean status = CryptoFunctions.verifyMessageIntegrityMAC(data, msg.mac, INSENSFunctions.getShareMacKey(msg.path_id));
                if (!status){
                    System.out.println("========= NOT VERIFIED");
                    System.out.println(getNodeID()+" Payload " + INSENSFunctions.toHex(m.getPayload()));
                    System.out.println("Key Used from node " + msg.path_id +": " + INSENSFunctions.toHex(INSENSFunctions.getShareMacKey(msg.path_id)));
                    System.out.println("Message DATA: "+INSENSFunctions.toHex(data));
                    System.out.println("Message MAC: "+INSENSFunctions.toHex(msg.mac));
                }

                return status;
            } catch (IOException ex) {
                Logger.getLogger(INSENSRoutingLayer.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     *
     * @param ows
     * @return
     */
    private boolean verifyOWS(long ows) {
        return ows != currentOWS;
    }

    /**
     *
     */
    private void waitToCalculateRoutingTables() {
        Event e = new TimeoutWaitEvent(TimeoutAction.WAIT_BUILD_ROUTING);
        e.setTime(getNode().getSimulator().getSimulationTime() + INSENSConstants.FEEDBACK_WAITING_TIME * 3);
        getNode().getSimulator().addEvent(e);

    }

    /**
     * Class para materializar um evento de temporização
     * de mensagens de feedback
     */
    class TimeoutWaitEvent extends Event {

        TimeoutAction action = TimeoutAction.WAIT_FEEDBACK;

        public TimeoutWaitEvent(long time, TimeoutAction action) {
            super(time);
            this.action = action;
        }

        public TimeoutWaitEvent(TimeoutAction action) {
            this.action = action;
        }

        public TimeoutWaitEvent() {
            int min = (int) (double) (INSENSConstants.FEEDBACK_WAITING_TIME - (5 * Simulator.ONE_SECOND));
            int max = (int) (double) (INSENSConstants.FEEDBACK_WAITING_TIME);
            double result = Simulator.randomGenerator.random().nextDouble() * (((max + 1) - min) + min);
            setTime((long) (getNode().getSimulator().getSimulationTime() + result));
        }

        @Override
        public void execute() {
            if (action == TimeoutAction.WAIT_FEEDBACK) {
                sendFeedbackMessage();
            } else if (action == TimeoutAction.WAIT_BUILD_ROUTING) {
                startBuildRoutingInfo();
            }

        }
    }

    /**
     * Class que possibilita o envio de uma mensagens usando
     * um temporizador
     */
    class DelayedMessageEvent extends Event {

        Object message;

        public Object getMessage() {
            return message;
        }

        public DelayedMessageEvent(Object message) {
            double result = Simulator.randomGenerator.random().nextDouble() * INSENSConstants.MAX_DELAY_TIME_MESSAGE*3;//INSENSConstants.MIN_DELAY_TIME_MESSAGE + (int) (Simulator.randomGenerator.random().nextDouble() * (INSENSConstants.MAX_DELAY_TIME_MESSAGE - INSENSConstants.MIN_DELAY_TIME_MESSAGE));
            setTime(getNode().getSimulator().getSimulationTime() + (int) result);
            this.message = message;
        }

        public DelayedMessageEvent(long time, Object message) {
            super(time);
            this.message = message;
        }

        @Override
        public void execute() {
            if (!getNode().getMacLayer().sendMessage(getMessage(), INSENSRoutingLayer.this)) {
            }

        }
    }

    /**
     * Class representing a edge from a graph
     */
    class Edge {

        int node1;
        int node2;

        private Edge(int n1, int n2) {
            node1 = n1;
            node2 = n2;
        }
    }

    /**
     *
     */
    private void startBuildRoutingInfo() {
        this.state = ProtocolState.BUILD_ROUTING_INFO;

        System.out.println("START BUILDING ROUTING INFO");

        if (feedbackMessagesSet.size() > 0) {
            buildNetworkNeighborsTable();
            edges = (HashSet) verifyNetworkNeighborsTableAndGetEdges();
            if (edges != null) {
                if (edges.size() > 0) {
                    computeForwardingTables();
                }
            }
        }
    }

    /**
     * 
     */
    private void buildNetworkNeighborsTable() {
        tableOfNetworkNeighbors.clear();
        tableOfNetworkNodes.clear();

        for (Object message : feedbackMessagesSet) {
            FDBKMsg m = (FDBKMsg) message;
            int idOfNode = m.getPathInfo().id;
            byte[] MACRNode = cloneMAC(m.getPathInfo().MACRx);
            /* construir uma tabela com os nos da rede*/
            tableOfNetworkNodes.put(idOfNode, MACRNode);
            tableOfNetworkNeighbors.put(idOfNode, m.getNbrInfo().macs);

        }
        if (getNode().isSinkNode()) {
            tableOfNetworkNodes.put((int) getNode().getId(), myMACR);
            Vector v = new Vector();
            for (Object key : neighboorsSet.keySet()) {
                v.add(new MACS(((Integer) key).intValue(), cloneMAC((byte[]) neighboorsSet.get(key))));
            }
            tableOfNetworkNeighbors.put((int) getNode().getId(), v);
        }

    }

    /**
     * 
     */
    private Set verifyNetworkNeighborsTableAndGetEdges() {
        /* It's necessary to compare MACRx received back from each node
         * with MACRx reported by neighbors, if x is neighbor from y
         * than y must report x as a neighbor too
         */
        Hashtable neighborhoodTable = new Hashtable();
        edges = new HashSet();
        vertix = new HashSet();

        for (Object key : tableOfNetworkNeighbors.keySet()) {
            Vector neighbors = (Vector) tableOfNetworkNeighbors.get(key);
            for (Object neighbor : neighbors) {
                MACS n = (MACS) neighbor;
                byte[] MACRxReported = (byte[]) tableOfNetworkNodes.get(n.id);
                if (MACRxReported != null) {
                    if (Arrays.equals(MACRxReported, n.MACR)) {
                        /* if reported MAC is equal to MACR knowned by neighbor
                        thats a good start */
                        if (neighborhoodTable.get(key) == null) {
                            neighborhoodTable.put(key, new Vector());
                        }
                        Vector v = (Vector) neighborhoodTable.get(key);
                        v.add(n.id);
                        int k = ((Integer) key).intValue();
                        neighborhoodTable.put(k, v);
                    } else {
                        // this could be a case of intrusion or a tampering attack
                        System.out.println("MCR doesn't match:key: " + key + " " + INSENSFunctions.toHex(MACRxReported) + ",n.id: " + n.id + " " + INSENSFunctions.toHex(n.MACR));
                    }
                } else {
                    // is means that the baseStation doesn't receive a feedback
                    // message from this node so we don't have a MAC to validate
                    // against the neighbor info
                }
            }
        }

        for (Object node1 : neighborhoodTable.keySet()) {
            Vector neighbors = (Vector) neighborhoodTable.get(node1);
            for (Object neighbor : neighbors) {
                Vector otherNeighbors = (Vector) neighborhoodTable.get(neighbor);
                if (otherNeighbors != null) {
                    /*node x said that have y as neigboor and y must confirm that information*/
                    if (otherNeighbors.contains(node1)) {
                        int v1 = ((Integer) node1).intValue();
                        int v2 = ((Integer) neighbor).intValue();
                        edges.add(new Edge(v1, v2));
                        vertix.add(v1);
                        vertix.add(v2);
                    }
                }
            }
        }
        return edges;
    }

    /**
     * 
     * @param edges
     */
    protected void printEdges(HashSet edges) {
        for (Object object : edges) {
            Edge e = (Edge) object;
            System.out.println(e.node1 + "," + e.node2);
        }
    }

    /**
     *
     * @param tableOfNetworkNeighbors
     */
    protected void dumpTableOfNetworkNeighbors(Hashtable tableOfNetworkNeighbors) {
        if (tableOfNetworkNeighbors == null) {
            return;
        }
        for (Object key : tableOfNetworkNeighbors.keySet()) {
            System.out.print("Node " + key + ": ");
            Vector v = (Vector) tableOfNetworkNeighbors.get(key);
            for (Object object : v) {
                MACS m = (MACS) object;
                System.out.print("," + m.id);
            }
            System.out.print("\n");
        }
    }

    /**
     * Calculate Paths using
     * @param graph
     * @param nodeTable
     * @param numberOfNodes
     * @param fromNode
     */
    private void getNodeDijkstraPaths(WeightedGraph graph, Vector nodeTable, int numberOfNodes, int fromNode) {
        final int fromNodePosition = nodeTable.indexOf(fromNode);

        final int[] pred = Dijkstra.dijkstra(graph, fromNodePosition);

        for (int n = 0; n < numberOfNodes; n++) {
            if (n != fromNodePosition) {

                Dijkstra.printPath(graph, pred, fromNodePosition, n);
            }
        }
    }

    /**
     *
     */
    private void createForwardingTables() {
    }

    /**
     * 
     */
    private void sendUpdateMessages() {
    }

    private String getNodeID() {
        return "[" + getNode().getId() + "]";
    }

    private long getTime() {
        return getNode().getSimulator().getSimulationTime();
    }

    /**
     * |------|------|-----|--------------------------|
     *   INSENSMessage   IDbs   OWS   MAC(Kbs,INSENSMessage||IDbs||OWS)
     * |------|------|-----|--------------------------|
     * @param origId
     * @param ows
     * @param macKey
     * @return
     */
    byte[] createPayloadRREQ(long ows, short size, byte[] path, byte[] mac_parent) {
        try {

            ByteArrayDataOutputStream bados = new ByteArrayDataOutputStream();
            // type
            bados.write(INSENSConstants.MSG_RREQ);
            //ID
            bados.writeShort(getNode().getId());
            // ows
            bados.writeLong(ows);
            size++;
            bados.writeShort(size);

            if (size > 1) {
                bados.write(path);
            }
            // append id to path
            bados.writeShort(getNode().getId());

            bados.write(CryptoFunctions.createMAC(bados.toByteArray(), getINSENSNode().getMacKey()));
            bados.flush();
            return bados.toByteArray();

        } catch (IOException ex) {
            Logger.getLogger(INSENSRoutingLayer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * 
     * @return
     */
    byte[] createPayloadFDBK() {
        try {
            ByteArrayDataOutputStream bados = new ByteArrayDataOutputStream();
            ByteArrayDataOutputStream data4mac = new ByteArrayDataOutputStream();
            // type
            bados.writeByte(INSENSConstants.MSG_FDBK);
            data4mac.writeByte(INSENSConstants.MSG_FDBK);
            // ows
            bados.writeLong(parentRREQMsg.ows);
            data4mac.writeLong(parentRREQMsg.ows);
            //parent_info
            bados.write(parentRREQMsg.mac);
            //// path_info
            // my id
            bados.writeShort(getNode().getId());
            data4mac.writeShort(getNode().getId());
            //path size
            bados.writeShort(parentRREQMsg.size);
            data4mac.writeShort(parentRREQMsg.size);
            //path
            bados.write(parentRREQMsg.path);
            data4mac.write(parentRREQMsg.path);
            // myMac
            bados.write(myMACR);
            data4mac.write(myMACR);
            //// nbr_info
            //size
            bados.writeShort((short) neighboorsSet.size());
            data4mac.writeShort((short) neighboorsSet.size());
            for (Object key : neighboorsSet.keySet()) {
                Short id = (Short) key;
                byte[] mac = (byte[]) neighboorsSet.get(key);
                bados.writeShort(id.shortValue());
                bados.write(mac);
                data4mac.writeShort(id.shortValue());
                data4mac.write(mac);
            }

            byte[] data = data4mac.toByteArray();
            byte[] mac_data = CryptoFunctions.createMAC(data, getINSENSNode().getMacKey());
            bados.write(mac_data);
             System.out.println("========= CREATE FEEDBACK");
            System.out.println(getNodeID()+"MyParent:" + parentRREQMsg.id);
            System.out.println(getNodeID()+"MyParentMAC:" + INSENSFunctions.toHex(parentRREQMsg.mac));

//            System.out.println("Key Used from node " + getNodeID() +": " + INSENSFunctions.toHex(getINSENSNode().getMacKey()));
//            System.out.println("Message DATA: "+INSENSFunctions.toHex(data));
//            System.out.println("Message MAC: "+INSENSFunctions.toHex(mac_data));



//            System.out.println(getNodeID()+" Payload " + INSENSFunctions.toHex(bados.toByteArray()));
//            System.out.println("Key Used from node " + getNodeID() +": " + INSENSFunctions.toHex(getINSENSNode().getMacKey()));
//            System.out.println("Message DATA: "+INSENSFunctions.toHex(data));
//            System.out.println("Message MAC: "+INSENSFunctions.toHex(mac_data));
            return bados.toByteArray();

        } catch (IOException ex) {
            Logger.getLogger(INSENSRoutingLayer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * 
     * @param message
     * @return
     */
    private byte[] createPayloadForForwardFDBK(INSENSMessage message) {
        byte[] new_payload = Arrays.copyOf(message.getPayload(), message.getPayload().length);
        System.arraycopy(parentRREQMsg.mac, 0, new_payload, INSENSConstants.BYTE_SIZE + INSENSConstants.LONG_SIZE, parentRREQMsg.mac.length);
        return new_payload;
    }

    /**
     *
     * @return
     */
    INSENSNode getINSENSNode() {
        return (INSENSNode) getNode();
    }

    private byte[] extractMACFromPayload(byte[] payload) {
        byte[] mac = new byte[CryptoFunctions.MAC_SIZE];
        return Arrays.copyOfRange(payload, payload.length - CryptoFunctions.MAC_SIZE - 1, payload.length - 1);
    }

    /**
     * 
     */
    class RREQData {

        byte type;
        short size;
        short id;
        long ows;
        byte[] path, mac;

        public RREQData(byte[] payload) {
            try {
                ByteArrayDataInputStream badis = new ByteArrayDataInputStream(payload);
                type = badis.readByte();
                id = badis.readShort();
                ows = badis.readLong();
                size = badis.readShort();
                path = new byte[size * INSENSConstants.SHORT_SIZE];
                badis.read(path);
                mac = extractMACFromPayload(payload);
            } catch (IOException ex) {
                Logger.getLogger(INSENSRoutingLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 
     */
    class FDBKData {

        byte type;
        long ows;
        byte[] parent_info;
        short path_id;
        short path_size;
        byte[] path;
        byte[] path_mac;
        short nbr_info_size;
        byte[] nbr_info;
        byte[] mac;

        public FDBKData(byte[] payload) {
            try {
                ByteArrayDataInputStream badis = new ByteArrayDataInputStream(payload);
                type = badis.readByte();
                ows = badis.readLong();

                parent_info = new byte[CryptoFunctions.MAC_SIZE];
                badis.read(parent_info);

                path_id = badis.readShort();

                path_size = badis.readShort();

                path = new byte[path_size * INSENSConstants.SHORT_SIZE];
                badis.read(path);

                path_mac = new byte[CryptoFunctions.MAC_SIZE];
                badis.read(path_mac);

                nbr_info_size = badis.readShort();

                nbr_info = new byte[(INSENSConstants.SHORT_SIZE + CryptoFunctions.MAC_SIZE) * nbr_info_size];

                badis.read(nbr_info);

                mac = new byte[CryptoFunctions.MAC_SIZE];
                badis.read(mac);

            } catch (IOException ex) {
                Logger.getLogger(INSENSRoutingLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    byte getMessageType(byte[] payload) {
        try {
            return (new ByteArrayDataInputStream(payload)).readByte();
        } catch (IOException ex) {
            Logger.getLogger(INSENSRoutingLayer.class.getName()).log(Level.SEVERE, null, ex);
            return INSENSConstants.INVALID_TYPE;
        }
    }

    private String getTimeAndNodeId() {
        return getTime() + getNodeID();
    }
}
