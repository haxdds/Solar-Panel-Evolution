/**
 * Created by Rahul on 7/19/2018.
 */
public class Fitness {

    public static int[] toInteger(Genome x){
        int s[] = new int[Genome.getLength()];
        for(int k = 0; k < Genome.getLength(); k++){
            String stemp = "";
            for(int j = 0; j < Gene.getLength(); j++) {
                stemp += x.getGene(k).getBit(j);
            }
            s[k] = Integer.parseInt(stemp, 2);
        }
        return s;
    }

    public static double fitness(Genome x){
        double[] angles = toAngle(x);
//        double total = 0;
//        for(int k = 0; k < Genome.getLength(); k++){
//            for(int day = 170; day < 171; day++){
//                for(int hour = -12; hour <= 11; hour++) {
//                    total += (Math.sin(getSunDeclination(day))*Math.cos(angles[k])) +
//                           (Math.cos(getSunDeclination(day))*Math.sin(angles[k])* Math.cos(hour * Math.PI / 12)) ;
//                }
//            }
//
//        }
        return -1 * Math.pow(angles[0]-1,2);
    }

    public static double getSunDeclination(int s){
        return 23.45 * Math.sin(Math.PI*360*(284 + s)/365/180) * Math.PI / 180;
    }


//    public static double fitness(Genome x){
//        String stemp = "";
//        for(int k = 0; k < Genome.getLength(); k++){
//
//            for(int j = 0; j < Gene.getLength(); j++) {
//                stemp += x.getGene(k).getBit(j);
//            }
//
//        }
//        return Integer.parseInt(stemp, 2);
//    }

    public static double[] toAngle(Genome x){
        double scale = (Math.PI) / (Math.pow(2, Gene.length) - 1);
        int[] bits = toInteger(x);
        double[] angles = new double[bits.length];
        for(int k = 0; k < bits.length; k++){
            angles[k] = scale * bits[k];
        }
        return angles;
    }

}
