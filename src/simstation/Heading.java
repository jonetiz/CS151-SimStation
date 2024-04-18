package simstation;

import mvc.Utilities;

import java.io.Serializable;

public class Heading implements Serializable {
    protected int degrees;
    public Heading() {
        this.degrees = Utilities.rng.nextInt(360);
    }
    public static Heading random() {
        return new Heading();
    }
}