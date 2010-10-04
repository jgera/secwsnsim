/*
 * ReliabilityInstrumentControlPanel.java
 *
 * Created on 10/Jul/2010, 1:40:28
 */
package org.wisenet.platform.core.instruments.reliability;

import java.util.Collection;
import org.wisenet.platform.common.ui.PlatformPanel;
import org.wisenet.platform.core.PlatformManager;
import org.wisenet.platform.utils.GUI_Utils;
import org.wisenet.simulator.components.instruments.IInstrumentControlPanel;
import org.wisenet.simulator.components.instruments.IInstrumentHandler;
import org.wisenet.simulator.components.instruments.AbstractInstrument;
import org.wisenet.simulator.components.instruments.reliability.ReliabilityInstrument;
import org.wisenet.simulator.components.instruments.reliability.ReliabilityInstrument.ReliabilityProbingResult;
import org.wisenet.simulator.core.node.Node;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class ReliabilityInstrumentControlPanel extends PlatformPanel implements IInstrumentControlPanel {

    /** Creates new form ReliabilityInstrumentControlPanel */
    public ReliabilityInstrumentControlPanel() {
        initComponents();
        if (getReliabilityInstrument() == null) {
            GUI_Utils.showWarningMessage("Cannot instanciate the instrument without a active simulation");
            return;
        }

        getReliabilityInstrument().registerControlPanel(this);
        getReliabilityInstrument().setDebugEnabled(true);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cmdDelReceivers = new javax.swing.JButton();
        cmdApply = new javax.swing.JButton();
        cmdDelSenders = new javax.swing.JButton();
        cmdProbe = new javax.swing.JButton();
        cmdAddReceivers = new javax.swing.JButton();
        cmdAddSenders = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        chkAutoNumber = new javax.swing.JCheckBox();
        txtParamInterval = new javax.swing.JFormattedTextField();
        chkNotifyPanel = new javax.swing.JCheckBox();
        txtParamTimes = new javax.swing.JFormattedTextField();
        txtParamDelay = new javax.swing.JFormattedTextField();
        txtParamNroMessages = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblNrSenderNodes = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNrReceiverNodes = new javax.swing.JLabel();
        cmdResult = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaResult = new javax.swing.JTextArea();
        cmdClearResult = new javax.swing.JButton();
        chkDebug = new javax.swing.JCheckBox();

        jCheckBox1.setName("jCheckBox1"); // NOI18N

        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Reliability Instrument"));
        jPanel1.setName("jPanel1"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        cmdDelReceivers.setText("Remove Receiver"); // NOI18N
        cmdDelReceivers.setName("cmdDelReceivers"); // NOI18N
        cmdDelReceivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDelReceiversActionPerformed(evt);
            }
        });

        cmdApply.setText("Apply"); // NOI18N
        cmdApply.setName("cmdApply"); // NOI18N
        cmdApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdApplyActionPerformed(evt);
            }
        });

        cmdDelSenders.setText("Remove Sender"); // NOI18N
        cmdDelSenders.setName("cmdDelSenders"); // NOI18N
        cmdDelSenders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDelSendersActionPerformed(evt);
            }
        });

        cmdProbe.setText("Probe"); // NOI18N
        cmdProbe.setName("cmdProbe"); // NOI18N
        cmdProbe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdProbeActionPerformed(evt);
            }
        });

        cmdAddReceivers.setText("Add To Receivers"); // NOI18N
        cmdAddReceivers.setName("cmdAddReceivers"); // NOI18N
        cmdAddReceivers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddReceiversActionPerformed(evt);
            }
        });

        cmdAddSenders.setText("Add To Senders"); // NOI18N
        cmdAddSenders.setName("cmdAddSenders"); // NOI18N
        cmdAddSenders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddSendersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdApply, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(cmdProbe, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(cmdDelSenders, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(cmdAddSenders, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(cmdDelReceivers, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(cmdAddReceivers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmdAddReceivers, cmdAddSenders, cmdApply, cmdDelReceivers, cmdDelSenders, cmdProbe});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdAddReceivers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelReceivers)
                .addGap(18, 18, 18)
                .addComponent(cmdAddSenders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdDelSenders)
                .addGap(18, 18, 18)
                .addComponent(cmdProbe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdApply)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setName("jPanel3"); // NOI18N

        chkAutoNumber.setText("Auto-Number Messages"); // NOI18N
        chkAutoNumber.setName("chkAutoNumber"); // NOI18N

        txtParamInterval.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtParamInterval.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtParamInterval.setName("txtParamInterval"); // NOI18N

        chkNotifyPanel.setText("Notify Control Panel"); // NOI18N
        chkNotifyPanel.setName("chkNotifyPanel"); // NOI18N

        txtParamTimes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtParamTimes.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtParamTimes.setName("txtParamTimes"); // NOI18N

        txtParamDelay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtParamDelay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtParamDelay.setName("txtParamDelay"); // NOI18N

        txtParamNroMessages.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtParamNroMessages.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtParamNroMessages.setName("txtParamNroMessages"); // NOI18N

        jLabel1.setText("Nr. of Messages"); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText("Retransmissions"); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText("Interval"); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText("Delay"); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chkAutoNumber)
                        .addGap(9, 9, 9)
                        .addComponent(chkNotifyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtParamInterval, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtParamDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtParamTimes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtParamNroMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkAutoNumber)
                    .addComponent(chkNotifyPanel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParamNroMessages)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParamTimes)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParamInterval)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParamDelay, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setName("jPanel4"); // NOI18N

        jLabel6.setText("Nr. of Senders"); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        lblNrSenderNodes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNrSenderNodes.setName("lblNrSenderNodes"); // NOI18N

        jLabel5.setText("Nr. Of Receivers"); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        lblNrReceiverNodes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNrReceiverNodes.setName("lblNrReceiverNodes"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNrSenderNodes, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNrReceiverNodes, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNrSenderNodes, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblNrReceiverNodes, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cmdResult.setText("Get Result"); // NOI18N
        cmdResult.setName("cmdResult"); // NOI18N
        cmdResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdResultActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtaResult.setColumns(20);
        txtaResult.setEditable(false);
        txtaResult.setRows(5);
        txtaResult.setName("txtaResult"); // NOI18N
        jScrollPane1.setViewportView(txtaResult);

        cmdClearResult.setText("Clear Results"); // NOI18N
        cmdClearResult.setName("cmdClearResult"); // NOI18N
        cmdClearResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdClearResultActionPerformed(evt);
            }
        });

        chkDebug.setText("Debug"); // NOI18N
        chkDebug.setName("chkDebug"); // NOI18N
        chkDebug.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkDebugStateChanged(evt);
            }
        });
        chkDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkDebugActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chkDebug)
                    .addComponent(cmdResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdClearResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmdResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdClearResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkDebug))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddReceiversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddReceiversActionPerformed
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        Collection<Node> nodes = PlatformManager.getInstance().getActiveSimulation().getSimulator().getNodes();
        for (Node node : nodes) {
            if (node.getGraphicNode().isSelected()) {
                IInstrumentHandler handler = (IInstrumentHandler) node.getRoutingLayer();
                getReliabilityInstrument().registerReceiver(handler);
            }
        }


    }//GEN-LAST:event_cmdAddReceiversActionPerformed

    private void cmdDelReceiversActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDelReceiversActionPerformed
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        Collection<Node> nodes = PlatformManager.getInstance().getActiveSimulation().getSimulator().getNodes();
        for (Node node : nodes) {
            if (node.getGraphicNode().isSelected()) {
                IInstrumentHandler handler = (IInstrumentHandler) node.getRoutingLayer();
                getReliabilityInstrument().unregisterReceiver(handler);
            }
        }

    }//GEN-LAST:event_cmdDelReceiversActionPerformed

    private void cmdAddSendersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddSendersActionPerformed
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        Collection<Node> nodes = PlatformManager.getInstance().getActiveSimulation().getSimulator().getNodes();
        for (Node node : nodes) {
            if (node.getGraphicNode().isSelected()) {
                IInstrumentHandler handler = (IInstrumentHandler) node.getRoutingLayer();
                getReliabilityInstrument().registerSender(handler);
            }
        }

    }//GEN-LAST:event_cmdAddSendersActionPerformed

    private void cmdDelSendersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDelSendersActionPerformed
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        Collection<Node> nodes = PlatformManager.getInstance().getActiveSimulation().getSimulator().getNodes();
        for (Node node : nodes) {
            if (node.getGraphicNode().isSelected()) {
                IInstrumentHandler handler = (IInstrumentHandler) node.getRoutingLayer();
                getReliabilityInstrument().unregisterSender(handler);
            }
        }

    }//GEN-LAST:event_cmdDelSendersActionPerformed

    private void cmdProbeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdProbeActionPerformed
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        try {
            getReliabilityInstrument().probe();
        } catch (Exception e) {
            GUI_Utils.showException(e);
        }

    }//GEN-LAST:event_cmdProbeActionPerformed

    private void cmdApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdApplyActionPerformed
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        getReliabilityInstrument().setAutonumber(chkAutoNumber.isSelected());
        getReliabilityInstrument().setNotifyPanel(chkNotifyPanel.isSelected());
        ((ReliabilityInstrument) getReliabilityInstrument()).setHowManyMessagesToSentPerSender(Integer.valueOf(txtParamNroMessages.getText()));
        ((ReliabilityInstrument) getReliabilityInstrument()).setDelayToSentMessages(Long.valueOf(txtParamDelay.getText()));
        ((ReliabilityInstrument) getReliabilityInstrument()).setIntervalToSentMessages(Long.valueOf(txtParamInterval.getText()));
        ((ReliabilityInstrument) getReliabilityInstrument()).setTimesToSentMessages(Integer.valueOf(txtParamTimes.getText()));
    }//GEN-LAST:event_cmdApplyActionPerformed

    private void cmdResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdResultActionPerformed
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        ReliabilityInstrument.ReliabilityProbingResult result = (ReliabilityProbingResult) getReliabilityInstrument().getLastProbeResult();
        int nrOfSendingObjects = result.getNumberOfRegistredSendingObjects();
        int nrOfCoverageReceivedObjects = result.getNumberOfRegistredReceivedObjects();
        if (nrOfSendingObjects > 0) {
            double p = nrOfCoverageReceivedObjects * 100 / nrOfSendingObjects;
            txtaResult.append("==============================================\n");
            txtaResult.append("Number of Senders Nodes: " + nrOfSendingObjects + " \n");
            txtaResult.append("Number of Received Nodes Messages: " + nrOfCoverageReceivedObjects + " \n");
            txtaResult.append("Coverage Value: " + p + " %\n");
        }

    }//GEN-LAST:event_cmdResultActionPerformed

    private void cmdClearResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdClearResultActionPerformed
        // TODO add your handling code here:
        txtaResult.setText("");
    }//GEN-LAST:event_cmdClearResultActionPerformed

    private void chkDebugStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkDebugStateChanged
        //
    }//GEN-LAST:event_chkDebugStateChanged

    private void chkDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkDebugActionPerformed
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        getReliabilityInstrument().setDebugEnabled(chkDebug.isSelected());
    }//GEN-LAST:event_chkDebugActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkAutoNumber;
    private javax.swing.JCheckBox chkDebug;
    private javax.swing.JCheckBox chkNotifyPanel;
    private javax.swing.JButton cmdAddReceivers;
    private javax.swing.JButton cmdAddSenders;
    private javax.swing.JButton cmdApply;
    private javax.swing.JButton cmdClearResult;
    private javax.swing.JButton cmdDelReceivers;
    private javax.swing.JButton cmdDelSenders;
    private javax.swing.JButton cmdProbe;
    private javax.swing.JButton cmdResult;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNrReceiverNodes;
    private javax.swing.JLabel lblNrSenderNodes;
    private javax.swing.JFormattedTextField txtParamDelay;
    private javax.swing.JFormattedTextField txtParamInterval;
    private javax.swing.JFormattedTextField txtParamNroMessages;
    private javax.swing.JFormattedTextField txtParamTimes;
    private javax.swing.JTextArea txtaResult;
    // End of variables declaration//GEN-END:variables

    public synchronized void refresh(AbstractInstrument instrument) {
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return;
        }
        if (instrument instanceof ReliabilityInstrument) {
            lblNrSenderNodes.setText("" + getReliabilityInstrument().getSenders().size());
            lblNrReceiverNodes.setText("" + getReliabilityInstrument().getReceivers().size());
        }
    }

    private ReliabilityInstrument getReliabilityInstrument() {
        if (!PlatformManager.getInstance().haveActiveSimulation()) {
            return null;
        }

        return PlatformManager.getInstance().getActiveSimulation().getReliabilityInstrument();

    }

    @Override
    public boolean onCancel() {
        return true;
    }

    @Override
    public boolean onOK() {
        return true;
    }

    @Override
    public boolean onApply() {
        return true;
    }

    @Override
    protected boolean isDataValid() {
        return true;
    }
}
