package flocking;

import mvc.Model;
import mvc.View;
import simstation.SimStationFactory;
import simstation.SimulationView;

public class FlockingFactory extends SimStationFactory {

    public Model makeModel() {
        return new FlockingSimulation();
    }

    public String getTitle() {
        return "SimStation Flocking";
    }

    public View makeView(Model model) { return new SimulationView(model); }
}
