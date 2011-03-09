/*
 ***  Wireless Sensor Network Simulator
 * The next generation for WSN Simulations
 */
package org.wisenet.simulator.components.output;

import java.util.HashSet;
import java.util.Set;
import org.wisenet.simulator.core.Application;
import org.wisenet.simulator.core.node.layers.Layer;

/**
 *
* @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public abstract class LayerOutput {

    /**
     *
     */
    protected static LayerOutput instance;

    /**
     *
     * @return
     */
    public static LayerOutput getInstance() {
        throw new IllegalStateException("Must create a derived class");
    }
    Set<IOutputDisplay> subscribers = new HashSet<IOutputDisplay>();

    /**
     *
     * @param layer
     * @param message
     */
    public void output(Layer layer, String message) {
        displayOnSubscribers("<" + layer.getClass().getSimpleName() + "> [" + layer.getNode().getId() + "]\t" + message);
    }

    /**
     *
     * @param output
     */
    protected synchronized void displayOnSubscribers(String output) {
        for (IOutputDisplay iApplicationOutputDisplay : subscribers) {
            iApplicationOutputDisplay.showOutput(output);
        }
    }

    /**
     *
     * @param display
     */
    public void subscribe(IOutputDisplay display) {
        subscribers.add(display);
    }

    /**
     *
     * @param display
     */
    public void unsubscribe(IOutputDisplay display) {
        subscribers.remove(display);
    }
}