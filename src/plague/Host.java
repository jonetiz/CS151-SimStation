package plague;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

public class Host extends Agent {
    public boolean infected = false;

    public Host() throws Exception {
        super("");
        heading = Heading.random();
    }

    @Override
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
