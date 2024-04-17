package prisonersDilemma;

public class Tit4Tat extends Strategy{

    public boolean cooperate() {
        if (myPrisoner.getPartnerCheated()){
            return false;
        }
        return true;
    }
}
