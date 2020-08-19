/**
 * Class to store a cell in the grid
 * @author Edson Shivuri
 */
public class Cell {

    public int rowInd;
    public int colInd;
    public float height;

    /**
     * Constructor for the cell class
     * @param row Row index of the cell
     * @param col Column index of the cell
     * @param height Height of the current cell
     */
    public Cell(int row, int col, float height ){
        rowInd = row;
        colInd = col;
        this.height = height;
    }
}
