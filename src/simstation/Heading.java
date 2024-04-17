package simstation;

import mvc.Utilities;

public class Heading {
    protected int degrees;
    public Heading() {
        this.degrees = Utilities.rng.nextInt(360);
    }
    public static Heading random() {
        return new Heading();
    }
}