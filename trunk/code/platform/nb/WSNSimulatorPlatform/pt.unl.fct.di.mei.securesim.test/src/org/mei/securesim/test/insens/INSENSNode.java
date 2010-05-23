/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mei.securesim.test.insens;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mei.securesim.components.crypto.CryptoFunctions;
import org.mei.securesim.core.engine.Simulator;
import org.mei.securesim.core.nodes.basic.Mica2SensorNode;
import org.mei.securesim.core.radio.RadioModel;
import org.mei.securesim.core.ui.ISimulationDisplay;
import org.mei.securesim.gui.IDisplayable;
import org.mei.securesim.test.insens.utils.INSENSConstants;
import org.mei.securesim.test.insens.utils.INSENSFunctions;

/**
 *
 * @author pedro
 */
public class INSENSNode extends Mica2SensorNode implements IDisplayable {

    long S0;
    private byte[] macKey;
    private byte[] encKey;
    private byte[] iv;

    public INSENSNode(Simulator sim, RadioModel radioModel) {
        super(sim, radioModel);
        setEnableFunctioningEnergyConsumption(false);
        setRadius(2);
        setPaintingPaths(true);
    }

    @Override
    public void init() {
        try {
            if (getId() == 1) {
                setSinkNode(true);
            }
            getGraphicNode().setMarkColor(Color.RED);

            super.init();
            macKey = CryptoFunctions.createSkipjackKey();
            encKey = CryptoFunctions.createSkipjackKey();
            INSENSFunctions.shareKeyWithBaseStation(getId(), encKey);
            INSENSFunctions.shareMACKeyWithBaseStation(getId(), macKey);

            iv = CryptoFunctions.createIV(0);
            S0 = INSENSConstants.INITIAL_NK;
        } catch (Exception ex) {
            Logger.getLogger(INSENSNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public long getS0() {
        return S0;
    }

    public void setS0(long S0) {
        this.S0 = S0;
    }

    public byte[] getEncKey() {
        return encKey;
    }

    public void setEncKey(byte[] encKey) {
        this.encKey = encKey;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }

    public byte[] getMacKey() {
        return macKey;
    }

    public void setMacKey(byte[] macKey) {
        this.macKey = macKey;
    }

    @Override
    public void displayOn(ISimulationDisplay disp) {
        super.displayOn(disp);
        if (isSinkNode()) getGraphicNode().mark();
    }

}
