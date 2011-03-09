/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SimulationEnergyPanel.java
 *
 * Created on Oct 5, 2010, 1:00:57 AM
 */
package org.wisenet.platform.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Hashtable;
import java.util.Random;
import java.util.Vector;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.wisenet.platform.common.ui.PlatformFrame;
import org.wisenet.platform.common.ui.PlatformPanel;
import org.wisenet.simulator.gui.GraphicNode;

/**
 *
 * @author posilva
 */
public class SimulationEnergyPanel extends PlatformPanel {

    private Hashtable<Short, Double> values = null;
    private int refreshInterval = 1000; // one second
    private boolean end = false;
    private UpdateThread updateThread = new UpdateThread();
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private JFreeChart chart;
    private Random r = new Random();
    final Font tickFont = new Font("Dialog.plain", Font.PLAIN, 8);
    private Vector<GraphicNode> nodes;

    /** Creates new form SimulationEnergyPanel */
    public SimulationEnergyPanel() {
        initComponents();
        createChart();

    }

    protected void updateValues() {
        if (values == null) {
            return;
        }
        if (values.isEmpty()) {
            return;
        }
        int i = 0;
        Double value;
        short id;
        if (nodes != null && nodes.size() > 0) {
            for (int k = 0 ;k< nodes.size();k++) {
                id=nodes.get(k).getPhysicalNode().getId();
                value=values.get(id);
                dataset.setValue(100 - value, "Nodes", "" + id);
            i++;
            }
        } else {
            
            for (Short object : values.keySet()) {
                if (i > 15) {
                    break;
                }
                dataset.setValue(100 - values.get(object), "Nodes", "" + object.shortValue());
                i++;


            }
        }
    }

    protected void createChart() {

        chart = ChartFactory.createBarChart("", "Nodes", "Energy", dataset,
                PlotOrientation.VERTICAL, false, true, false);


        CategoryPlot p = chart.getCategoryPlot();

        p.getDomainAxis().setTickLabelFont(tickFont);
        p.getRangeAxis().setTickLabelFont(tickFont);
        p.setRangeGridlinePaint(Color.red);

        NumberAxis rangeAxis = (NumberAxis) p.getRangeAxis();
        rangeAxis.setUpperBound(100.0);
        rangeAxis.setLowerBound(0.0);
        add(new ChartPanel(chart), BorderLayout.CENTER);
        updateUI();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

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

    public void setValues(Hashtable<Short, Double> nodesEnergy, Vector<GraphicNode> selectedNodes) {
        values = nodesEnergy;
        nodes = selectedNodes;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    class UpdateThread extends Thread {

        @Override
        @SuppressWarnings("SleepWhileHoldingLock")
        public void run() {
            while (!end) {
                updateValues();
                try {
                    sleep(refreshInterval);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    public static void main(String[] args) {
        PlatformPanel sep = new SimulationEnergyPanel();
        PlatformFrame.display(sep, "Simulation Energy", PlatformFrame.OK_MODE);

    }

    @Override
    public void beforeClose() {
        end = true;
    }

    @Override
    public void beforeStart() {
        super.beforeStart();
        updateThread.start();
    }

    public int getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(int refreshInterval) {
        this.refreshInterval = refreshInterval;
    }

    public Hashtable<Short, Double> getValues() {
        return values;
    }

    public void setValues(Hashtable<Short, Double> values) {
        this.values = values;
    }
}