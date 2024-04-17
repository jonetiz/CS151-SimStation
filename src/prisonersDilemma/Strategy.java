package prisonersDilemma;

abstract class Strategy {
    protected Prisoner myPrisoner;
    public abstract boolean cooperate();

    protected void setPrisoner(Prisoner prisoner){
        this.myPrisoner = prisoner;
    }
}
