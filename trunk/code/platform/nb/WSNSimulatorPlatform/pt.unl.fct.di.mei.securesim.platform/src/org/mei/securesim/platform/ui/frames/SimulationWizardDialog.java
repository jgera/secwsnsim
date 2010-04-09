/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SimulationWizardDialog.java
 *
 * Created on Mar 7, 2010, 5:04:38 PM
 */
package org.mei.securesim.platform.ui.frames;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTextField;
import org.jdesktop.application.Action;
import org.mei.securesim.core.energy.EnergyModel;
import org.mei.securesim.core.network.basic.DefaultNetwork;
import org.mei.securesim.platform.conf.ClassConfigReader;
import org.mei.securesim.platform.conf.ClassConfigReader.ClassDefinitions;
import org.mei.securesim.platform.instruments.energy.ui.resources.EnergyModelDialog;
import org.mei.securesim.platform.utils.GUI_Utils;

import org.mei.securesim.components.simulation.SimulationFactory;

/**
 *
 * @author posilva
 */
public class SimulationWizardDialog extends JDialog {

    private boolean ok;
    private FocusListener focusListener;
    private SimulationFactory sf;
    private EnergyModel energyModel;
    private boolean energyModelConfig = false;

    /** Creates new form SimulationWizardDialog */
    public SimulationWizardDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        focusListener = new FocusListener() {

            public void focusGained(FocusEvent fe) {
                JComponent source = ((JComponent) fe.getSource());
                source.setBackground(Color.yellow);
                if (source instanceof JTextField) {
                    ((JTextField) source).selectAll();
                }
            }

            public void focusLost(FocusEvent fe) {
                ((JComponent) fe.getSource()).setBackground(Color.WHITE);
            }
        };

        configClasses();

        cboNodeClass.addFocusListener(focusListener);
        cboRadioModelClass.addFocusListener(focusListener);
        cboSimulatorClass.addFocusListener(focusListener);
        txtSimulationName.addFocusListener(focusListener);
        txtSimulationDescription.addFocusListener(focusListener);

