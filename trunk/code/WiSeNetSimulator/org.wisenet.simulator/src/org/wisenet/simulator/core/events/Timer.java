/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.wisenet.simulator.core.events;

import org.wisenet.simulator.core.Event;
import org.wisenet.simulator.core.Simulator;

/**
 *
 * @author Pedro Marques da Silva
 */
public abstract class Timer extends Event {

    int times = -1;
    int timesCount = 1;
    long delay = 1;
    boolean stop = false;
    Simulator simulator;

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Timer(Simulator simulator) {
        times = -1;
        delay = 1;
        this.simulator = simulator;
    }

    public Timer(Simulator simulator, long delay) {
        this.simulator = simulator;
        this.delay = delay;
    }

    public Timer(Simulator simulator, int times, long delay) {
        this.simulator = simulator;
        this.times = times;
        this.delay = delay;
    }

    @Override
    public void execute() {

        execution();
        if (!stop) {
            reschedule();
        }
    }

    public void reschedule() {
        setTime(getTime() + delay);
        getSimulator().addEvent(this);
    }

    public void stop() {
        stop = true;
    }

    public void start() {
        stop = false;
        setTime(getSimulator().getSimulationTime());
        reschedule();
    }

    public void start(int times, long delay) {
        this.times = times;
        this.delay = delay;
        start();
    }

    public abstract void executeAction();

    private void execution() {
        timesCount++;

        executeAction();
        if (times > -1 && timesCount > times) {
            stop();
        }
    }

    public Simulator getSimulator() {
        return simulator;
    }

    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
    }
}