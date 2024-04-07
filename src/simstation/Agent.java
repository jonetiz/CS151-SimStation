package simstation;

import mvc.Utilities;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Agent implements Serializable, Runnable {
    private String name;
    protected Heading heading;
    private int xc;
    private int yc;
    private boolean suspended = false;
    private boolean stopped = false;
    transient protected Thread myThread;
    private Simulation world;
    private Agent partner = null;

    public Agent(String name) throws Exception {
        this.name = name;
        Heading.random();
        myThread = null;
        xc = 0;
        yc = 0;
    }

    public synchronized void join() throws InterruptedException {
        try {
            if (myThread != null) myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void run() {
        myThread = Thread.currentThread(); // catch my thread
        while(!stopped) {
            try {
                onStart();
                onInterrupted();
                onExit();
                update();
                Thread.sleep(1000);
                checkSuspended();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public synchronized void suspend() {
        suspended = true;
    }

    public synchronized void resume() {
        notify();
    }

    public synchronized void stop() {
        stopped = true;
    }

    public abstract void update() throws Exception;

    public void updateCoordinates() {
        // update xc, yc
    }

    public synchronized void move(int steps) {
        for (int i=0;i<steps;i++) {
            updateCoordinates();
            world.changed();
        }
    }

    public void setSimulation(Simulation simulation) {
        this.world = simulation;
    }

    // wait for notification if I'm not stopped and I am suspended
    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void onStart();
    public abstract void onInterrupted();
    public abstract void onExit();

    public synchronized String getName() {
        String result = name;
        if (stopped) result += " (stopped)";
        else if (suspended) result += " (suspended)";
        else result += " (running)";
        return result;
    }

    public int getXc() {
        return xc;
    }
    public int getYc() {
        return yc;
    }

    public void updatePartner(Agent partner) {
        this.partner = partner;
    }

    public Agent getPartner() {
        return this.partner;
    }
}
