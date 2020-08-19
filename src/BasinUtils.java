import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Class containing helper methods for identifying a basin
 *
 * @author Edson Shivuri
 */
public class BasinUtils {

    public static float[][] terrain;
    static long startTime = 0;

    public static void tick(){
        startTime = System.currentTimeMillis();
    }
    public static float tock() {
        return (System.currentTimeMillis() - startTime) / 1000.0f;
    }

    /**
     * Method to check whether the grid item at a specific index is a basin by checking its surrounding items
     *
     * @param row row index of desired item
     * @param col column index of desired item
     * @return Returns true if the cell is at least 0.01 lower than the surrounding cells adn false otherwise
     */
    public static boolean isBasin(int row, int col) {
        float myCell = terrain[row][col];
        //System.out.println(myCell);
        return (myCell <= terrain[row - 1][col - 1] - 0.01) &&
                (myCell <= terrain[row][col - 1] - 0.01) &&
                (myCell <= terrain[row + 1][col - 1] - 0.01) &&
                (myCell <= terrain[row + 1][col] - 0.01) &&
                (myCell <= terrain[row + 1][col + 1] - 0.01) &&
                (myCell <= terrain[row][col + 1] - 0.01) &&
                (myCell <= terrain[row - 1][col + 1] - 0.01) &&
                (myCell <= terrain[row-1][col] - 0.01);


    }

    /**
     * Writes the basin data to the file
     * @param basins an arraylist of basins that is to be printed
     * @param outfile file name to write the data to
     */
    public static void printBasins(String outfile, ArrayList<Basin> basins){
        try{
            FileWriter outFile = new FileWriter("../out/"+outfile);
            outFile.write(Integer.toString(basins.size()));
            outFile.write("\n");

            for (Basin b: basins) {
                outFile.write(b.toString());
                outFile.write("\n");
            }

            outFile.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error while trying to write to file!");
            System.exit(0);
        }


    }

}
