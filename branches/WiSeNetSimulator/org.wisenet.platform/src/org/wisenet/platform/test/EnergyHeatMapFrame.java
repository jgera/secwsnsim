/*
 *     Wireless Sensor Network Simulator
 *   The next generation for WSN Simulations
 */

/*
 * EnergyHeatMapFrame.java
 *
 * Created on Jan 24, 2011, 11:45:30 PM
 */
package org.wisenet.platform.test;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JFrame;
import org.wisenet.platform.utils.GUI_Utils;

/**
 *
 * @author posilva
 */
public class EnergyHeatMapFrame extends JFrame {

    EnergyHeatMap energyHeatMap = new EnergyHeatMap();

    /** Creates new form EnergyHeatMapFrame */
    public EnergyHeatMapFrame() {
        initComponents();
        jScrollPane1.setViewportView(energyHeatMap);
        jScrollPane1.setAutoscrolls(true);
        setPreferredSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(800, 600));

        GUI_Utils.centerOnScreen(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setName("jScrollPane1"); // NOI18N
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void displayHeat(Collection collection) {
        energyHeatMap.paintHeat(collection);
        jScrollPane1.setPreferredSize(energyHeatMap.getSize());

    }

    public void loadImage(BufferedImage bufferedImage) throws IOException {
        energyHeatMap.loadImage(bufferedImage);
        repaint();
        energyHeatMap.repaint();

    }
}
