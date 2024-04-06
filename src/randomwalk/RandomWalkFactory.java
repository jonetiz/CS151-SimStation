package randomwalk;

public class RandomWalkFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}
