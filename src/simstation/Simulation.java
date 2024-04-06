package simstation;

import java.util.*;
import mvc.*;

public class Simulation extends Model {

    transient private Timer timer; // timers aren't serializable
    private int clock = 0;
    private ArrayList<Agent> agents = new ArrayList<>();

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public void start() {

    }

    public void suspend() {

    }

    public void resume() {

    }

    public void stop() {

    }

    public Agent getNeighbor(Agent a, double radius) {
        return null;
    }

    public void populate() {

    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }
}
