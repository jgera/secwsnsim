/*
 *  Wireless Sensor Network Simulator
 *  The next generation for WSN Simulations
 */
package org.wisenet.simulator.utilities.console;

import javax.swing.JOptionPane;
import org.wisenet.simulator.components.simulation.Simulation;
import org.wisenet.simulator.components.topology.RandomTopologyManager;
import org.wisenet.simulator.components.topology.RandomTopologyParameters;
import org.wisenet.simulator.components.topology.TopologyManager;
import org.wisenet.simulator.components.topology.TopologyParameters;
import org.wisenet.simulator.core.Simulator;
import org.wisenet.simulator.core.energy.EnergyModel;
import org.wisenet.simulator.core.radio.GaussianRadioModel;
import org.wisenet.simulator.core.ui.NoDisplay;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class SimulationConsole {

    private static SimulationSettings createSimulationSettings() {

        SimulationSettings settings = new SimulationSettings();
        settings.setMaxNodeRadioRange(130); //    int maxNodeRadioStrength;
//        settings.setNodeFactoryClassName(INSENSNodeFactory.class.getName()); //    String  nodeFactoryClassName;
        settings.setSimulatorClassName(Simulator.class.getName()); //    String simulatorClassName;
        settings.setRadioModelClassName(GaussianRadioModel.class.getName()); //    String radioModelClassName;
        settings.setEnergyModelClassName(EnergyModel.class.getName()); //    String energyModelClassName;
        settings.setSeed(1024);
        settings.setName("Console Simulation");
        settings.setEnvironAttenuation(0);
        settings.setStaticZ(true);
        settings.setMinZ(0);
        settings.setMaxZ(0);
        return settings;
    }

    /**
     * 
     * @return
     */
    private static RandomTopologyManager createTopologyManager() {

        TopologyParameters parameters = new RandomTopologyParameters();
        parameters.set("x", 0);
        parameters.set("y", 0);
        parameters.set("width", 300);
        parameters.set("height", 300);
        parameters.set("nodes", 100);
        RandomTopologyManager topologyManager = new RandomTopologyManager();
        topologyManager.setParameters(parameters);
        return topologyManager;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Simulation simulation = createSimulation();
            simulation.getSettings().saveToXML("SimulationSettings.xml");
            simulation.saveNetworkTopology("//home//posilva//NT.xml");


//            simulation.saveToXML("Simulation.dump.xml");
//            simulation.loadFromFile("Simulation.dump.xml");
            simulation.buildNetwork();
            simulation.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
//            Logger.getLogger(SimulationFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public static Simulation createSimulation() throws Exception {
        SimulationSettings settings = createSimulationSettings();//verificado
        TopologyManager manager = createTopologyManager();//verificado
        Simulation simulation = new Simulation();//verificado
        simulation.setDisplay(new NoDisplay());//verificado
        simulation.create(settings);
        simulation.appendNodes(manager);
        return simulation;
    }
}