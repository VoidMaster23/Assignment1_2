/**
 * Class containing helper methods for identifying a basin
 *
 * @author Edson Shivuri
 */
public class BasinUtils {

    public static float[][] terrain;

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

}
