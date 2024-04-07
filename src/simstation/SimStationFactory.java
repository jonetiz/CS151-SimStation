package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public abstract class SimStationFactory implements AppFactory {
    public abstract Model makeModel();

    public View makeView(Model model) {
        return new SimulationView(model);
    }

    public String getTitle() {
        return "SimStation";
    }

    public String[] getHelp() {
        return new String[0];
    }

    public String about() {
        return null;
    }

    public String[] getEditCommands() {
        return new String[0];
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        return null;
    }
}
