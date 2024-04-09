package simstation;

import mvc.Model;
import mvc.Subscriber;
import mvc.View;

import java.awt.*;

public class SimulationView extends View implements Subscriber {
    private Simulation sim;
    //private List<AgentView> agentViews;
    public SimulationView(Model model) {
        super(model);
        sim = (Simulation) model;

    }

    public void update() {
        super.update();
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        for (Agent agent : sim.agents) {
            gc.setColor(Color.BLUE);
            Color oldColor = gc.getColor();
            gc.fillOval(agent.getXc(),agent.getYc(),10,10);
            gc.setColor(oldColor);
        }

    }


}
