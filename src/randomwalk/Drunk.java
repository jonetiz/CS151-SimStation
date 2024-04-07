package randomwalk;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

public class Drunk extends Agent {
    private static int name = 0;
    public Drunk() throws Exception {
        super(name + "");
        name++;
        heading = Heading.random();
    }

    public void update() throws Exception {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onInterrupted() {

    }

    @Override
    public void onExit() {

    }
}

