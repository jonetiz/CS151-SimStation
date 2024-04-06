package simstation;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Agent implements Serializable, Runnable {
    private String name;
    private int heading;
    private int xc;
    private int yc;
    private boolean suspended = false;
    private boolean stopped = false;
    private Thread myThread;
    private ArrayList<Simulation> world;

    public void run() {

    }

    public void start() {

    }

    public void suspend() {

    }

    public void resume() {

    }

    public abstract void update();

    public void move(int steps) {

    }
}
