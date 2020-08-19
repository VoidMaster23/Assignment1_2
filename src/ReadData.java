import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to handle file reading and populating the terrain grid
 * @author Edson Shivuri
 */
public class ReadData {

    public static ArrayList<Cell> cells;

    /**
     * Reads the data for the specified file and returns the terrain grid
     * @param fileName the file name to be used, e.g "text.txt"
     * @param type Specify the class that called it as seq or par, if par it also populates the cells list
     * @return the populated matrix
     */
    public static float[][] read(String fileName, String type){
        File toRead;
        float[][] dataGrid = null;
        cells = new ArrayList<>();

        //catch the possible not found exception
        try{
            toRead = new File("../res/"+fileName);

            Scanner scanner = new Scanner(toRead);

            //extract the rows and columns
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            //move the pointer to the next line
            //scanner.nextLine();

            //create the grid
            dataGrid = new float[rows][columns];

            //populate the grid
            for(int i = 0; i < rows; i++){

                for(int j = 0; j < columns; j++){
                    //get the height
                    float height = scanner.nextFloat();
                    dataGrid[i][j] = height;

                    //for the parallel implementation, this creates an array of "valid" cells
                    if(type.equals("par")){
                        if(i > 0 && i < rows-1){
                            if(j > 0 && j < columns-1){
                                cells.add(new Cell(i,j, height));
                            }
                        }


                    }
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: file not found in directory!");
            System.exit(0);
        }
        return dataGrid;
    }

}
