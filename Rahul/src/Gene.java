import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Rahul on 7/19/2018.
 */
public class Gene {
    /**
     *
     */
    private int[] gene;
    public static final int length = 8;

    public Gene(int[] gene){
        if(gene.length != getLength()) throw new IllegalArgumentException("GENE LENGTH ERROR 1");
        this.gene = gene;
    }

    public static Gene generateRandomGene(){
        int[] randomGene = new int[getLength()];
        for(int k = 0; k < getLength(); k++){
            if(Math.random() < 0.5){
                randomGene[k] = 0;
            }else{
                randomGene[k] = 1;
            }
        }
        return new Gene(randomGene);
    }

    public static int getLength(){return length;}

    public int getBit(int index){
        return gene[index];
    }

    public void setBit(int index, int value){
        gene[index] = value;
    }

    public String toString(){
        String s = "";
        for(int k: gene){
            s += k;
        }
        return s;
    }



}
