/**
 * Class that represents a basin  - to be returned on a successful find of a basin
 * @author Edson Shivuri
 */
public class Basin{
    private int row;
    private int column;
    private float height;

    /**
     * Constructor for the basin class
     * @param row the row index for the current basin
     * @param column the column index for the current basin
     * @param height the height of the basin
     */
    public Basin(int row, int column, float height){
        this.row = row;
        this.column = column;
        this.height = height;
    }

    //SETTER METHODS

    /**
     * Setter method for the row field
     * @param row row index to set
     */
    public void setRow(int row){
        this.row = row;
    }


    /**
     * Setter method for the column field
     * @param column column index to set
     */
    public void setColumn(int column){
        this.column = column;
    }

    /**
     * Setter method for the height field
     * @param height height to be set
     */
    public void setHeight(float height){
        this.height = height;
    }


    //Getter methods

    /**
     * Getter method for the column field
     * @return Returns the column index
     */
    public int getColumn() {
        return column;
    }

    /**
     * Getter method for the row field
     * @return Returns the row index
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter method for the height field
     * @return Returns the height of the basin
     */
    public float getHeight() {
        return height;
    }


    @Override
    public String toString() {
        return Integer.toString(row) +" "+ Integer.toString(column);
    }
}
