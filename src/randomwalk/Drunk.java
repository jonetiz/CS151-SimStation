package randomwalk;

public class Drunk {
    public Drunk() {
        super();
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }
}

