import java.util.ArrayList;

/**
 * Created by Rahul on 7/19/2018.
 */
public class GeneticAlgorithm {
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.02;
    private static final int tournamentSize = 5;
    private static final boolean elitism = false;

    public static Population evolvePopulation(Population p){
        Population newPopulation = new Population();

        if(elitism){
            newPopulation.saveIndividual(0, p.getFittest());
            mutate(newPopulation.getIndividual(0));
            newPopulation.getIndividual(0).calculateFitness();
        }

        int elitismOffset;
        if(elitism){
            elitismOffset = 1;
        }else{
            elitismOffset = 0;
        }

        for(int i = elitismOffset; i < p.getSize(); i++){
            Individual ind1 = tournamentSelection(p);
            Individual ind2 = tournamentSelection(p);

            Individual newInd = crossOver(ind1, ind2);

            newPopulation.saveIndividual(i, newInd);
        }

        for(int i = elitismOffset; i < p.getSize(); i++){
            mutate(newPopulation.getIndividual(i));
            newPopulation.getIndividual(i).calculateFitness();
        }

        return newPopulation;
    }

    public static void mutate(Individual i){
        for(int k = 0; k < Genome.getLength(); k++){
            for(int j = 0; j < Gene.getLength(); j++){
                if(Math.random() < mutationRate){
                    i.getGenome().setGeneBit(k, j, (int)Math.round(Math.random()));
                }
            }
        }
    }



    public static Individual crossOver(Individual ind1, Individual ind2){
        ArrayList<Gene> genome = new ArrayList<>();
        for(int k = 0; k < ind1.getGenome().getLength(); k++){
            int[] g = new int[Gene.getLength()];
            for(int j = 0; j < Genome.getLength(); j++){
                if(Math.random() < uniformRate){
                    g[j] = ind1.getGenome().getGene(k).getBit(j);
                }else{
                    g[j] = ind2.getGenome().getGene(k).getBit(j);
                }
            }
            genome.add(k, new Gene(g));
        }
        return new Individual(new Genome(genome));
    }


    public static Individual tournamentSelection(Population p){
        Population tournament = new Population();
        for(int i = 0; i < tournamentSize; i++){
            int randID = (int) (Math.random() * p.getSize());
            tournament.saveIndividual(i, p.getIndividual(randID));
        }
        return tournament.getFittest();
    }


}
