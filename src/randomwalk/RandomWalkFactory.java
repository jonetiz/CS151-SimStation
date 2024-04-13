package randomwalk;

import mvc.Model;
import mvc.View;
import simstation.SimStationFactory;
import simstation.SimulationView;

public class RandomWalkFactory extends SimStationFactory {
    public View makeView(Model model) { return new RandomWalkView(model); }
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}
