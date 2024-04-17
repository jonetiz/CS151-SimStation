package prisonersDilemma;

import flocking.FlockingFactory;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PrisonerSimulation extends Simulation {
    @Override
    public void populate() throws Exception {
        for (int i = 0; i < 40; i++){
            if (i < 10){
                addAgent(new Prisoner(new Cooperate(), "Cooperater"));
            }
            else if (i < 20){
                addAgent(new Prisoner(new Cheat(), "Cheater"));
            }
            else if (i < 30){
                addAgent(new Prisoner(new RandomlyCooperate(), "Random"));
            }
            else{
                addAgent(new Prisoner(new Tit4Tat(),"Tit4Tater"));
            }
        }
        for (Agent a: agents){
            ((Prisoner)a).getStrategy().setPrisoner((Prisoner)a);
        }

    }

    @Override
    public String[] getStats() {
        int cheaterAverage = 0;
        int cooperaterAverage = 0;
        int randomCooperaterAverage = 0;
        int tit4TaterAverage = 0;

        for(Agent a:agents){
            if(a.getName().contains("Cheater")){
                cheaterAverage += ((Prisoner)a).getFitness();
            }else if(a.getName().contains("Cooperater")) {
                cooperaterAverage += ((Prisoner) a).getFitness();
            }else if(a.getName().contains("Random")) {
                randomCooperaterAverage += ((Prisoner) a).getFitness();
            }else {
                tit4TaterAverage += ((Prisoner) a).getFitness();
            }
        }
        cheaterAverage = cheaterAverage/10;
        cooperaterAverage =  cooperaterAverage/10;
        randomCooperaterAverage = randomCooperaterAverage/10;
        tit4TaterAverage = tit4TaterAverage/10;

        return new String[]{"Cheater Average Fitness " + cheaterAverage, "Cooperater Average Fitness " + cooperaterAverage, "Random Cooperater Average Fitness " +  randomCooperaterAverage, "Tit4Tater Average Fitness " + tit4TaterAverage};
    }

    public static void main(String[] args) {
        SimulationPanel panel = new SimulationPanel(new PrisonerFactory());
        panel.display();
    }
}
