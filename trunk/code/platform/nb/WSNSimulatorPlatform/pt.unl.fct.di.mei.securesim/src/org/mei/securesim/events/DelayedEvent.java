/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mei.securesim.events;

import org.mei.securesim.core.engine.Event;

/**
 *
 * @author CIAdmin
 */
public abstract class DelayedEvent extends Event{
    long delay=0;

    public DelayedEvent(long delay) {
        super(delay);
    }
    public DelayedEvent(long time, long delay) {
        super(time+delay);
    }

    public DelayedEvent() {
    }

    public void setDelay(long delay) {
        this.delay = delay;
        time+= delay;
    }
}
