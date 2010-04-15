package org.mei.securesim.platform.ui;

import java.io.IOException;
import org.mei.securesim.core.energy.listeners.EnergyEvent;
import org.mei.securesim.gui.GraphicPoint;
import org.mei.securesim.gui.GraphicNode;
import org.mei.securesim.core.nodes.basic.SensorNode;
import org.mei.securesim.core.engine.Simulator;
import org.mei.securesim.core.ui.ISimulationDisplay;
import org.mei.securesim.core.engine.SimulatorFinishListener;
import org.jdesktop.application.Action;
import org.jdesktop.application.Task;
import org.mei.securesim.core.engine.events.SimulatorEvent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.PipedOutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.math.stat.descriptive.SummaryStatistics;



import org.mei.securesim.core.energy.Batery;
import org.mei.securesim.core.energy.listeners.EnergyListener;
import org.mei.securesim.core.nodes.factories.NodeFactory;
import org.mei.securesim.core.nodes.Node;
import org.mei.securesim.platform.instruments.energy.EnergyWatcherThread;
import org.mei.securesim.components.simulation.Simulation;
import org.mei.securesim.components.simulation.SimulationConfiguration;
import org.mei.securesim.components.simulation.SimulationFactory;
import org.mei.securesim.components.simulation.basic.BasicSimulation;
import org.mei.securesim.components.topology.RandomTopologyManager;
import org.mei.securesim.platform.PlatformView;
import org.mei.securesim.platform.charts.ui.ChartPanel;
import org.mei.securesim.platform.ui.frames.NodePropertiesDialog;

/**
 *
 * @author posilva
 */
public class SimulationPanel extends javax.swing.JPanel implements ISimulationDisplay, SimulatorFinishListener {

    public static final int OFFSET_NETWORK = 0;
    /**
     * MAIN VARIABLES
     */
    private Simulation simulation;
    private SimulationFactory simulationFactory;
    /**
     * GRAPHIC HANDLING VARIABLES
     */
    Vector<GraphicNode> selectedNodes = new Vector<GraphicNode>();
    private Graphics currentGraphics;
    private GraphicPoint pressedPoint = null;
    private GeneralPath selectedArea;
    private int mouseX;
    private int mouseY;
    private GraphicNode currentSelectedNode;
    private String[] nodeInfo = null;
    /**
     * STATE VARIABLES
     */
    private boolean selectionTool = false;
    private boolean paintMouseCoordinates = false;
    private boolean networkBuilded = false;
    private boolean networkDeployed = false;
    private boolean networkRunned = false;
    private boolean resizeSimulatedArea = true;
    private boolean visibleMouseCoordinates = false;
    private boolean deployNodeToolSelected = false;
    private boolean paintNodesInfo = false;
    private boolean selectionPointerToolSelected = false;
    /**
     * UTILS VARIABLES
     */
    BufferedImage backImage = null;
    private boolean mouseDrag;

