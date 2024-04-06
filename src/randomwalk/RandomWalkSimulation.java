package randomwalk;

public class RandomWalkSimulation {
    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }

}
