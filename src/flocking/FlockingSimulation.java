package flocking;

import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class FlockingSimulation extends Simulation {
    @Override
    public void populate() {
        for(int i = 0; i < 30; i++) {
            addAgent(new Bird());
        }
    }

    public String[] getStats() {
        int speed1 = 0, speed2 = 0, speed3 = 0, speed4 = 0, speed5 = 0;
        for (Agent a : agents) {
            switch (((Bird)a).speed) {
                case 1 -> speed1++;
                case 2 -> speed2++;
                case 3 -> speed3++;
                case 4 -> speed4++;
                case 5 -> speed5++;
            }
        }
        return new String[]{"#birds @ speed 1 = " + speed1, "#birds @ speed 2 = " + speed2, "#birds @ speed 3 = " + speed3, "#birds @ speed 4 = " + speed4, "#birds @ speed 5 = " + speed5};
    }

    public static void main(String[] args) {
        SimulationPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
