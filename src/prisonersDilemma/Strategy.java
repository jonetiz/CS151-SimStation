package prisonersDilemma;

import java.io.Serializable;

abstract class Strategy implements Serializable {
    protected Prisoner myPrisoner;
    public abstract boolean cooperate();

    protected void setPrisoner(Prisoner prisoner){
        this.myPrisoner = prisoner;
    }
}
