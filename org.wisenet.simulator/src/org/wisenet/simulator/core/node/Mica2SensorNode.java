/*
 ***  Wireless Sensor Network Simulator
 * The next generation for WSN Simulations
 */
package org.wisenet.simulator.core.node;

import java.awt.Color;
import java.awt.Graphics;
import org.wisenet.simulator.core.Simulator;
import org.wisenet.simulator.core.radio.RadioModel;
import org.wisenet.simulator.core.ui.ISimulationDisplay;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public abstract class Mica2SensorNode extends SensorNode {

    private Color paintingPathColor = Color.LIGHT_GRAY;

    ;
    private boolean paintingPaths = true;

    /**
     *
     * @param sim
     * @param radioModel
     */
    public Mica2SensorNode(Simulator sim, RadioModel radioModel) {
        super(sim, radioModel);
    }

    /**
     *
     * @param radioModel
     */
    @Override
    public void configureMACLayer(RadioModel radioModel) {

        if (macLayer == null) {
            throw new IllegalStateException("MacLayer cannot be null");
        }
        getMacLayer().setNode(this);
        getMacLayer().setRadioModel(radioModel);
        getMacLayer().setNeighborhood(radioModel.createNeighborhood());
    }

    @Override
    public void init() {
        super.init();
    }

    /**
     *
     * @param disp
     */
    @Override
    public void displayOn(ISimulationDisplay disp) {
        Graphics g = disp.getGraphics();

        int _x = disp.x2ScreenX(this.getX());
        int _y = disp.y2ScreenY(this.getY());

        super.displayOn(disp);

        if (turnedOn) {
            Color c = g.getColor();
            if (getMacLayer().isSending()) {
                c = getSendingColor();
            } else if (getMacLayer().isReceiving()) {
                if (getMacLayer().isCorrupted()) {
                    c = getReceivingCorruptedColor();
                } else {
                    c = getReceivingNotCorruptedColor();
                }
            } else {
                c = getBaseColor();
            }

            getGraphicNode().setBackcolor(c);
            getGraphicNode().paint(disp);

            if (paintingPaths) {
                paintPath2Parent(g, _x, _y);
            }

        } else {
            getGraphicNode().setBackcolor(Color.WHITE);
            getGraphicNode().paint(disp);
        }
    }

    private void paintPath2Parent(Graphics g, int _x, int _y) {
        Color oldcolor = g.getColor();
        if (getParentNode() != null) {
            Color c = getMessageColor();
            g.setColor(c);
            int x1 = getParentNode().getGraphicNode().getX();
            int y1 = getParentNode().getGraphicNode().getY();
            g.drawLine(_x, _y, x1, y1);
        }
        g.setColor(oldcolor);
    }

    /**
     *
     * @return
     */
    public boolean isPaintingPaths() {
        return paintingPaths;
    }

    /**
     *
     * @param paintingPaths
     */
    public void setPaintingPaths(boolean paintingPaths) {
        this.paintingPaths = paintingPaths;
    }

    /**
     *
     * @return
     */
    public Color getPaintingPathColor() {
        return paintingPathColor;
    }

    /**
     *
     * @param paintingPathColor
     */
    public void setPaintingPathColor(Color paintingPathColor) {
        this.paintingPathColor = paintingPathColor;
    }
}