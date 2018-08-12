import java.util.ArrayList;

/**
 * Created by Rahul on 7/19/2018.
 */
public class Individual{

    private Genome genome;
    private double fitness;

    public Individual(Genome genome){
        this.genome = genome;
        calculateFitness();
    }

    public static Individual generateRandomIndividual(){
        return new Individual(Genome.generateRandomGenome());
    }

    public void calculateFitness(){
        this.fitness = Fitness.fitness(genome);
    }

    public double getFitness(){
        return fitness;
    }

    public Genome getGenome(){
        return this.genome;
    }

    public String toString(){
        return "";
    }

}
