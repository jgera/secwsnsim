/*
 ***  Wireless Sensor Network Simulator
 * The next generation for WSN Simulations
 */
package org.wisenet.protocols.insens.messages.data;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.wisenet.protocols.insens.INSENSException;
import org.wisenet.simulator.utilities.CryptoFunctions;

/**
 *
 * @author Pedro Marques da Silva
 */
public class DATAPayload extends INSENSMessagePayload {

    /**
     *
     */
    public short source;
    /**
     *
     */
    public short destination;
    /**
     *
     */
    public short immediate;
    /**
     *
     */
    public int size;
    /**
     *
     */
    public byte[] data;
    /**
     *
     */
    public byte[] mac;

    /**
     *
     * @param payload
     * @throws INSENSException
     */
    public DATAPayload(byte[] payload) throws INSENSException {
        super(payload);

        try {
            source = badis.readShort();
            destination = badis.readShort();
            immediate = badis.readShort();
            size = badis.readInt();
            data = new byte[size];
            badis.read(data);
            mac = new byte[CryptoFunctions.MAC_SIZE];
            badis.read(mac);
        } catch (IOException ex) {
            Logger.getLogger(DATAPayload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}