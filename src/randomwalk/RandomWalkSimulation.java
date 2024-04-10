package randomwalk;

import mvc.AppPanel;
import simstation.Agent;
import simstation.SimStationFactory;
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

    public void addAgent(Drunk drunk) {
        super.addAgent(drunk);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppPanel panel = new SimulationPanel(new RandomWalkFactory());
                panel.display();
            }
        });
    }

}
