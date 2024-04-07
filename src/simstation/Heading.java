package simstation;

import mvc.Utilities;

public class Heading {
    private int degrees;
    public Heading() {
        this.degrees = Utilities.rng.nextInt(360);
    }
    public static Heading random() throws Exception {
        return new Heading();
    }
}
