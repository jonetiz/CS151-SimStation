package simstation;

import java.util.*;
import mvc.*;
import randomwalk.Drunk;

public abstract class Simulation extends Model {

    transient private Timer timer; // timers aren't serializable
    private int clock = 0;
    protected List<Agent> agents;

    public Simulation() {
        agents = new ArrayList<>();
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
        agent.setSimulation(this);
    }

    public void start() throws Exception {
        populate();

        for (Agent agent : agents) {
            agent.start();
        }

        // wait for agents to die
        for (Agent agent : agents) {
            try {
                agent.join();
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            } finally {
                System.out.println(agent.getName() + " has died");
            }
        }
        System.out.println("all done");
    }

    public void suspend() {
        for (Agent agent : agents) {
            agent.suspend();
        }
    }

    public void resume() {
        for (Agent agent : agents) {
            agent.resume();
        }
    }

    public void stop() {
        for (Agent agent : agents) {
            agent.stop();
        }
    }

    private double distance(Agent a, Agent b) {
        return Math.sqrt((a.getXc() - b.getXc()) * (a.getXc() - b.getXc()) +
                (a.getYc() - b.getYc()) * (a.getYc() - b.getYc()));
    }

    public Agent getNeighbor(Agent a, double radius) {
        int rand = Utilities.rng.nextInt(agents.size());
        for (Agent b : agents) {
            if (distance(a, b) < radius && b.getPartner() == null) { // need to check this assumption in real time
                a.updatePartner(b);
                b.updatePartner(a);
            }
        }
        return null;
    }

    public abstract void populate() throws Exception;

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }
}
