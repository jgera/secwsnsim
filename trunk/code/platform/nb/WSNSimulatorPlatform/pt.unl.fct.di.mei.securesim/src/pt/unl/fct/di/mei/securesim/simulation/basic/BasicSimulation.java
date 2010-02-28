/**
 * 
 */
package pt.unl.fct.di.mei.securesim.simulation.basic;

import pt.unl.fct.di.mei.securesim.simulation.Simulation;

/**
 * @author posilva
 *
 */
public class BasicSimulation extends Simulation {

    /**
     *
     */
    public BasicSimulation() {
    }

    /* (non-Javadoc)
     * @see pt.unl.fct.di.mei.securesim.simulation.Simulation#start()
     */
    @Override
    public void start() {
        getSimulator().runWithDisplayInRealTime();
    }

    /* (non-Javadoc)
     * @see pt.unl.fct.di.mei.securesim.simulation.Simulation#stop()
     */
    @Override
    public void stop() {
    }

}
