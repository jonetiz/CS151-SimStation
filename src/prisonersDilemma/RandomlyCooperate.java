package prisonersDilemma;

import mvc.Utilities;

public class RandomlyCooperate extends Strategy{
    public boolean cooperate() {
        return Utilities.rng.nextBoolean();
        }
}
