package simstation;

import mvc.AppPanel;
import mvc.Model;

import javax.swing.*;

public class SimulationPanel extends AppPanel {
    @Override
    public void setModel(Model m) {
        super.setModel(m);
        Simulation s = (Simulation)m;
        for (Agent a : s.agents) {
            a.start();
        }
    }

    public SimulationPanel(SimStationFactory factory) {
        super(factory);
        JButton start = new JButton("Start");
        start.addActionListener(this);
        controlPanel.add(start);

        JButton suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        controlPanel.add(suspend);

        JButton resume = new JButton("Resume");
        resume.addActionListener(this);
        controlPanel.add(resume);

        JButton stop = new JButton("Stop");
        stop.addActionListener(this);
        controlPanel.add(stop);

        JButton stats = new JButton("Stats");
        stats.addActionListener(this);
        controlPanel.add(stats);
    }
}
