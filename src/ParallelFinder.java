import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

/**
 * Class to run the parallel solution
 * @author Edson Shivuri
 */
public class ParallelFinder {

    public static final ForkJoinPool fj = new ForkJoinPool();
    public static float[][] terrain;
    public static ArrayList<Basin>  basins;
    public static Cell[] cells;
    /**
     * Main method for the parallel solution
     * @param args command-line arguments in the format "data-file-name output-file-name"
     */
    public static void main(String[] args){
        //ensure valid file names
        if(args[0].contains(".txt") && args[1].contains(".txt")){
            terrain = ReadData.read(args[0],"par");

            //get the cells arraylist and flatten that to an array
            cells =  ReadData.cells.toArray(new Cell[ReadData.cells.size()]);

            //set the grid of the terrain
            BasinUtils.terrain = terrain;

            //timing
            BasinUtils.tick();

            //start the parallel algorithm
            basins = findBasins(cells);

            float time = BasinUtils.tock();

            System.out.println("Run took "+ time+" seconds");

            //remove all null basins
            basins.removeAll(Collections.singleton(null));

            //print the basins
            BasinUtils.printBasins(args[1], basins);
        }else{
            System.out.println("Error. Make sure the file names you enter end with \".txt\" ");
            System.exit(0);
        }
    }

    public static ArrayList<Basin> findBasins(Cell[] cells){
        return fj.invoke(new FindParallelBasin(cells, 0, cells.length));
    }

}
