/*
 *     Wireless Sensor Network Simulator
 *   The next generation for WSN Simulations
 */
package org.wisenet.protocols.insens.attacks;

import org.wisenet.simulator.core.node.layers.routing.RoutingLayer;
import org.wisenet.simulator.core.node.layers.routing.attacks.AbstractRoutingAttack;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class HelloFloodingRountingAttack extends AbstractRoutingAttack {

    private double oldRange;

    public HelloFloodingRountingAttack(RoutingLayer athis) {
        super(athis);
    }

    @Override
    public void prepare() {
        oldRange = getRoutingLayer().getNode().getConfig().getSetRadioRange();
        getRoutingLayer().getNode().getConfig().setSetRadioRange(230);
        getRoutingLayer().getNode().getSimulator().getSimulation().setNeedRebuildNetwork(true);
    }

    @Override
    public Object attackOnSend(Object message) {
        return message;
    }

    @Override
    public Object attackOnReceive(Object message) {
        return message;
    }

    @Override
    public Object attackOnDemand(Object message, Object command) {
        return message;
    }

    public void reset() {
        getRoutingLayer().getNode().getConfig().setSetRadioRange((int) oldRange);
        getRoutingLayer().getNode().getSimulator().getSimulation().setNeedRebuildNetwork(true);

    }
}