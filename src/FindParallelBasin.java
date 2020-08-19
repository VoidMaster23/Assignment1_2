import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

/**
 * Class that breaks the grid down to individual cells and checks if those cells are basins
 * @author Edson Shivuri
 */
public class FindParallelBasin extends RecursiveTask<ArrayList<Basin>> {
  public Cell[] arr;
  int high;
  int low;
  public static final int SEQUENTIAL_CUTOFF = 2000;

  public ArrayList<Basin> basins = new ArrayList<>();

    /**
     * Constructor For the class
     * @param arr the Cell array to be passed in
     * @param low the start index to loop through
     * @param high the end index to loop through
     */
  FindParallelBasin(Cell[] arr, int low, int high){
      this.arr = arr;
      this.low = low;
      this.high = high;

  }

    /**
     * Overridden compute method
     * @return an ArrayList of basins
     */
    @Override
    protected ArrayList<Basin> compute() {
      // check if we're below sequential cutoff point
        if((high-low)  < SEQUENTIAL_CUTOFF){
            for(int i =low; i < high; i++){
                int row = arr[i].rowInd;
                int col = arr[i].colInd;

                //check if the current element is a basin
                if(BasinUtils.isBasin(row,col)){
                    basins.add(new Basin(row, col, arr[i].height));
                }else{
                    basins.add(null);
                }

            }

            return(basins);
        }else {
            FindParallelBasin left = new FindParallelBasin(arr, low, (high+low)/2);
            FindParallelBasin right = new FindParallelBasin(arr, (high+low)/2, high);

            //implement fork join
            left.fork();
            ArrayList<Basin> rightAns = right.compute();
            ArrayList<Basin> leftAns = left.join();

            rightAns.addAll(leftAns);

            return  rightAns;
        }
    }
}
