/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChartFrame.java
 *
 * Created on Feb 23, 2010, 11:17:44 AM
 */
package org.mei.securesim.platform.ui;

import java.util.Random;
import org.mei.securesim.platform.core.charts.ui.ChartPanel;

/**
 *
 * @author posilva
 */
public class ChartFrame extends javax.swing.JFrame {

    public ChartPanel getChartPanel() {
        return chartPanel1;
    }

    /** Creates new form ChartFrame */
    public ChartFrame() {
        initComponents();
    }

    void configChartPanel(String name, String xLabel, String yLabel){
        chartPanel1.setChartName(name);
        chartPanel1.setxLabel(xLabel);
        chartPanel1.setyLabel(yLabel);
        chartPanel1.init();
        chartPanel1.updateUI();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPanel1 = new org.mei.securesim.platform.core.charts.ui.ChartPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        chartPanel1.setName("chartPanel1"); // NOI18N
        getContentPane().add(chartPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ChartFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.mei.securesim.platform.core.charts.ui.ChartPanel chartPanel1;
    // End of variables declaration//GEN-END:variables
    private double xval=0;


    class GThread extends Thread {

        @Override
        public void run() {
            Random r = new Random();
            for (int i = 0; i < 100; i++) {
                try {
                    
                    double y = (r).nextDouble() * 100;
                    chartPanel1.updateChart(xval, y);
                    xval+=0.1;
                    sleep(500+(long)r.nextDouble()*1000);
                } catch (InterruptedException ex) {
                   // Logger.getLogger(ChartFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}
