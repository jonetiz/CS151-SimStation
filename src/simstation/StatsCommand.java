package simstation;

import mvc.Command;
import mvc.Model;

import javax.swing.*;

public class StatsCommand extends Command {
    public StatsCommand(Model model) {
        super(model);
    }

    public void execute() {
        Simulation sim = (Simulation) model;
        sim.stats();
    }
}
