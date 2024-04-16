package plague;

import mvc.Model;
import simstation.Agent;
import simstation.SimulationView;

import javax.swing.*;
import java.awt.*;

public class PlagueView extends SimulationView {
    private PlagueSimulation plague;
    public PlagueView(Model model) {
        super(model);
        plague = (PlagueSimulation) model;
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);

        for (Agent agent : plague.getAgents()) {
            if (((Host) agent).infected) {
                gc.setColor(Color.RED);
            } else {
                gc.setColor(Color.GREEN);
            }
            gc.fillRect(agent.getXc(),agent.getYc(),10,10);
        }

    }

    @Override
    public void update() {
        super.update();
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement traceElement = stacktrace[4];
        for (StackTraceElement e : stacktrace) {
            System.out.println(e + " ");
        }
        String methodName = traceElement.getMethodName();
        if (methodName.equalsIgnoreCase("stats")) {
            JOptionPane.showMessageDialog(null,
                    " #agents = " + plague.getAgents().size() + "\n" +
                            "clock = " + plague.getClock() + "\n" +
                            "% infected = " + plague.getInfected());
        }
    }
}