/*
 *  Wireless Sensor Network Simulator
 *  The next generation for WSN Simulations
 */
package org.wisenet.simulator.components.evaluation.tests.events;

import org.wisenet.simulator.core.Message;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public abstract class TestExecutionEvent extends AbstractTestEvent {

    Message message;

    /**
     *
     * @return
     */
    public Message getMessage() {
        return message;
    }

    /**
     *
     * @param message
     */
    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public void execute() {
    }
}