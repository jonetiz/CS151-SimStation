package plague;

import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50;
    public static int RESISTANCE = 2;

    @Override
    public void populate() throws Exception {
        for(int i = 0; i < 50; i++)
            addAgent(new Host());
    }

    @Override
    public void stats() {
        Utilities.inform(new String[]{"#agents = " + agents.size(), "clock = NIMP", "% infected = " + getInfected()});
    }

    public Double getInfected() {
        int i = 0;
        for (Agent a : agents) {
            if (((Host)a).infected) i++;
        };
        return (double) (i / agents.size());
    }

    public static void main(String[] args) {
        SimulationPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}