        setTitle("Simulation Wizard");
        GUI_Utils.centerOnScreen((Window) this);
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
        jLabel1 = new javax.swing.JLabel();
        cboSimulatorClass = new javax.swing.JComboBox();
        cboRadioModelClass = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboNodeClass = new javax.swing.JComboBox();
        cmdEnergyModel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nodeRangeSlider = new javax.swing.JSlider();
        cmdOK = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSimulationName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSimulationDescription = new javax.swing.JTextField();
        cmdCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(org.mei.securesim.platform.PlatformApp.class).getContext().getResourceMap(SimulationWizardDialog.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setModal(true);
        setName("Form"); // NOI18N
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(resourceMap.getFont("jLabel6.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cboSimulatorClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSimulatorClass.setName("cboSimulatorClass"); // NOI18N

        cboRadioModelClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboRadioModelClass.setName("cboRadioModelClass"); // NOI18N

        jLabel4.setFont(resourceMap.getFont("jLabel6.font")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jPanel3.border.title"))); // NOI18N
        jPanel3.setFont(jPanel3.getFont().deriveFont(jPanel3.getFont().getStyle() | java.awt.Font.BOLD, jPanel3.getFont().getSize()-1));
        jPanel3.setName("jPanel3"); // NOI18N

        jLabel2.setFont(resourceMap.getFont("jLabel6.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        cboNodeClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNodeClass.setName("cboNodeClass"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(org.mei.securesim.platform.PlatformApp.class).getContext().getActionMap(SimulationWizardDialog.class, this);
        cmdEnergyModel.setAction(actionMap.get("configureEnergyModel")); // NOI18N
        cmdEnergyModel.setText(resourceMap.getString("cmdEnergyModel.text")); // NOI18N
        cmdEnergyModel.setToolTipText(resourceMap.getString("cmdEnergyModel.toolTipText")); // NOI18N
        cmdEnergyModel.setName("cmdEnergyModel"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        nodeRangeSlider.setMaximum(300);
        nodeRangeSlider.setMinimum(30);
        nodeRangeSlider.setMinorTickSpacing(100);
        nodeRangeSlider.setPaintLabels(true);
        nodeRangeSlider.setPaintTicks(true);
        nodeRangeSlider.setSnapToTicks(true);
        nodeRangeSlider.setToolTipText(resourceMap.getString("nodeRangeSlider.toolTipText")); // NOI18N
        nodeRangeSlider.setValue(30);
        nodeRangeSlider.setName("nodeRangeSlider"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nodeRangeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(cboNodeClass, 0, 274, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdEnergyModel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboNodeClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdEnergyModel))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(nodeRangeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSimulatorClass, 0, 288, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(cboRadioModelClass, 0, 288, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboSimulatorClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboRadioModelClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmdOK.setText(resourceMap.getString("cmdOK.text")); // NOI18N
        cmdOK.setMinimumSize(new java.awt.Dimension(25, 50));
        cmdOK.setName("cmdOK"); // NOI18N
        cmdOK.setPreferredSize(new java.awt.Dimension(50, 24));
        cmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdOKActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel5.setFont(resourceMap.getFont("jLabel5.font")); // NOI18N
        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        txtSimulationName.setBackground(resourceMap.getColor("txtSimulationName.background")); // NOI18N
        txtSimulationName.setText(resourceMap.getString("txtSimulationName.text")); // NOI18N
        txtSimulationName.setName("txtSimulationName"); // NOI18N
        txtSimulationName.setOpaque(false);

        jLabel6.setFont(resourceMap.getFont("jLabel6.font")); // NOI18N
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        txtSimulationDescription.setText(resourceMap.getString("txtSimulationDescription.text")); // NOI18N
        txtSimulationDescription.setName("txtSimulationDescription"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSimulationDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(txtSimulationName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSimulationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSimulationDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmdCancel.setText(resourceMap.getString("cmdCancel.text")); // NOI18N
        cmdCancel.setName("cmdCancel"); // NOI18N
        cmdCancel.setPreferredSize(new java.awt.Dimension(50, 24));
        cmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdOKActionPerformed
        // TODO add your handling code here:
        if (validateData()) {
            ok = true;
            setVisible(false);
        } else {
            ok = false;
        }
}//GEN-LAST:event_cmdOKActionPerformed

    private void cmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCancelActionPerformed
        // TODO add your handling code here:
        ok = false;
        setVisible(false);
    }//GEN-LAST:event_cmdCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboNodeClass;
    private javax.swing.JComboBox cboRadioModelClass;
    private javax.swing.JComboBox cboSimulatorClass;
    private javax.swing.JButton cmdCancel;
    private javax.swing.JButton cmdEnergyModel;
    private javax.swing.JButton cmdOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider nodeRangeSlider;
    private javax.swing.JTextField txtSimulationDescription;
    private javax.swing.JTextField txtSimulationName;
    // End of variables declaration//GEN-END:variables

    private boolean validateData() {
        try {
            sf = new SimulationFactory();
            sf.setSimulatorClass(getClassInstance(((ClassDefinitions) cboSimulatorClass.getSelectedItem()).className));
            sf.setRadioModelClass(getClassInstance(((ClassDefinitions) cboRadioModelClass.getSelectedItem()).className));
            sf.setNodeFactoryClass(getClassInstance(((ClassDefinitions) cboNodeClass.getSelectedItem()).className));
            sf.setNetworkClass(DefaultNetwork.class);
            sf.setNodeRange(nodeRangeSlider.getValue());
            if (!energyModelConfig) {
                energyModel = EnergyModel.getDefaultInstance();
            }
            sf.setEnergyModel(energyModel);
            return true;
        } catch (InstantiationException ex) {
            Logger.getLogger(SimulationWizardDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SimulationWizardDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        sf = null;
        return false;

    }

    Class getClassInstance(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SimulationWizardDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isOk() {
        return ok;
    }

    public SimulationFactory getSimulationFactory() {

        return sf;
    }

    private void configClasses() {
        try {
            ClassConfigReader sc = new ClassConfigReader("conf/SimulatorClasses.properties");
            loadComboWithClasses(cboSimulatorClass, sc.getClasses());

            ClassConfigReader rc = new ClassConfigReader("conf/RadioModelClasses.properties");
            loadComboWithClasses(cboRadioModelClass, rc.getClasses());

            ClassConfigReader nc = new ClassConfigReader("conf/NodeClasses.properties");
            loadComboWithClasses(cboNodeClass, nc.getClasses());
        } catch (IOException ex) {
            Logger.getLogger(SimulationWizardDialog.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    private void loadComboWithClasses(JComboBox cbo, HashSet<ClassDefinitions> classes) {
        if (cbo == null) {
            return;
        }
        cbo.removeAllItems();

        for (ClassDefinitions classDefinitions : classes) {
            cbo.addItem(classDefinitions);
        }



    }

    @Action
    public void configureEnergyModel() {

        EnergyModelDialog emd = new EnergyModelDialog(null, true);
        emd.setVisible(true);
        if (emd.isOk()) //           sw.getSimulationFactory();
        {
            energyModel = emd.getEnergyModel();
            energyModelConfig = true;
        }
        emd.dispose();
    }

}
