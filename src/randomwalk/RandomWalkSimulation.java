package randomwalk;

import mvc.AppPanel;
import simstation.Simulation;
import simstation.SimulationPanel;

import javax.swing.*;

public class RandomWalkSimulation extends Simulation {
    //private int size = 15;
    public RandomWalkSimulation() {
        super();
    }

    public void populate() throws Exception {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());
    }

    public String[] getStats() {
        return new String[]{" #agents = " + getAgents().size(), "clock = " + getClock()};
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AppPanel panel = new SimulationPanel(new RandomWalkFactory());
            panel.display();
        });
    }

}
