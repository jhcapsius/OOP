/**
 *This function determines the median of a passed array. A distinction is made between arrays with an even and odd number of elements.
 *
 *@author Jan-Henrik Capsius
 *@version 1.0 
 */


import java.util.Arrays;

public class Median{
    private int median;

    /**
     * Finds the median of a given array
     * 
     * @param array passed array
     * @return median
     */
    
    public int median(int[] array){
        System.out.println("Unsorted Array");
        printMyArray(array);

        Arrays.sort(array);
        System.out.println("Sorted Array");
        printMyArray(array);

        if(array.length % 2 != 0){
            this.median = array[( int )((array.length + 1) / 2.0 )];
        }else{
            this.median = array[( int )(1.0 / 2.0 * ( array.length / 2.0 + (array.length / 2.0 + 1)))];
        }

        return this.median;
    }

    /**
     * prints the given array
     * @param array passed array
     */

    private void printMyArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}