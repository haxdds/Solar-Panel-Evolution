import java.util.ArrayList;

/**
 * Created by Rahul on 7/19/2018.
 */
public class Population {

    /**
     * TODO: Variable population size
     */
    private ArrayList<Individual> individuals;
    private static final int size = 20;


    public Population(){
        individuals = new ArrayList<>();
    }

    public Population(ArrayList<Individual> individuals){
        this.individuals = individuals;
    }

    public static Population generateRandomPopulation(){
        ArrayList<Individual> randomPopulation = new ArrayList<>();
        for(int k = 0; k < size; k++){
            randomPopulation.add(Individual.generateRandomIndividual());
        }
        return new Population(randomPopulation);
    }

    public  int getSize(){
        return individuals.size();
    }

    public Individual getFittest(){
        if(this.individuals == null || this.individuals.size() == 0) {
            throw new IllegalArgumentException("Population Collection ERROR 1");
        }
        int fittest = 0;
        for(int k = 1; k < individuals.size(); k++){
             if (getIndividual(k).getFitness() > getIndividual(fittest).getFitness()) {
                    fittest = k;
             }
        }
        return getIndividual(fittest);
    }

    public Individual getIndividual(int index){
        return individuals.get(index);
    }

    public void saveIndividual(int index, Individual individual){
        individuals.add(index, individual);
    }

    public void addIndividual(Individual individual){individuals.add(individual);}


}
