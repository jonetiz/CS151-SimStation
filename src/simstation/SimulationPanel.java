package simstation;

import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;

public class SimulationPanel extends AppPanel {

    private JButton start;
    private JButton suspend;
    private JButton resume;
    private JButton stop;
    private JButton stats;

    public SimulationPanel(SimStationFactory factory) {
        super(factory);
        start = new JButton("Start");
        start.addActionListener(this);
        controlPanel.add(start);

        suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        controlPanel.add(suspend);

        resume = new JButton("Resume");
        resume.addActionListener(this);
        controlPanel.add(resume);

        stop = new JButton("Stop");
        stop.addActionListener(this);
        controlPanel.add(stop);

        stats = new JButton("Stats");
        stats.addActionListener(this);
        controlPanel.add(stats);
    }
}