    /**
     * CONSTRUCTORS
     */
    public SimulationPanel() {
        initComponents();
        try {
            loadImage();
        } catch (Exception ex) {
            Logger.getLogger(SimulationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Settings for the simulation
     * @param s
     */
    public void settingSimulation(SimulationFactory sf) {
        this.simulationFactory = sf;
        clearSimulation();

    }

    /**
     * Clear Simulation
     * @return
     */
    void clearSimulation() {
        try {
            this.simulation = this.simulationFactory.getNewInstance();
            simulation.setDisplay(this);
            initSimulation();

        } catch (InstantiationException ex) {
            Logger.getLogger(SimulationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SimulationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void initSimulation() {
        Simulator.randomGenerator.reset();
        Node.resetCouter();
        simulation.setDisplay(this);
        simulation.preInit();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentSelectedNodePopupMenu = new javax.swing.JPopupMenu();
        selNodeVisualizacao = new javax.swing.JMenu();
        selNodeVerVizinhos = new javax.swing.JCheckBoxMenuItem();
        selNodeVerID = new javax.swing.JCheckBoxMenuItem();
        selNodeVerOsQueMeConhecem = new javax.swing.JCheckBoxMenuItem();
        selNodeMarcar = new javax.swing.JCheckBoxMenuItem();
        selNodeOperacao = new javax.swing.JMenu();
        selNodeOnOff = new javax.swing.JCheckBoxMenuItem();
        selNodeMonitorizacao = new javax.swing.JMenu();
        selNodeMonitEnergia = new javax.swing.JMenuItem();
        selNodeRunEvent = new javax.swing.JMenuItem();
        selNodeShowProperties = new javax.swing.JMenuItem();
        selectionToolPopupMenu = new javax.swing.JPopupMenu();
        selNodesVisualizacao = new javax.swing.JMenu();
        selNodesVerVizinhos = new javax.swing.JCheckBoxMenuItem();
        selNodesVerID = new javax.swing.JCheckBoxMenuItem();
        selNodesVerOsQueMeConhecem = new javax.swing.JCheckBoxMenuItem();
        selNodesOperacao = new javax.swing.JMenu();
        selNodesOnOff = new javax.swing.JCheckBoxMenuItem();
        selNodesMonitorizacao = new javax.swing.JMenu();
        selNodesMonitEnergia = new javax.swing.JMenuItem();
        selNodesShowProperties = new javax.swing.JMenuItem();
        deployNodesPopupMenu = new javax.swing.JPopupMenu();
        depNodesDeploy = new javax.swing.JMenu();
        depNodesRandomTopology = new javax.swing.JMenuItem();
        depNodesGridTopology = new javax.swing.JMenuItem();

        currentSelectedNodePopupMenu.setLabel("Configurar Sensor");

        selNodeVisualizacao.setText("Visualização");

        selNodeVerVizinhos.setSelected(true);
        selNodeVerVizinhos.setText("Ver Vizinhos");
        selNodeVerVizinhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodeVerVizinhosActionPerformed(evt);
            }
        });
        selNodeVisualizacao.add(selNodeVerVizinhos);

        selNodeVerID.setSelected(true);
        selNodeVerID.setText("Ver ID");
        selNodeVerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodeVerIDActionPerformed(evt);
            }
        });
        selNodeVisualizacao.add(selNodeVerID);

        selNodeVerOsQueMeConhecem.setSelected(true);
        selNodeVerOsQueMeConhecem.setText("Os que me conhecem");
        selNodeVerOsQueMeConhecem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodeVerOsQueMeConhecemActionPerformed(evt);
            }
        });
        selNodeVisualizacao.add(selNodeVerOsQueMeConhecem);

        selNodeMarcar.setSelected(true);
        selNodeMarcar.setText("Marcar");
        selNodeMarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodeMarcarActionPerformed(evt);
            }
        });
        selNodeVisualizacao.add(selNodeMarcar);

        currentSelectedNodePopupMenu.add(selNodeVisualizacao);

        selNodeOperacao.setText("Operação");

        selNodeOnOff.setSelected(true);
        selNodeOnOff.setText("On");
        selNodeOnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodeOnOffActionPerformed(evt);
            }
        });
        selNodeOperacao.add(selNodeOnOff);

        currentSelectedNodePopupMenu.add(selNodeOperacao);

        selNodeMonitorizacao.setText("Monitorização");

        selNodeMonitEnergia.setText("Energia");
        selNodeMonitEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodeMonitEnergiaActionPerformed(evt);
            }
        });
        selNodeMonitorizacao.add(selNodeMonitEnergia);

        currentSelectedNodePopupMenu.add(selNodeMonitorizacao);

        selNodeRunEvent.setText("Run application");
        selNodeRunEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodeRunEventActionPerformed(evt);
            }
        });
        currentSelectedNodePopupMenu.add(selNodeRunEvent);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(org.mei.securesim.platform.PlatformApp.class).getContext().getActionMap(SimulationPanel.class, this);
        selNodeShowProperties.setAction(actionMap.get("ShowNodeProperties")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(org.mei.securesim.platform.PlatformApp.class).getContext().getResourceMap(SimulationPanel.class);
        selNodeShowProperties.setText(resourceMap.getString("selNodeShowProperties.text")); // NOI18N
        selNodeShowProperties.setToolTipText(resourceMap.getString("selNodeShowProperties.toolTipText")); // NOI18N
        currentSelectedNodePopupMenu.add(selNodeShowProperties);

        selNodesVisualizacao.setText("Visualização");

        selNodesVerVizinhos.setSelected(true);
        selNodesVerVizinhos.setText("Ver Vizinhos");
        selNodesVerVizinhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodesVerVizinhosActionPerformed(evt);
            }
        });
        selNodesVisualizacao.add(selNodesVerVizinhos);

        selNodesVerID.setSelected(true);
        selNodesVerID.setText("Ver ID");
        selNodesVerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodesVerIDActionPerformed(evt);
            }
        });
        selNodesVisualizacao.add(selNodesVerID);

        selNodesVerOsQueMeConhecem.setSelected(true);
        selNodesVerOsQueMeConhecem.setText("Os que me conhecem");
        selNodesVerOsQueMeConhecem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodesVerOsQueMeConhecemActionPerformed(evt);
            }
        });
        selNodesVisualizacao.add(selNodesVerOsQueMeConhecem);

        selectionToolPopupMenu.add(selNodesVisualizacao);

        selNodesOperacao.setText("Operação");

        selNodesOnOff.setSelected(true);
        selNodesOnOff.setText("On");
        selNodesOnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodesOnOffActionPerformed(evt);
            }
        });
        selNodesOperacao.add(selNodesOnOff);

        selectionToolPopupMenu.add(selNodesOperacao);

        selNodesMonitorizacao.setText("Monitorização");

        selNodesMonitEnergia.setText("Energia");
        selNodesMonitEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selNodesMonitEnergiaActionPerformed(evt);
            }
        });
        selNodesMonitorizacao.add(selNodesMonitEnergia);

        selectionToolPopupMenu.add(selNodesMonitorizacao);

        selNodesShowProperties.setAction(actionMap.get("ShowNodesProperties")); // NOI18N
        selNodesShowProperties.setText(resourceMap.getString("selNodesShowProperties.text")); // NOI18N
        selNodesShowProperties.setToolTipText(resourceMap.getString("selNodesShowProperties.toolTipText")); // NOI18N
        selectionToolPopupMenu.add(selNodesShowProperties);

        depNodesDeploy.setText(resourceMap.getString("depNodesDeploy.text")); // NOI18N

        depNodesRandomTopology.setAction(actionMap.get("deployNodesUsingRandomTopology")); // NOI18N
        depNodesRandomTopology.setText(resourceMap.getString("depNodesRandomTopology.text")); // NOI18N
        depNodesRandomTopology.setToolTipText(resourceMap.getString("depNodesRandomTopology.toolTipText")); // NOI18N
        depNodesDeploy.add(depNodesRandomTopology);

        depNodesGridTopology.setAction(actionMap.get("deployNodesGridTopology")); // NOI18N
        depNodesGridTopology.setText(resourceMap.getString("depNodesGridTopology.text")); // NOI18N
        depNodesGridTopology.setToolTipText(resourceMap.getString("depNodesGridTopology.toolTipText")); // NOI18N
        depNodesDeploy.add(depNodesGridTopology);

        deployNodesPopupMenu.add(depNodesDeploy);

        setBackground(resourceMap.getColor("background")); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        updateMouseCoordinates(evt);
        if (deployNodeToolSelected) {
            if (evt.getButton() == 0) {
                if (isMousePressed()) {
                    drawSelectedArea(evt);
                }
                update();
            }


        } else if (selectionTool) {
            if (simulation.getSimulator() == null) {
                return;
            }
            if (evt.getButton() == 0) {
                if (isMousePressed()) {
                    drawSelectedArea(evt);
                    selectedNodes.clear();

                    for (Node node : simulation.getSimulator().getNodes()) {
                        GraphicNode circle = node.getGraphicNode();
                        boolean isSelected = selectedArea.contains(new Point(circle.getX(), circle.getY()));
                        circle.select(isSelected);
                        if (isSelected) {
                            selectedNodes.add(circle);
                        }
                    }
                }
                update();
            }
        } else if(selectionPointerToolSelected){
            mouseDrag=true;
            if (currentSelectedNode != null) {
//                if(currentSelectedNode.contains(evt.getX(), evt.getY()))
                currentSelectedNode.moveTo(mouseX, mouseY);
                update();
            }
        }

    }//GEN-LAST:event_formMouseDragged
    /**
     * 
     * @param evt
     */
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        updateMouseCoordinates(evt);
        if (!selectionTool) {
            if (simulation.getSimulator() != null) {
                GraphicNode c = selectedCircle(evt);
                if (c != null) {
                    nodeInfo = c.getPhysicalNode().getInfo();
                } else {
                    nodeInfo = null;
                }

            }
        }
        update();

    }

    /**
     * 
     * @param evt
     * @return
     */
    private GraphicNode selectedCircle(MouseEvent evt) {
        if (simulation.getSimulator() == null) {
            return null;
        }
        if (deployNodeToolSelected) {
            return null;
        }

        GraphicNode circle = null;
        GraphicNode circleSelected = null;
        for (Node node : simulation.getSimulator().getNodes()) {
            circle = node.getGraphicNode();
            circle.select(false);
            if (circle.contains(mouseX, mouseY)) {
                circle.select(true);
                circleSelected = circle;
            }
        }

        return circleSelected;
    }

    @Override
    public void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        mainPaintLoop(grphcs);
    }//GEN-LAST:event_formMouseMoved
    /**
     *
     * @param evt
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        updateMouseCoordinates(evt);

        if (selectionTool) {
            /**
             * Done nothing
             * 
             */
        } else if (selectionPointerToolSelected) {
            if (evt.getButton() == MouseEvent.BUTTON1) {
                currentSelectedNode = null;
                currentSelectedNode = selectedCircle(evt);
                if (evt.getClickCount() > 1) {
                    if (currentSelectedNode != null) {
//                        showNodeProperties();
                    }
                } else {
                }

            } else if (evt.getButton() == MouseEvent.BUTTON3) {

                currentSelectedNode = null;
                currentSelectedNode = selectedCircle(evt);

                if (currentSelectedNode != null) {
                    SensorNode s = SensorNode.cast(currentSelectedNode.getPhysicalNode());
                    selNodeVerID.setSelected(s.isShowID());
                    selNodeVerVizinhos.setSelected(s.isPaintNeighborhoodDst());
                    selNodeOnOff.setSelected(s.isTurnedOn());
                    selNodeMarcar.setSelected(currentSelectedNode.isMarked());
                    currentSelectedNodePopupMenu.show(this, mouseX, mouseY);
                }

            }
        }
    }//GEN-LAST:event_formMouseClicked

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        visibleMouseCoordinates = true;
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        visibleMouseCoordinates = false;
    }//GEN-LAST:event_formMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        updateMouseCoordinates(evt);
        if (selectionTool) {
            if (insideSelectionArea(evt) && evt.getButton() == MouseEvent.BUTTON3) {
                selectionToolPopupMenu.show(this, mouseX, mouseY);
            } else {
                clearSelection();
                pressedPoint = new GraphicPoint(mouseX, mouseY);
            }
        } else if (deployNodeToolSelected) {
            if (insideSelectionArea(evt) && evt.getButton() == MouseEvent.BUTTON3) {
                deployNodesPopupMenu.show(this, mouseX, mouseY);
            } else {
                clearSelection();
                pressedPoint = new GraphicPoint(mouseX, mouseY);
            }
        } else if (selectionPointerToolSelected) {
        }


    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        updateMouseCoordinates(evt);
        mouseDrag=false;
        pressedPoint = null;
        //selectedArea = null;
        currentSelectedNode=null;
        update();
    }//GEN-LAST:event_formMouseReleased

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        resizeUpdateSimulatedArea();
        update();
    }//GEN-LAST:event_formComponentResized

    private void selNodeVerVizinhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodeVerVizinhosActionPerformed
        if (currentSelectedNode != null) {
            JCheckBoxMenuItem m = (JCheckBoxMenuItem) evt.getSource();
            ((SensorNode) currentSelectedNode.getPhysicalNode()).setPaintNeighborhood(m.isSelected());
            update();
        }
    }//GEN-LAST:event_selNodeVerVizinhosActionPerformed

    private void selNodeVerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodeVerIDActionPerformed
        if (currentSelectedNode != null) {
            JCheckBoxMenuItem m = (JCheckBoxMenuItem) evt.getSource();
            ((SensorNode) currentSelectedNode.getPhysicalNode()).setShowID(m.isSelected());
            update();
        }
    }//GEN-LAST:event_selNodeVerIDActionPerformed

    private void selNodeOnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodeOnOffActionPerformed
        if (currentSelectedNode != null) {
            JCheckBoxMenuItem m = (JCheckBoxMenuItem) evt.getSource();
            if (m.isSelected()) {
                ((SensorNode) currentSelectedNode.getPhysicalNode()).powerOn();
            } else {
                ((SensorNode) currentSelectedNode.getPhysicalNode()).shutdown();
            }

            update();
        }
    }//GEN-LAST:event_selNodeOnOffActionPerformed

    private void selNodesVerVizinhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodesVerVizinhosActionPerformed
        if (selectionTool) {
            if (selectedNodes != null) {
                JCheckBoxMenuItem m = (JCheckBoxMenuItem) evt.getSource();
                for (GraphicNode selNode : selectedNodes) {
                    ((SensorNode) selNode.getPhysicalNode()).setPaintNeighborhood(m.isSelected());
                }
                update();
            }
        }
    }//GEN-LAST:event_selNodesVerVizinhosActionPerformed

    private void selNodesVerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodesVerIDActionPerformed
        if (selectionTool) {
            if (selectedNodes != null) {
                JCheckBoxMenuItem m = (JCheckBoxMenuItem) evt.getSource();
                for (GraphicNode selNode : selectedNodes) {
                    ((SensorNode) selNode.getPhysicalNode()).setShowID(m.isSelected());
                }
                update();
            }
        }
    }//GEN-LAST:event_selNodesVerIDActionPerformed

    private void selNodesOnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodesOnOffActionPerformed
        if (selectionTool) {
            if (selectedNodes != null) {
                JCheckBoxMenuItem m = (JCheckBoxMenuItem) evt.getSource();
                for (GraphicNode selNode : selectedNodes) {
                    if (m.isSelected()) {
                        ((SensorNode) selNode.getPhysicalNode()).powerOn();
                    } else {
                        ((SensorNode) selNode.getPhysicalNode()).shutdown();
                    }
                }

                update();
            }
        }

    }//GEN-LAST:event_selNodesOnOffActionPerformed

    private void selNodesVerOsQueMeConhecemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodesVerOsQueMeConhecemActionPerformed
        if (selectionTool) {
            if (selectedNodes != null) {
                JCheckBoxMenuItem m = (JCheckBoxMenuItem) evt.getSource();
                for (GraphicNode selNode : selectedNodes) {
                    ((SensorNode) selNode.getPhysicalNode()).setPaintNeighborhoodOrg(m.isSelected());
                }
                update();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_selNodesVerOsQueMeConhecemActionPerformed

    private void selNodeVerOsQueMeConhecemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodeVerOsQueMeConhecemActionPerformed
        if (currentSelectedNode != null) {
            JCheckBoxMenuItem m = (JCheckBoxMenuItem) evt.getSource();
            ((SensorNode) currentSelectedNode.getPhysicalNode()).setPaintNeighborhoodOrg(m.isSelected());
            update();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_selNodeVerOsQueMeConhecemActionPerformed

    private void selNodeMonitEnergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodeMonitEnergiaActionPerformed
//        EnergyController ec;
//        if (currentSelectedNode != null) {
//            JMenuItem m = (JMenuItem) evt.getSource();
//            Node n = currentSelectedNode.getPhysicalNode();
//            if (!energyControllersTable.contains(n)) {
//                ec = new EnergyController();
//                n.getBateryEnergy().addEnergyListener(ec);
//                energyControllersTable.put(n, ec);
//                ec.start();
//            }
//            if (!nodeenergyWatchers.contains(n)) {
//                displayNewChartFrame(n);
//
//            }
//


        createEnergyWatcher(new Object[]{currentSelectedNode});

//            EnergyHook eh = EnergyHook.hookToNode(n, 100, true);
//
        update();
//        }

    }//GEN-LAST:event_selNodeMonitEnergiaActionPerformed

    private void selNodeMarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodeMarcarActionPerformed
        if (currentSelectedNode != null) {
            JMenuItem m = (JMenuItem) evt.getSource();
            if (!currentSelectedNode.isMarked()) {
                currentSelectedNode.mark();
            } else {
                currentSelectedNode.unmark();
            }
            update();
        }

    }//GEN-LAST:event_selNodeMarcarActionPerformed

    private void selNodesMonitEnergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodesMonitEnergiaActionPerformed
        // TODO add your handling code here:

        createEnergyWatcher(selectedNodes.toArray());

    }//GEN-LAST:event_selNodesMonitEnergiaActionPerformed

    private void selNodeRunEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selNodeRunEventActionPerformed
        // TODO add your handling code here:
        if (currentSelectedNode != null) {
            JMenuItem m = (JMenuItem) evt.getSource();
            if (networkRunned) {
                currentSelectedNode.getPhysicalNode().getApplication().run();
            }

        }
    }//GEN-LAST:event_selNodeRunEventActionPerformed

    protected boolean isMousePressed() {
        return pressedPoint != null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu currentSelectedNodePopupMenu;
    private javax.swing.JMenu depNodesDeploy;
    private javax.swing.JMenuItem depNodesGridTopology;
    private javax.swing.JMenuItem depNodesRandomTopology;
    private javax.swing.JPopupMenu deployNodesPopupMenu;
    private javax.swing.JCheckBoxMenuItem selNodeMarcar;
    private javax.swing.JMenuItem selNodeMonitEnergia;
    private javax.swing.JMenu selNodeMonitorizacao;
    private javax.swing.JCheckBoxMenuItem selNodeOnOff;
    private javax.swing.JMenu selNodeOperacao;
    private javax.swing.JMenuItem selNodeRunEvent;
    private javax.swing.JMenuItem selNodeShowProperties;
    private javax.swing.JCheckBoxMenuItem selNodeVerID;
    private javax.swing.JCheckBoxMenuItem selNodeVerOsQueMeConhecem;
    private javax.swing.JCheckBoxMenuItem selNodeVerVizinhos;
    private javax.swing.JMenu selNodeVisualizacao;
    private javax.swing.JMenuItem selNodesMonitEnergia;
    private javax.swing.JMenu selNodesMonitorizacao;
    private javax.swing.JCheckBoxMenuItem selNodesOnOff;
    private javax.swing.JMenu selNodesOperacao;
    private javax.swing.JMenuItem selNodesShowProperties;
    private javax.swing.JCheckBoxMenuItem selNodesVerID;
    private javax.swing.JCheckBoxMenuItem selNodesVerOsQueMeConhecem;
    private javax.swing.JCheckBoxMenuItem selNodesVerVizinhos;
    private javax.swing.JMenu selNodesVisualizacao;
    private javax.swing.JPopupMenu selectionToolPopupMenu;
    // End of variables declaration//GEN-END:variables

    private void paintSelectedArea(Graphics grphcs) {
        if (!canPaintSelectionArea()) {
            return;
        }

        if (selectedArea == null) {
            return;
        }
        Graphics2D g = (Graphics2D) grphcs;
        Stroke o = g.getStroke();
        Stroke Pen1 = new BasicStroke(1.0F, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 1.0f, new float[]{3.0f, 3.0f}, 0.0f);
        g.setStroke(Pen1);
        g.draw(selectedArea);
        g.setStroke(o);
    }

    public int x2ScreenX(double x) {
        return OFFSET_NETWORK + (int) ((getSize().getWidth() - (OFFSET_NETWORK * 2)) * x / getSize().getWidth());
    }

    public int y2ScreenY(double y) {
        return OFFSET_NETWORK + (int) ((getSize().getHeight() - (OFFSET_NETWORK * 2)) * y / getSize().getHeight());
    }

    public void update() {
        JComponent parent = (JComponent) getParent();
        if (parent != null) {
            ((JComponent) getParent()).revalidate();
            ((JComponent) getParent()).repaint();
        } else {
            revalidate();
            repaint();
        }
    }

    public Simulator getSimulator() {
        return simulation.getSimulator();
    }

    @Override
    public Graphics getGraphics() {
        return currentGraphics;
    }

    public void viewVizinhos(boolean selected) {
        if (simulation.getSimulator() != null) {
            for (Node node : simulation.getSimulator().getNodes()) {
                ((SensorNode) node).setPaintNeighborhood(selected);
            }
            update();
        }
    }

    void selectionToolSelected(boolean selected) {
        selectionTool = selected;
        if (selectionTool == false) {
            clearSelection();
        }
    }

    private boolean insideSelectionArea(java.awt.event.MouseEvent evt) {
        if (selectedArea != null) {
            if (selectedArea.contains(new Point(mouseX, mouseY))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    void saveSimulation() {
        SimulationConfiguration configuration = new SimulationConfiguration();
        configuration.save(simulation);
    }

    private void clearSelection() {
        selectedArea = null;
        for (GraphicNode graphicNode : selectedNodes) {
            graphicNode.select(false);
        }
        update();
    }

    protected void loadImage() throws Exception {
        //  GoogleMaps.setApiKey("ABQIAAAAXg0F4Zi2pcwHeCjCvk7LRhSoSGvlWgPKK04fS0Rib--DYJNIihQASC7FQc_5lQHTrrgdlZoWfL-eZg");
        //   double[] lanLng = GoogleMaps.geocodeAddress("Academia da Força Aérea, Portugal");
        // backImage = ImageViewer.toBufferedImage(GoogleMaps.retrieveStaticImage(1024, 600, 38.835780, -9.334334, 19, "png32"));
    }

    public Vector<GraphicNode> getSelectedNodes() {
        return selectedNodes;
    }

    private void paintMouseCoordinates(Graphics grphcs) {
        Color c = grphcs.getColor();
        grphcs.setColor(Color.BLACK);
        grphcs.drawString(mouseX + "," + mouseY, mouseX, mouseY);
        grphcs.setColor(c);
        update();
    }

    public void buildNetwork() {
        if (!networkDeployed) {
            return;
        }
        if (simulation.getSimulator() != null) {
            simulation.getSimulator().init();
            networkBuilded = true;
            update();
        }
    }

    void viewOsQueConhecem(boolean selected) {
        if (simulation.getSimulator() != null) {
            for (Node node : simulation.getSimulator().getNodes()) {
                ((SensorNode) node).setPaintNeighborhoodOrg(selected);
            }
            update();
        }
    }

    protected Node searchForNode(int id) {
        for (Node node : simulation.getSimulator().getNodes()) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

    void searchNode(int intValue) {
        Node node = null;
        if (simulation.getSimulator() != null) {
            if (networkDeployed) {
                node = searchForNode(intValue);
                if (node != null) {
                    node.getGraphicNode().mark();
                }
            }
            update();
        }
    }

    /**
     * 
     * @param selectedNodes
     */
    private void createEnergyWatcher(Object[] selectedNodes) {

        if (selectionTool || selectionPointerToolSelected) {
            if (selectedNodes != null) {
                if (selectedNodes.length > 0) {
                    String input = JOptionPane.showInputDialog("Name of the monitoring action");
                    if (input != null) {
                        new NodesEnergyWatcher(selectedNodes, input.toUpperCase()).start();
                    }
                }
            }
        } else {
            // é necessário seleccionar ou a selection tool ou a pointer tool
        }

    }

    public void onFinish(SimulatorEvent evt) {
        JOptionPane.showMessageDialog(this, "Simulation has terminated: " + evt.toString());
    }

    void deployNodesToolSelected(boolean selected) {
        deployNodeToolSelected = selected;
    }

    void setViewNodeInfo(boolean selected) {
        paintNodesInfo = selected;
    }

    void selectionPointerSelected(boolean selected) {
        this.selectionPointerToolSelected = selected;
    }

    void startSimulation() {
        if (!networkRunned) {
            simulation.start();
            networkRunned = true;
        } else {
            simulation.resume();
        }
    }

    void stopSimulation() {
        if (networkRunned) {
            simulation.stop();
        }

    }

    void pauseSimulation() {
        if (networkRunned) {
            simulation.pause();
        }

    }

    void resumeSimulation() {
        simulation.resume();
    }

    private void showNodeProperties(Vector v) {

        if (v == null) {
            return;
        }
        if (v.size() == 0) {
            return;
        }

        NodePropertiesDialog dialog = new NodePropertiesDialog();
        dialog.showNodesProperties(v);
    }

    /**
     * 
     */
    class NodesEnergyWatcher extends Thread {

        String name = "";
        int delay = 0;   // delay for 5 sec.
        int period = 1000;  // repeat every sec.
        Vector<Node> nodes = new Vector<Node>();
        ChartFrame cf = new ChartFrame();
        ChartPanel cp =cf.getChartPanel();
        Timer timer = new Timer();

        /**
         * 
         * @param nodes
         * @param name
         */
        public NodesEnergyWatcher(Object[] nodes, String name) {
            importNodes(nodes);
            this.name = name;

            PlatformView.getInstance().addTab(name, cp);
//            cf.setTitle("Energy watcher: " + name);
//
//            cf.setPreferredSize(new Dimension(300, 200));
//
//            cf.pack();
//
//            cf.setVisible(true);
//
//            cf.addWindowListener(new WindowAdapter() {
//
//                @Override
//                public void windowClosing(WindowEvent w) {
//                    timer.cancel();
//                }
//            });

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    SummaryStatistics stat = new SummaryStatistics();
                    for (Node node : NodesEnergyWatcher.this.nodes) {

                        //double c = node.getBateryEnergy().getAverageConsumption();//.getLastConsume();//100 - (node.getBateryEnergy().getCurrentPower() * 100 / node.getBateryEnergy().getInitialPower());
                        double c = 100 - (node.getBateryEnergy().getCurrentPower() * 100 / node.getBateryEnergy().getInitialPower());
                        stat.addValue(c);
                    }
                    double x = NodesEnergyWatcher.this.nodes.get(0).getSimulator().getSimulationTimeInMillisec() / 1000;
                    cp.updateChart(x, stat.getMean());
                }
            }, delay, period);


        }

        private void importNodes(Object[] gnodes) {
            for (Object o : gnodes) {
                GraphicNode graphicNode = (GraphicNode) o;
                nodes.add(graphicNode.getPhysicalNode());
            }

        }
    }

    private boolean canPaintSelectionArea() {
        return (selectionTool || deployNodeToolSelected);
    }

    @Action
    public void deployNodesGridTopology() {
        JOptionPane.showMessageDialog(this, "Feature not implemented yet!", "", JOptionPane.WARNING_MESSAGE);
    }

    @Action(block = Task.BlockingScope.COMPONENT)
    public Task deployNodesUsingRandomTopology() {
        return new DeployNodesUsingRandomTopologyTask(org.jdesktop.application.Application.getInstance(org.mei.securesim.platform.PlatformApp.class));
    }

    public class DeployNodesUsingRandomTopologyTask extends org.jdesktop.application.Task<Object, Void> {

        boolean ok = false;
        int nNodes = 0;
        RandomTopologyManager tm = new RandomTopologyManager();
        NodeFactory nf = simulation.getNodeFactory();
        int nRange = simulation.getNodeRange();

        DeployNodesUsingRandomTopologyTask(org.jdesktop.application.Application app) {
            super(app);
            if (selectedArea == null) {
                return;
            }
            while (!ok) {
                String sNodes = JOptionPane.showInputDialog("Number of nodes to deploy:");
                if (sNodes != null) {
                    if (NumberUtils.isNumber(sNodes)) {
                        nNodes = Integer.parseInt(sNodes);
                        if (nNodes > 0) {
                            ok = true;
                        }
                    }
                } else {
                    return;
                }
                if (!ok) {
                    JOptionPane.showMessageDialog(SimulationPanel.this, "Valor Incorrecto!");
                }
            }
        }

        @Override
        protected Object doInBackground() {
            if (!ok) {
                return null;
            }
            int status = 0;
            try {
                this.setMessage("Generating nodes using factory");
                Vector<Node> nodes = (Vector<Node>) nf.createNodes(nNodes);
                nodes = tm.apply(selectedArea.getBounds(), nodes);
                this.setProgress(status, 0, 1);



                for (Node node : nodes) {
                    status++;
                    node.getConfig().setSetRadioRange(nRange);
                    simulation.getNetwork().addNode((SensorNode) node);
                    this.setProgress(status, 0, nodes.size());
                }
            } catch (Exception ex) {
                Logger.getLogger(SimulationPanel.class.getName()).log(Level.SEVERE, null, ex);
                networkDeployed = false;
                update();
                return false;
            }

            networkDeployed = true;
            update();
            this.setMessage("Building Network using radio");
            this.setProgress(0, 0, 1);
            buildNetwork();
            update();
            return true;  // return your result
        }

        @Override
        protected void succeeded(Object result) {
            this.setMessage("Building Network done");
            this.setProgress(1, 0, 1);
        }
    }

    void paintInfo(Graphics g) {

        if (nodeInfo != null) {
            Color oldColor = g.getColor();
            Graphics2D graphics2 = (Graphics2D) g;
            Font monoFont = new Font("Times", Font.BOLD, 10);
            g.setFont(monoFont);
            FontMetrics fm = g.getFontMetrics();
            int step = fm.getMaxAscent() + fm.getMaxDescent();
            int mSize = 0;
            for (int i = 0; i < nodeInfo.length; i++) {
                String string = nodeInfo[i];
                int s = fm.charsWidth(string.toCharArray(), 0, string.length());
                if (s > mSize) {
                    mSize = s;
                }
            }

            RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(mouseX, mouseY, 10 + mSize, 10 + (nodeInfo.length * (step)), 30, 30);
            // desenha o fundo
            g.setColor(Color.lightGray);
            graphics2.fill(roundedRectangle);
            // desenha a border do rectangulo
            g.setColor(Color.BLACK);
            graphics2.draw(roundedRectangle);

            int y = mouseY + 5;
            for (int i = 0; i < nodeInfo.length; i++) {
                String string = nodeInfo[i];
                y += step;
                g.drawString(string, mouseX + 5, y);
            }
            g.setColor(oldColor);
        }
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(BasicSimulation simulation) {
        this.simulation = simulation;
    }

    /**
     *
     * PAINTING FUNCTIONS
     *
     */
    public void resizeUpdateSimulatedArea() {
        if (!resizeSimulatedArea) {
            return;
        }
    }

    public void updateMouseCoordinates(MouseEvent evt) {
        mouseX = x2ScreenX(evt.getX());
        mouseY = y2ScreenY(evt.getY());
    }

    public void paintNetwork(Graphics g) {
        if (simulation == null) {
            return;
        }
        currentGraphics = g;

        if (simulation.getSimulator() != null) {
            simulation.getSimulator().display(this);
        }
    }

    public boolean isPaintMouseCoordinates() {
        return paintMouseCoordinates;
    }

    public void setPaintMouseCoordinates(boolean paintMouseCoordinates) {
        this.paintMouseCoordinates = paintMouseCoordinates;
    }

    public void mainPaintLoop(Graphics grphcs) {
        paintNetwork(grphcs);
        if (canPaintSelectionArea()) {
            paintSelectedArea(grphcs);
        }
        if (paintMouseCoordinates && visibleMouseCoordinates) {
            paintMouseCoordinates(grphcs);
        }

        if (paintNodesInfo) {
            paintInfo(grphcs);
        }
    }

    private void paintImage(Graphics g) {
        if (backImage != null) {
            g.drawImage(backImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void drawSelectedArea(java.awt.event.MouseEvent evt) {
        if (!canPaintSelectionArea()) {
            return;
        }
        selectedArea = new GeneralPath();
        selectedArea.moveTo(pressedPoint.x(), pressedPoint.y());
        selectedArea.lineTo(mouseX, pressedPoint.y());
        selectedArea.lineTo(mouseX, mouseY);
        selectedArea.lineTo(pressedPoint.x(), mouseY);
        selectedArea.lineTo(pressedPoint.x(), pressedPoint.y());
    }

    class EnergyController implements EnergyListener {

        protected PipedOutputStream outputStream;
        protected DataOutputStream dataOutputStream;
        protected EnergyWatcherThread energyWatcherThread;

        public EnergyController() {
            energyWatcherThread = new EnergyWatcherThread();
            this.dataOutputStream = new DataOutputStream(energyWatcherThread.getOutputStream());
        }

        public void onConsume(EnergyEvent evt) {
            try {
                Batery b = (Batery) evt.getSource();
                this.dataOutputStream.writeDouble(evt.getValue());
                //this.dataOutputStream.writeDouble(b.getAverageConsumption());
                double t = evt.getTime();//b.getHostNode().getSimulator().getSimulationTimeInMillisec() / 1000;//System.nanoTime()*10E3; //
                this.dataOutputStream.writeDouble(t);
            } catch (IOException ex) {
                getLogger().log(Level.SEVERE, null, ex);
            }
        }

        public Logger getLogger() {
            return Logger.getLogger(SimulationPanel.class.getName());
        }

        private void start() {
            energyWatcherThread.start();
        }
    }

    @Action
    public void ShowNodeProperties() {
        Vector v = new Vector();
        if (currentSelectedNode != null) {
            v.add(currentSelectedNode);
        }
        showNodeProperties(v);
    }

    @Action
    public void ShowNodesProperties() {
        showNodeProperties(selectedNodes);
    }
    protected Hashtable<Node, Object> energyControllersTable = new Hashtable<Node, Object>();
}
