package simstation;

import mvc.Model;
import mvc.View;

public class SimulationView extends View {
    private Simulation sim;
    public SimulationView(Model model) {
        super(model);
        sim = (Simulation) model;
    }



}
