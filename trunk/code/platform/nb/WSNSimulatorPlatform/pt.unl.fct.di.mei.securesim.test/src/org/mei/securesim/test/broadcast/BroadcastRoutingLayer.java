/**
 * 
 */
package org.mei.securesim.test.broadcast;

import org.mei.securesim.core.Application;
import org.mei.securesim.core.layers.RoutingLayer;
import org.mei.securesim.core.nodes.Node;

/**
 * @author posilva
 *
 */
public class BroadcastRoutingLayer extends RoutingLayer {

    private Node parent;

    public BroadcastRoutingLayer() {
        super();
    }

    /**
     * Stores the sender from which it first receives the message, and passes
     * the message.
     */
    @Override
    public void receiveMessage(Object message) {
//        if (parent == null) {
//            //parent = getNode().getParentNode();
            //Application app = getNode().getApplication(sendApplication.getClass());
            Application app = getNode().getApplication();
            if (app != null) {
                app.receiveMessage(message);
            }
//        }
    }

    @Override
    public boolean sendMessage(Object message, Application app) {
        application=app;
        return getNode().getMacLayer().sendMessage(message, this);
    }

    /**
     * Sets the sent flag to true.
     */
    @Override
    public void sendMessageDone() {
        application.sendMessageDone();
        application = null;
    }
}
