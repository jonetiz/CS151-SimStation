package simstation;

import mvc.Command;
import mvc.Model;

public class StartCommand extends Command {
    public StartCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        Simulation sim = (Simulation) model;
        sim.start();
    }
}
