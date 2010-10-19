/*
 * SimulationWizardPanel.java
 *
 * Created on Mar 7, 2010, 5:04:38 PM
 */
package org.wisenet.platform.gui.panels;

import java.awt.event.FocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.filechooser.FileFilter;
import org.jdesktop.application.Action;
import org.wisenet.platform.common.conf.ClassConfigReader.ClassDefinitions;
import org.wisenet.platform.utils.GUI_Utils;

import org.wisenet.platform.common.conf.ConfigurationUtils;
import org.wisenet.platform.common.ui.PlatformDialog;
import org.wisenet.platform.common.ui.PlatformPanel;
import org.wisenet.platform.core.instruments.energy.ui.EnergyModelPanel;
import org.wisenet.simulator.components.simulation.SimulationFactory;
import org.wisenet.simulator.core.energy.EnergyModel;
import org.wisenet.simulator.utilities.console.SimulationSettings;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class SimulationWizardPanel extends PlatformPanel {

    protected SimulationSettings settings;
    private boolean ok;
    private FocusListener focusListener;
    private SimulationFactory sf;
    private EnergyModel energyModel;
    private boolean energyModelConfig = false;

    /** Creates new form SimulationWizardPanel */
    public SimulationWizardPanel() {
        initComponents();

        configClasses();

        cboNodeClass.addFocusListener(focusListener);
        cboRadioModelClass.addFocusListener(focusListener);
        cboSimulatorClass.addFocusListener(focusListener);
        txtSimulationName.addFocusListener(focusListener);
        txtSimulationDescription.addFocusListener(focusListener);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgValueZ = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
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
        jLabel5 = new javax.swing.JLabel();
        optVariableZ = new javax.swing.JRadioButton();
        optStaticZ = new javax.swing.JRadioButton();
        minValueZ = new javax.swing.JFormattedTextField();
        maxValueZ = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        environAttenuation = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        lblSimName = new javax.swing.JLabel();
        txtSimulationName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSimulationDescription = new javax.swing.JTextField();
        cmdLoadFromFIle = new javax.swing.JButton();
        cmdSaveToFile = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel4.setName("jPanel4"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setFont(lblSimName.getFont());
        jLabel1.setText("Simulator Class"); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cboSimulatorClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboSimulatorClass.setName("cboSimulatorClass"); // NOI18N

        cboRadioModelClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboRadioModelClass.setName("cboRadioModelClass"); // NOI18N

        jLabel4.setFont(lblSimName.getFont());
        jLabel4.setText("Radio Model Class"); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nodes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, lblSimName.getFont(), null));
        jPanel3.setFont(jPanel3.getFont().deriveFont(jPanel3.getFont().getStyle() | java.awt.Font.BOLD, jPanel3.getFont().getSize()-1));
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(lblSimName.getFont());
        jLabel2.setText("Node Factory Class"); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 37, -1, -1));

        cboNodeClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNodeClass.setName("cboNodeClass"); // NOI18N
        jPanel3.add(cboNodeClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 320, -1));

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(SimulationWizardPanel.class, this);
        cmdEnergyModel.setAction(actionMap.get("configureEnergyModel")); // NOI18N
        cmdEnergyModel.setName("cmdEnergyModel"); // NOI18N
        jPanel3.add(cmdEnergyModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 47, 24));

        jLabel3.setFont(lblSimName.getFont());
        jLabel3.setText("Node Radio Range"); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 77, 125, -1));

        nodeRangeSlider.setMaximum(300);
        nodeRangeSlider.setMinimum(30);
        nodeRangeSlider.setMinorTickSpacing(100);
        nodeRangeSlider.setPaintLabels(true);
        nodeRangeSlider.setPaintTicks(true);
        nodeRangeSlider.setSnapToTicks(true);
        nodeRangeSlider.setValue(130);
        nodeRangeSlider.setName("nodeRangeSlider"); // NOI18N
        nodeRangeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nodeRangeSliderStateChanged(evt);
            }
        });
        jPanel3.add(nodeRangeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 362, -1));

        jLabel5.setFont(lblSimName.getFont());
        jLabel5.setText("Z Value"); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 102, 24));

        bgValueZ.add(optVariableZ);
        optVariableZ.setText("Interval"); // NOI18N
        optVariableZ.setName("optVariableZ"); // NOI18N
        optVariableZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optVariableZActionPerformed(evt);
            }
        });
        jPanel3.add(optVariableZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        bgValueZ.add(optStaticZ);
        optStaticZ.setSelected(true);
        optStaticZ.setText("Static "); // NOI18N
        optStaticZ.setName("optStaticZ"); // NOI18N
        optStaticZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optStaticZActionPerformed(evt);
            }
        });
        jPanel3.add(optStaticZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 68, -1));

        minValueZ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        minValueZ.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        minValueZ.setText("0"); // NOI18N
        minValueZ.setToolTipText("Min Z value"); // NOI18N
        minValueZ.setName("minValueZ"); // NOI18N
        jPanel3.add(minValueZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 89, -1));

        maxValueZ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        maxValueZ.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        maxValueZ.setText("0"); // NOI18N
        maxValueZ.setToolTipText("Max Z value"); // NOI18N
        maxValueZ.setEnabled(false);
        maxValueZ.setName("maxValueZ"); // NOI18N
        jPanel3.add(maxValueZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 89, -1));

        jLabel7.setFont(lblSimName.getFont());
        jLabel7.setText("Environment Attenuation"); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 24));

        environAttenuation.setModel(new javax.swing.SpinnerNumberModel(0, -100, 100, 1));
        environAttenuation.setName("environAttenuation"); // NOI18N
        jPanel3.add(environAttenuation, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 68, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboSimulatorClass, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboRadioModelClass, 0, 383, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        lblSimName.setText("Name"); // NOI18N
        lblSimName.setName("lblSimName"); // NOI18N

        txtSimulationName.setName("txtSimulationName"); // NOI18N
        txtSimulationName.setOpaque(false);

        jLabel6.setFont(lblSimName.getFont());
        jLabel6.setText("Description"); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        txtSimulationDescription.setName("txtSimulationDescription"); // NOI18N

        cmdLoadFromFIle.setText("Load from file..."); // NOI18N
        cmdLoadFromFIle.setName("cmdLoadFromFIle"); // NOI18N
        cmdLoadFromFIle.setPreferredSize(new java.awt.Dimension(50, 24));
        cmdLoadFromFIle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoadFromFIleActionPerformed(evt);
            }
        });

        cmdSaveToFile.setText("Save to file..."); // NOI18N
        cmdSaveToFile.setName("cmdSaveToFile"); // NOI18N
        cmdSaveToFile.setPreferredSize(new java.awt.Dimension(50, 24));
        cmdSaveToFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveToFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSimName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSimulationName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdSaveToFile, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdLoadFromFIle, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSimulationDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSimName)
                    .addComponent(txtSimulationName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdLoadFromFIle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSaveToFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSimulationDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel4, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdLoadFromFIleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoadFromFIleActionPerformed
        try {
            ok = false;
            FileFilter[] filters = new FileFilter[]{GUI_Utils.XML()};
            String filename = GUI_Utils.showOpenDialog(filters, "Open Simulation Settings File");
            if (filename != null) {
                updateSettings(filename);
            }

        } catch (Exception e) {
            GUI_Utils.showException(e);
        }

    }//GEN-LAST:event_cmdLoadFromFIleActionPerformed

    private void nodeRangeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nodeRangeSliderStateChanged
        JSlider source = (JSlider) evt.getSource();
        if (!source.getValueIsAdjusting()) {
            int value = (int) source.getValue();
            nodeRangeSlider.setToolTipText("" + value);
        }
    }//GEN-LAST:event_nodeRangeSliderStateChanged

    private void optVariableZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optVariableZActionPerformed
        setZInput();
    }

    private void setZInput() {
        maxValueZ.setEnabled(optVariableZ.isSelected());
    }//GEN-LAST:event_optVariableZActionPerformed

    private void optStaticZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optStaticZActionPerformed
        setZInput();
    }//GEN-LAST:event_optStaticZActionPerformed

    private void cmdSaveToFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveToFileActionPerformed
        GUI_Utils.showinfoMessage("Feature not yet implemented!");
        return ;
