package simstation;

import mvc.Model;
import mvc.Subscriber;
import mvc.View;

import java.awt.*;

public class SimulationView extends View implements Subscriber {
    protected Simulation sim;
    //private List<AgentView> agentViews;
    public SimulationView(Model model) {
        super(model);
        sim = (Simulation) model;
    }

    @Override
    public void setModel(Model newModel) {
        super.setModel(newModel);
        sim = (Simulation) newModel;
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
