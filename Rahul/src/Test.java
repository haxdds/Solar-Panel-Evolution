import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rahul on 7/19/2018.
 */
public class Test {

    public static void main(String[] args) {
//        Individual i1 = Individual.generateRandomIndividual();
//        Individual i2 = Individual.generateRandomIndividual();
        Population old = Population.generateRandomPopulation();
        ArrayList<Population> gens = new ArrayList<>();
        gens.add(0, old);
        double fitte = -100;
        double angle = 0;

        Population fittest = new Population();

        for(int k = 1; k < 1000; k++){
            double fet = gens.get(k-1).getFittest().getFitness();
            double ang = Fitness.toAngle(gens.get(k-1).getFittest().getGenome())[0];
            if(fet > fitte){
                fitte = fet;
                angle = ang;
            }
            System.out.println("GENERATION: " + (k-1) + ",  FITNESS: " + fet +
            "  ANGLE: " + ang);
            //System.out.println("GENOME:" + gens.get(k-1).getFittest().getGenome().toString());
            gens.add(k , GeneticAlgorithm.evolvePopulation(gens.get(k-1)));
            fittest.addIndividual(gens.get(k-1).getFittest());
        }

        System.out.println("FITNESS: " + fitte +
                "  ANGLE: " + (angle * 180 / Math.PI));
//        Population p = Population.generateRandomPopulation();
//        p.saveIndividual(0, Individual.generateRandomIndividual());
//        p.getIndividual(0);

//        Individual i = Individual.generateRandomIndividual();
//        System.out.println(i.getGenome().toString() + "  Decimal: " + Arrays.toString(Fitness.toInteger(i.getGenome()))
//                + "  Angle:" + Arrays.toString(Fitness.toAngle(i.getGenome())));
    }


}
