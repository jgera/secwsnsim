/*
 *  Wireless Sensor Network Simulator
 *  The next generation for WSN Simulations
 */
package org.wisenet.simulator.core.node.layers.mac;

import org.apache.commons.configuration.XMLConfiguration;
import org.wisenet.simulator.common.ObjectParameters;
import org.wisenet.simulator.common.Parameterizable;
import org.wisenet.simulator.common.PersistantException;
import org.wisenet.simulator.common.PersistantObject;
import org.wisenet.simulator.common.Persistent;

/**
 *
 * @author Pedro Marques da Silva <MSc Student @di.fct.unl.pt>
 */
public class MACLayerController extends PersistantObject implements Parameterizable,Persistent{

    protected long totalMessagesSent = 0;
    protected long totalMessagesNotSent = 0;
    protected long totalMessagesCorrupted = 0;

    protected MACLayerParameters parameters = new MACLayerParameters();

    public long getTotalMessagesCorrupted() {
        return totalMessagesCorrupted;
    }

    public void incrementTotalMessagesCorrupted() {
        totalMessagesCorrupted += 1;
    }

    public long getTotalMessagesNotSent() {
        return totalMessagesNotSent;
    }

    public void incrementTotalMessagesNotSent() {
        totalMessagesNotSent += 1;
    }

    public long getTotalMessagesSent() {
        return totalMessagesSent;
    }

    public void incrementTotalMessagesSent() {
        totalMessagesSent += 1;
    }

    public MACLayerParameters getParameters() {
        return parameters;
    }

    public void setParameters(ObjectParameters parameters) {
        this.parameters = (MACLayerParameters) parameters;
    }


    public void saveToXML(XMLConfiguration configuration) throws PersistantException {
        parameters.saveToXML(configuration);
    }

    public void loadFromXML(XMLConfiguration configuration) throws PersistantException {
        parameters.loadFromXML(configuration);
        
    }
    public void reset(){
        totalMessagesCorrupted=0;
        totalMessagesNotSent=0;
        totalMessagesSent=0;

    }
}
