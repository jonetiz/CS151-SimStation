package prisonersDilemma;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean cheated;
    private boolean partnerCheated = false;
    private Strategy strategy;



    public Prisoner(Strategy strategy, String type) {
        super(type);
        this.strategy = strategy;
    }

    @Override
    public void update() throws Exception {
        heading = Heading.random();
        int steps = 10;
        move(steps);
        setPartner(10);
        Prisoner partner = (Prisoner)getPartner();

        if (partner != null) {
            cheated = !this.cooperate();
            partnerCheated = partner.cooperate();

            if (!cheated && !partnerCheated) {
                this.updateFitness(3);
                partner.updateFitness(3);
            } else if (!cheated && partnerCheated) {
                this.updateFitness(0);
                partner.updateFitness(5);
            } else if (cheated && !partnerCheated) {
                this.updateFitness(5);
                partner.updateFitness(0);
            } else {
                this.updateFitness(1);
                partner.updateFitness(1);
            }
        }
    }

    public boolean cooperate(){
        return strategy.cooperate();
    }

    public void updateFitness(int amt){
        this.fitness += amt;
    }
    public int getFitness(){
        return fitness;
    }

    public boolean getPartnerCheated() {
        return partnerCheated;
    }

    public Strategy getStrategy() {
        return strategy;
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
