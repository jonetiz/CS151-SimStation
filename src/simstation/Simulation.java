package simstation;

import java.util.*;
import java.util.Timer;

import mvc.*;
import randomwalk.Drunk;

import javax.swing.*;

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
            System.out.println(agent.getName());
            agent.start();
            //agent.run();
            changed();
        }
        /*
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

         */
    }

    public void suspend() {
        for (Agent agent : agents) {
            agent.suspend();
            changed();
        }
    }

    public void resume() {
        for (Agent agent : agents) {
            agent.resume();
            changed();
        }
    }

    public void stop() {
        for (Agent agent : agents) {
            agent.stop();
            changed();
        }
    }

    private double distance(Agent a, Agent b) {
        return Math.sqrt((a.getXc() - b.getXc()) * (a.getXc() - b.getXc()) +
                (a.getYc() - b.getYc()) * (a.getYc() - b.getYc()));
    }

    public Agent getNeighbor(Agent a, double radius) {
        int rand = Utilities.rng.nextInt(agents.size());
        int i = 0;
        while (i < agents.size()) {
            Agent b = agents.get(rand);
            if (a != b && distance(a, b) < radius && b.showPartner() == null) { // need to check this assumption in real time
                return b;
            }
            rand++;
            if (rand >= agents.size()) {
                rand = 0;
            }
            i++;
        }
        return null;
    }

    public abstract void populate() throws Exception;

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }

    /*public String stats() {
        return "#agents = " + agents.size() + "\n" + "clock = " + clock + "\n";
    }*/

    public void stats() {
        changed();
    }
}
