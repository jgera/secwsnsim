/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wisenet.protocols.insens;

import org.wisenet.simulator.core.node.layers.mac.Mica2MACLayer;
import org.wisenet.simulator.core.node.factories.AbstractNodeFactory;

/**
 *
 * @author pedro
 */
public class INSENSNodeFactory extends AbstractNodeFactory {

    public INSENSNodeFactory() {
    }

    @Override
    public void setup() {
        setApplicationClass(EvaluateINSENSApplication.class);
        setRoutingLayerClass(INSENSRoutingLayer.class);
        setNodeClass(INSENSNode.class);
        setMacLayer(Mica2MACLayer.class);
        setSetup(true);
    }
}
