import java.util.ArrayList;

/**
 * Created by Rahul on 7/19/2018.
 */
public class Genome {
    /**
     * TODO: Variable Genome Length???
     */
    private ArrayList<Gene> genome;
    public static final int length = 1;

    public Genome(ArrayList<Gene> genome){
        if(genome.size() != getLength()) throw new IllegalArgumentException("GENOME LENGTH ERROR 1");
        this.genome = genome;
    }

    public static Genome generateRandomGenome(){
        ArrayList<Gene> randomGenome = new ArrayList<>();
        for(int k = 0; k < getLength(); k++){
            randomGenome.add(Gene.generateRandomGene());
        }
        return new Genome(randomGenome);
    }

    public Gene getGene(int index){
        return genome.get(index);
    }

    public void setGene(int index, Gene value){
        genome.set(index, value);
    }

    public static int getLength(){return length;}

    public void setGeneBit(int geneIndex, int bitIndex, int value){
        getGene(geneIndex).setBit(bitIndex, value);
    }

    public String toString(){
        String s = "";
        for(Gene g: genome){
            s += g.toString() + " ";
        }
        return s;
    }

}
