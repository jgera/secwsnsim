/*
 **  Wireless Sensor Network Simulator
 *  The next generation for WSN Simulations
 */
package org.wisenet.protocols.common.attacks;

import org.wisenet.simulator.core.node.layers.routing.RoutingLayer;
import org.wisenet.simulator.core.node.layers.routing.attacks.AbstractRoutingAttack;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class BlackholeRoutingAttack extends AbstractRoutingAttack {

    /**
     *
     */
    public BlackholeRoutingAttack() {
        super();
    }

    /**
     *
     * @param routingLayer
     */
    public BlackholeRoutingAttack(RoutingLayer routingLayer) {
        super(routingLayer);
    }

    @Override
    public Object attack(Object message) {
        if (getRoutingLayer().isStable()) {
         // log("Suppress Message");
	System.out.println("MESSAGE DROPPED IN A BLACKHOLE");
            return null; // Supress message
        } else {

            return message;
        }
    }
}


