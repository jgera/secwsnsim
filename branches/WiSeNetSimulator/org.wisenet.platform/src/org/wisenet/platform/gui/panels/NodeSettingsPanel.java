/*
 *  Wireless Sensor Network Simulator
 *  The next generation for WSN Simulations
 */
package org.wisenet.platform.gui.panels;

import java.awt.Color;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import org.wisenet.platform.common.ui.PlatformPanel;
import org.wisenet.platform.core.PlatformManager;
import org.wisenet.platform.utils.GUI_Utils;
import org.wisenet.simulator.components.simulation.Simulation;
import org.wisenet.simulator.core.node.Node;
import org.wisenet.simulator.core.node.SensorNode;
import org.wisenet.simulator.gui.GraphicNode;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class NodeSettingsPanel extends PlatformPanel {

    private Color cFieldBackground = null;
    private Color cPaths = null;
    private Color cNeighborsLink = null;
    private Color cNodeMarked = null;
    private Color cNodeSelected = null;
    private Color cOthersLink = null;
    private Color cSelectionColor = null;

    /** Creates new form NodeSettingsPanel */
    public NodeSettingsPanel() {
        initComponents();
        loadCurrentColors();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblNodeSelected = new javax.swing.JLabel();
        cmdFieldBackground = new javax.swing.JButton();
        lblNodeMarked = new javax.swing.JLabel();
        lblPaths = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmdNodeSelected = new javax.swing.JButton();
        cmdPaths = new javax.swing.JButton();
        cmdSelectionColor = new javax.swing.JButton();
        cmdNodeMarked = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblSelectionColor = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmdOthersLink = new javax.swing.JButton();
        lblFieldBackground = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmdNeighborsLink = new javax.swing.JButton();
        lblNeighborsLink = new javax.swing.JLabel();
        lblOthersLink = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Color Properties"));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel13.setText("Parent Paths");
        jLabel13.setName("jLabel13"); // NOI18N

        lblNodeSelected.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNodeSelected.setName("lblNodeSelected"); // NOI18N
        lblNodeSelected.setOpaque(true);
        lblNodeSelected.setPreferredSize(new java.awt.Dimension(25, 25));

        cmdFieldBackground.setText("...");
        cmdFieldBackground.setName("cmdFieldBackground"); // NOI18N
        cmdFieldBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColor(evt);
            }
        });

        lblNodeMarked.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNodeMarked.setName("lblNodeMarked"); // NOI18N
        lblNodeMarked.setOpaque(true);
        lblNodeMarked.setPreferredSize(new java.awt.Dimension(25, 25));

        lblPaths.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPaths.setName("lblPaths"); // NOI18N
        lblPaths.setOpaque(true);
        lblPaths.setPreferredSize(new java.awt.Dimension(25, 25));

        jLabel1.setText("Field Background");
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel11.setText("Others Link");
        jLabel11.setName("jLabel11"); // NOI18N

        cmdNodeSelected.setText("...");
        cmdNodeSelected.setName("cmdNodeSelected"); // NOI18N
        cmdNodeSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColor(evt);
            }
        });

        cmdPaths.setText("...");
        cmdPaths.setName("cmdPaths"); // NOI18N
        cmdPaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColor(evt);
            }
        });

        cmdSelectionColor.setText("...");
        cmdSelectionColor.setName("cmdSelectionColor"); // NOI18N
        cmdSelectionColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColor(evt);
            }
        });

        cmdNodeMarked.setText("...");
        cmdNodeMarked.setName("cmdNodeMarked"); // NOI18N
        cmdNodeMarked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColor(evt);
            }
        });

        jLabel5.setText("Node Selected");
        jLabel5.setName("jLabel5"); // NOI18N

        lblSelectionColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblSelectionColor.setName("lblSelectionColor"); // NOI18N
        lblSelectionColor.setOpaque(true);
        lblSelectionColor.setPreferredSize(new java.awt.Dimension(25, 25));

        jLabel7.setText("Node Marked");
        jLabel7.setName("jLabel7"); // NOI18N

        cmdOthersLink.setText("...");
        cmdOthersLink.setName("cmdOthersLink"); // NOI18N
        cmdOthersLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColor(evt);
            }
        });

        lblFieldBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblFieldBackground.setName("lblFieldBackground"); // NOI18N
        lblFieldBackground.setOpaque(true);
        lblFieldBackground.setPreferredSize(new java.awt.Dimension(25, 25));

        jLabel3.setText("Selection Color");
        jLabel3.setName("jLabel3"); // NOI18N

        cmdNeighborsLink.setText("...");
        cmdNeighborsLink.setName("cmdNeighborsLink"); // NOI18N
        cmdNeighborsLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColor(evt);
            }
        });

        lblNeighborsLink.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNeighborsLink.setName("lblNeighborsLink"); // NOI18N
        lblNeighborsLink.setOpaque(true);
        lblNeighborsLink.setPreferredSize(new java.awt.Dimension(25, 25));

        lblOthersLink.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblOthersLink.setName("lblOthersLink"); // NOI18N
        lblOthersLink.setOpaque(true);
        lblOthersLink.setPreferredSize(new java.awt.Dimension(25, 25));

        jLabel9.setText("Neighbors Link");
        jLabel9.setName("jLabel9"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblFieldBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdFieldBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblSelectionColor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSelectionColor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblNodeSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdNodeSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblNodeMarked, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdNodeMarked, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblNeighborsLink, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdNeighborsLink, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblOthersLink, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdOthersLink, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblPaths, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdPaths, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdFieldBackground, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lblFieldBackground, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdSelectionColor, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lblSelectionColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdNodeSelected, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lblNodeSelected, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdNodeMarked, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lblNodeMarked, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdNeighborsLink, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lblNeighborsLink, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdOthersLink, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lblOthersLink, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmdPaths, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(lblPaths, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeColor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeColor

        JButton src = (JButton) evt.getSource();
        if (src.equals(cmdFieldBackground)) {
            updateColor(lblFieldBackground);
        } else if (src.equals(cmdSelectionColor)) {
            updateColor(lblSelectionColor);
        } else if (src.equals(cmdNodeSelected)) {
            updateColor(lblNodeSelected);
        } else if (src.equals(cmdNodeMarked)) {
            updateColor(lblNodeMarked);
        } else if (src.equals(cmdNeighborsLink)) {
            updateColor(lblNeighborsLink);
        } else if (src.equals(cmdOthersLink)) {
            updateColor(lblOthersLink);
        } else if (src.equals(cmdPaths)) {
            updateColor(lblPaths);
        }
        notifyChanges();
    }//GEN-LAST:event_changeColor

    @Override
    public boolean onCancel() {
        return true;
    }

    @Override
    public boolean onOK() {
        if (changed()) {
            applyColors();
        }
        return true;
    }

    @Override
    public boolean onApply() {
        return applyColors();
    }

    @Override
    protected boolean isDataValid() {
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdFieldBackground;
    private javax.swing.JButton cmdNeighborsLink;
    private javax.swing.JButton cmdNodeMarked;
    private javax.swing.JButton cmdNodeSelected;
    private javax.swing.JButton cmdOthersLink;
    private javax.swing.JButton cmdPaths;
    private javax.swing.JButton cmdSelectionColor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFieldBackground;
    private javax.swing.JLabel lblNeighborsLink;
    private javax.swing.JLabel lblNodeMarked;
    private javax.swing.JLabel lblNodeSelected;
    private javax.swing.JLabel lblOthersLink;
    private javax.swing.JLabel lblPaths;
    private javax.swing.JLabel lblSelectionColor;
    // End of variables declaration//GEN-END:variables

    private void loadCurrentColors() {
        if (PlatformManager.getInstance().haveActiveSimulation()) {
            Simulation simulation = (Simulation) PlatformManager.getInstance().getActiveSimulation();
            if (!simulation.getSimulator().isEmpty()) {
                Node node = simulation.getSimulator().getNodes().iterator().next();
                cFieldBackground = PlatformManager.getInstance().getPlatformView().getWorkbenchPanel().getSimulationPanel().getBackground();
                cSelectionColor = PlatformManager.getInstance().getPlatformView().getWorkbenchPanel().getSimulationPanel().getSelecctionColor();
                setBackColorLabel(lblFieldBackground, cFieldBackground);
                setBackColorLabel(lblSelectionColor, cSelectionColor);

                GraphicNode graphicNode = node.getGraphicNode();
                cNodeMarked = graphicNode.getMarkColor();
                cNodeSelected = graphicNode.getSelectedBackcolor();

                setBackColorLabel(lblNodeSelected, cNodeSelected);
                setBackColorLabel(lblNodeMarked, cNodeMarked);
                if (node instanceof SensorNode) {
                    SensorNode sensorNode = (SensorNode) node;
                    cNeighborsLink = sensorNode.getNeighborsLinkColor();
                    cOthersLink = sensorNode.getOthersLinkColor();
                    cPaths = sensorNode.getMessageColor();

                    setBackColorLabel(lblPaths, cPaths);
                    setBackColorLabel(lblNeighborsLink, cNeighborsLink);
                    setBackColorLabel(lblOthersLink, cOthersLink);
                }

            } else {
                GUI_Utils.showWarningMessage("No sensor nodes added");
            }

        } else {
            GUI_Utils.showWarningMessage("No active simulation");
        }
    }

    private void setBackColorLabel(JLabel label, Color background) {
        label.setBackground(background);
    }

    private void updateColor(JLabel label) {
        Color selectedColor = JColorChooser.showDialog(PlatformManager.getInstance().getPlatformView().getFrame(), "Choose color...", label.getBackground());
        if (selectedColor != null) {
            label.setBackground(selectedColor);
        }
    }

    private boolean applyColors() {

        if (cFieldBackground != null && !cFieldBackground.equals(lblFieldBackground.getBackground())) {
            PlatformManager.getInstance().getPlatformView().getWorkbenchPanel().getSimulationPanel().setBackground(lblFieldBackground.getBackground());
            cFieldBackground = lblFieldBackground.getBackground();
        }
        if (cSelectionColor != null && !cSelectionColor.equals(lblSelectionColor.getBackground())) {
            PlatformManager.getInstance().getPlatformView().getWorkbenchPanel().getSimulationPanel().setSelectionColor(lblSelectionColor.getBackground());
            cSelectionColor = lblSelectionColor.getBackground();
        }
        if (cNodeSelected != null && !cNodeSelected.equals(lblNodeSelected.getBackground())) {
            Collection<Node> nodes = getNodes();
            for (Node node : nodes) {
                node.getGraphicNode().setSelectedBackcolor(lblNodeSelected.getBackground());
            }
            cNodeSelected = lblNodeSelected.getBackground();
        }
        if (cNodeMarked != null && !cNodeMarked.equals(lblNodeMarked.getBackground())) {
            Collection<Node> nodes = getNodes();
            for (Node node : nodes) {
                node.getGraphicNode().setSelectedBackcolor(lblNodeMarked.getBackground());
            }
            cNodeMarked = lblNodeMarked.getBackground();
        }
        if (cNeighborsLink != null && !cNeighborsLink.equals(lblNeighborsLink.getBackground())) {
            Collection<Node> nodes = getNodes();
            for (Node node : nodes) {
                if (node instanceof SensorNode) {
                    ((SensorNode) node).setNeighborsLinkColor(lblNeighborsLink.getBackground());
                }
            }
            cNeighborsLink = lblNeighborsLink.getBackground();
        }
        if (cOthersLink != null && !cOthersLink.equals(lblOthersLink.getBackground())) {
            Collection<Node> nodes = getNodes();
            for (Node node : nodes) {
                if (node instanceof SensorNode) {
                    ((SensorNode) node).setOthersLinkColor(lblOthersLink.getBackground());
                }
            }
            cOthersLink = lblOthersLink.getBackground();
        }
        if (cPaths != null && !cPaths.equals(lblPaths.getBackground())) {
            Collection<Node> nodes = getNodes();
            for (Node node : nodes) {
                if (node instanceof SensorNode) {
                    ((SensorNode) node).setMessageColor(lblPaths.getBackground());
                }
            }
            cPaths = lblPaths.getBackground();
        }
        PlatformManager.getInstance().getPlatformView().getWorkbenchPanel().getSimulationPanel().updateDisplay();
        return true;
    }

    @Override
    public boolean changed() {
        return detectedChanges(cPaths, lblPaths)
                || detectedChanges(cFieldBackground, lblFieldBackground)
                || detectedChanges(cNeighborsLink, lblNeighborsLink)
                || detectedChanges(cNodeMarked, lblNodeMarked)
                || detectedChanges(cNodeSelected, lblNodeSelected)
                || detectedChanges(cOthersLink, lblOthersLink)
                || detectedChanges(cSelectionColor, lblSelectionColor);
    }

    private boolean detectedChanges(Color c, JLabel label) {
        if (c == null) {
            return false;
        }
        return c == label.getBackground();
    }

    Collection<Node> getNodes() {
        return PlatformManager.getInstance().getActiveSimulation().getSimulator().getNodes();
    }

    @Override
    public void beforeClose() {
    }
}