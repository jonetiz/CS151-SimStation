package prisonersDilemma;

import mvc.Model;
import mvc.View;
import simstation.SimStationFactory;

public class PrisonerFactory extends SimStationFactory {
    @Override
    public Model makeModel() {
        return new PrisonerSimulation();
    }

    @Override
    public String getTitle() {
        return "SimStation Prisoner's Dilemma";
    }

    @Override
    public View makeView(Model model) {
        return new PrisonerView(model);
    }
}
