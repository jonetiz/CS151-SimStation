package simstation;

import mvc.Publisher;
import mvc.Utilities;

import java.io.Serializable;

import static java.lang.Thread.sleep;

public abstract class Agent extends Publisher implements Serializable, Runnable {
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
        heading = Heading.random();
        myThread = null;
        xc = Utilities.rng.nextInt(500);
        yc = Utilities.rng.nextInt(500);;
    }

    public synchronized void run() {
        myThread = Thread.currentThread(); // catch my thread
        System.out.println("running...");
        while(!stopped) {
            try {
                onStart();
                onInterrupted();
                onExit();
                update();
                sleep(1000);
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

    public synchronized void join() throws InterruptedException {
        try {
            if (myThread != null) myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        this.xc = (int) (xc + Math.sin(heading.degrees));
        this.yc = (int) (yc + Math.cos(heading.degrees));
    }

    public synchronized void move(int steps) throws InterruptedException {
        int originalXc = this.xc;
        int originalYc = this.yc;
        for (int i=0;i<steps;i++) {
            //updateCoordinates();
            double newXc = (i+1) * Math.sin(Math.PI * (double)this.heading.degrees / 180.0);
            double newYc = (i+1) * Math.cos(Math.PI * (double)this.heading.degrees / 180.0);
            this.xc = originalXc + (int) newXc;
            this.yc = originalYc + (int) newYc;
            world.changed();
            sleep(20);
        }
    }

    public synchronized void setSimulation(Simulation simulation) {
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

    /*public synchronized void updatePartner(Agent partner) {
        this.partner = partner;
    }*/

    public synchronized void setPartner() {
        this.partner = world.getNeighbor(this, 10);
    }
    public synchronized Agent showPartner() {
        return this.partner;
    }
}
