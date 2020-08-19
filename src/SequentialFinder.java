import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Class to run the sequential solution to the problem
 * @author Edson Shivuri
 */
public class SequentialFinder {

    public static float[][] terrain;
    public static ArrayList<Basin> basins;


    /**
     * Main method for the sequential solution
     * @param args command-line arguments in the format "data-file-name output-file-name"
     */
    public static void main(String[] args){
        //ensure valid file names
        if(args[0].contains(".txt") && args[1].contains(".txt")){
            terrain = ReadData.read(args[0], "seq");
            //System.out.println(terrain[0].length);
            basins = new ArrayList<Basin>();

            //set the grid of the terrain
            BasinUtils.terrain = terrain;

            BasinUtils.tick();
            //find the basins
            findBasins();

            float time  = BasinUtils.tock();

            System.out.println("Run took "+ time+" seconds");

            //output the basin data
            BasinUtils.printBasins(args[1],basins);
        }else{
            System.out.println("Error. Make sure the file names you enter end with \".txt\" ");
            System.exit(0);
        }


    }

    /**
     * Finds basins in the grid and uses them to populate the basin array
     */
    public static void findBasins(){

        //omit the first and last row as they are considered non-basins
        for(int i = 1; i < terrain.length-1; i++ ){

            //omit the first ans last column
            for(int j = 1; j < terrain[0].length -1; j++){

                //check if the current cel is a basin
                if(BasinUtils.isBasin(i,j)){
                    //System.out.println("HERE");
                    basins.add(new Basin(i,j,terrain[i][j]));
                }
            }
        }
    }


}
