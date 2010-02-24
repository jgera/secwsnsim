package pt.unl.fct.di.mei.securesim.test.broadcast;

import java.awt.Color;
import java.awt.Graphics;
import pt.unl.fct.di.mei.securesim.engine.Event;

import pt.unl.fct.di.mei.securesim.engine.ISimulationDisplay;
import pt.unl.fct.di.mei.securesim.engine.Simulator;
import pt.unl.fct.di.mei.securesim.engine.nodes.Node;
import pt.unl.fct.di.mei.securesim.engine.radio.RadioModel;
import pt.unl.fct.di.mei.securesim.ui.IDisplayable;
import pt.unl.fct.di.mei.securesim.network.nodes.SimpleNode;

public class BroadcastNode extends SimpleNode implements IDisplayable {
    private static int CLEAR_TIME=Simulator.ONE_SECOND*10;

    public BroadcastNode(Simulator sim, RadioModel radioModel) {
        super(sim, radioModel);
        setRoutingLayer(new BroadcastRoutingLayer());
    }
    /** This field is true if this mote rebroadcasted the message already. */
    boolean sent = false;
    /** This field stores the mote from which the message was first received. */
    private Node parent = null;

    /**
     * Draws a filled circle, which is: <br>
     *  - blue if the node is sending a message <br>
     *  - red if the node received a corrupted message <br>
     *  - green if the node received a message without problems <br>
     *  - pink if the node sent a message <br>
     *  - and black as a default<br>
     * It also draws a line between mote and its parent, which is another mote
     * who sent the message first to this.
     */
    @Override
    public void displayOn(ISimulationDisplay disp) {
        Graphics g = disp.getGraphics();

        int _x = disp.x2ScreenX(this.getX());
        int _y = disp.y2ScreenY(this.getY());

        super.displayOn(disp);
        if (turnedOn) {
            

            Color c = g.getColor();
            if (getId() == 1) {
                c = Color.yellow;
            } else if (sending) {
                c = Color.blue;
            } else if (receiving) {
                if (corrupted) {
                    c = Color.red;
                } else {
                    c = Color.green;
                }
            } else {
                if (sent) {
                    c = Color.pink;
                } else {
                    c = Color.CYAN;
                }
            }
            if (parent != null) {
                g.setColor(Color.black);
                int x1 = disp.x2ScreenX(parent.getX());
                int y1 = disp.y2ScreenY(parent.getY());
                g.drawLine((int) _x, (int) _y, x1, y1);
            }
            getGraphicNode().setBackcolor(c);
            getGraphicNode().paint(disp);
        }else{
            getGraphicNode().setBackcolor(Color.WHITE);
            getGraphicNode().paint(disp);
        }

    }

    public void sentMenssage(boolean b) {
        sent = true;
//        if(getId()==1 ){
//            simulator.addEvent(new ResendMessageEvent(simulator.getSimulationTime()+(CLEAR_TIME*2) ));
//        }
//        simulator.addEvent(new ClearSentEvent(CLEAR_TIME ));
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

 class ResendMessageEvent extends Event{

        @Override
        public void execute() {
            sent=false;
            parent = null;
//            sendMessageFromApplication(message, (Application)applications.values().toArray()[0]);
            sendMessageFromApplication(message, application);
            System.out.println("Resending Message: " +getId());
        }

        public ResendMessageEvent(long time) {
            super(time);
        }

        public ResendMessageEvent() {
            super();
        }
    }

    class ClearSentEvent extends Event{

        @Override
        public void execute() {
            sent=false;
            parent = null;
        }

        public ClearSentEvent(long time) {
            super(time);
        }

        public ClearSentEvent() {
            super();
        }
    }

}
