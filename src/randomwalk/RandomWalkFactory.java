package randomwalk;

import mvc.Model;
import simstation.SimStationFactory;

public class RandomWalkFactory extends SimStationFactory {


    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}
