package flocking;

import mvc.Utilities;
import simstation.Agent;

public class Bird extends Agent {
    public int speed;
    public Bird() {
        super("");
        this.speed = Utilities.rng.nextInt(1, 6);
    }

    @Override
    public void update() throws Exception {
        setPartner(50); // get the neighbor
        Bird p = (Bird)getPartner();
        if (p != null) { // copy partner
            speed = p.speed;
            heading = p.heading;
        }
        move(speed);
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
