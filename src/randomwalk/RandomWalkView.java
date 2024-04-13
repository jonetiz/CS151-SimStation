package randomwalk;

import mvc.Model;
import simstation.SimulationView;

import javax.swing.*;

public class RandomWalkView extends SimulationView {
    private RandomWalkSimulation randomWalk;

    public RandomWalkView(Model model) {
        super(model);
        randomWalk = (RandomWalkSimulation) model;
    }

    @Override
    public void update() {
        /*SwingWorker sw2 = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {

                return null;
            }
        }*/
        super.update();
        StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();
        StackTraceElement traceElement = stacktrace[4];
        for (StackTraceElement e : stacktrace) {
            System.out.println(e + " ");
        }
        String methodName = traceElement.getMethodName();
        if (methodName.equalsIgnoreCase("stats")) {
            JOptionPane.showMessageDialog(null,
                            " #agents = " + randomWalk.getAgents().size() + "\n" +
                            "clock = " + randomWalk.getClock() + "\n");
        }
    }
}