//        if (txtSimulationName.getText().trim().length() > 0 && cboNodeClass.getItemCount() > 0 && cboRadioModelClass.getItemCount() > 0 && cboSimulatorClass.getItemCount() > 0) {
//            SimulationSettings sets = new SimulationSettings();
//            sets.setName(txtSimulationName.getName());
//
//
//        }
    }//GEN-LAST:event_cmdSaveToFileActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgValueZ;
    private javax.swing.JComboBox cboNodeClass;
    private javax.swing.JComboBox cboRadioModelClass;
    private javax.swing.JComboBox cboSimulatorClass;
    private javax.swing.JButton cmdEnergyModel;
    private javax.swing.JButton cmdLoadFromFIle;
    private javax.swing.JButton cmdSaveToFile;
    private javax.swing.JSpinner environAttenuation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblSimName;
    private javax.swing.JFormattedTextField maxValueZ;
    private javax.swing.JFormattedTextField minValueZ;
    private javax.swing.JSlider nodeRangeSlider;
    private javax.swing.JRadioButton optStaticZ;
    private javax.swing.JRadioButton optVariableZ;
    private javax.swing.JTextField txtSimulationDescription;
    private javax.swing.JTextField txtSimulationName;
    // End of variables declaration//GEN-END:variables

    private boolean validateData() {
        try {
            /* create a settings object*/
            settings = new SimulationSettings();
            settings.setName(txtSimulationName.getText()); // set the name
            settings.setSimulatorClassName(((ClassDefinitions) cboSimulatorClass.getSelectedItem()).className);
            settings.setRadioModelClassName(((ClassDefinitions) cboRadioModelClass.getSelectedItem()).className);
            settings.setNodeFactoryClassName(((ClassDefinitions) cboNodeClass.getSelectedItem()).className);
            settings.setEnergyModelClassName(EnergyModel.class.getName()); // falta configurar o energy class

            settings.setMaxNodeRadioRange(nodeRangeSlider.getValue());
            settings.setStaticZ(optStaticZ.isSelected());
            settings.setEnvironAttenuation((Integer) environAttenuation.getModel().getValue());
            settings.setMaxZ(Double.valueOf(maxValueZ.getText()));
            settings.setMinZ(Double.valueOf(minValueZ.getText()));

            sf = new SimulationFactory();
            sf.setSimulatorClass(getClassInstance(((ClassDefinitions) cboSimulatorClass.getSelectedItem()).className));
            sf.setRadioModelClass(getClassInstance(((ClassDefinitions) cboRadioModelClass.getSelectedItem()).className));
            sf.setNodeFactoryClass(getClassInstance(((ClassDefinitions) cboNodeClass.getSelectedItem()).className));
            sf.setNodeRange(nodeRangeSlider.getValue());


            if (!energyModelConfig) {

                energyModel = EnergyModel.getDefaultInstance();
            }
            settings.setEnergyModelParameters(energyModel.getParameters());
            sf.setEnergyModel(energyModel);

            return true;
        } catch (InstantiationException ex) {
            GUI_Utils.showException(ex);
        } catch (IllegalAccessException ex) {
            GUI_Utils.showException(ex);
        }
        sf = null;
        return false;

    }

    Class getClassInstance(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SimulationWizardPanel.class.getName()).log(Level.SEVERE, null, ex);
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
        ConfigurationUtils.loadComboWithClasses(cboSimulatorClass, ConfigurationUtils.loadConfigurationClasses(ConfigurationUtils.CONF_SIMULATOR_CLASSES_PROPERTIES));
        ConfigurationUtils.loadComboWithClasses(cboRadioModelClass, ConfigurationUtils.loadConfigurationClasses(ConfigurationUtils.CONF_RADIOMODEL_CLASSES_PROPERTIES));
        ConfigurationUtils.loadComboWithClasses(cboNodeClass, ConfigurationUtils.loadConfigurationClasses(ConfigurationUtils.CONF_NODE_CLASSES_PROPERTIES));
    }

    @Action
    public void configureEnergyModel() {

        EnergyModelPanel emp = new EnergyModelPanel();
        PlatformDialog emd = PlatformDialog.display(emp, "Energy Model Parameters", PlatformDialog.OKCANCEL_MODE);
        if (emd.getStatus() == PlatformDialog.OK_STATUS) {
            energyModel = emp.createEnergyModelInstance();
            energyModelConfig = true;
        } else {
            energyModelConfig = false;
        }

//        EnergyModelDialog emd = new EnergyModelDialog(null, true);
//        emd.setVisible(true);
//        if (emd.isOk()) {
//            energyModel = emd.getEnergyModel();
//            energyModelConfig = true;
//        }
//        emd.dispose();
    }

    public SimulationSettings getSettings() {
        return settings;
    }

    private void updateSettings(String filename) {
        try {
            SimulationSettings sets = new SimulationSettings();
            sets.loadFromXML(filename);
            this.txtSimulationName.setText(sets.getName());
            selectComboValue(cboNodeClass, sets.getNodeFactoryClassName());
            selectComboValue(cboRadioModelClass, sets.getRadioModelClassName());
            selectComboValue(cboSimulatorClass, sets.getSimulatorClassName());
            nodeRangeSlider.setValue(sets.getMaxNodeRadioRange());
            optStaticZ.setSelected(sets.isStaticZ());
            optVariableZ.setSelected(!sets.isStaticZ());
            maxValueZ.setText("" + sets.getMaxZ());
            minValueZ.setText("" + sets.getMinZ());
            environAttenuation.setValue((Integer) sets.getEnvironAttenuation());


            System.out.println("");
        } catch (Exception ex) {
            GUI_Utils.showException(ex);
        }
    }

    private void selectComboValue(JComboBox cbo, String value) {
        for (int i = 0; i < cbo.getItemCount(); i++) {
            ClassDefinitions cd = (ClassDefinitions) cbo.getItemAt(i);
            if (cd.className.toLowerCase().equals(value.toLowerCase())) {
                cbo.setSelectedItem(cd);
            }
        }
    }

    @Override
    public boolean onCancel() {
        return true;
    }

    @Override
    public boolean onOK() {
        try {
            if (validateData()) {
                ok = true;
                return true;

            } else {
                ok = false;
                return false;
            }
        } catch (Exception e) {
            GUI_Utils.showException(e);
            return false;
        }
    }

    @Override
    public boolean onApply() {
        return true;
    }

    @Override
    protected boolean isDataValid() {
        return validateData();
    }

    @Override
    public void beforeClose() {
    }
}
