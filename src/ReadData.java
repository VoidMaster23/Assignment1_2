import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/**
 * Class to handle file reading and populating the terrain grid
 * @author Edson Shivuri
 */
public class ReadData {


    /**
     * Reads the data for the specified file and returns the terrain grid
     * @param fileName the file name to be used, e.g "text.txt"
     * @return the populated matrix
     */
    public static float[][] read(String fileName){
        File toRead;
        float[][] dataGrid = null;

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
                    dataGrid[i][j] = scanner.nextFloat();
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
