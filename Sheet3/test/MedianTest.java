/**
 * Testclass for median
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */


public class MedianTest {
    public static void main(String[] args) {
        int[] test1 = {12, 16 ,2 , 63, 55, 8};
        int[] test2 = {42, 7, 543, 77, 87, 876, 143};
        System.out.print("Array with even number of entries: " + new Median().median(test1) + "\n\n");
        System.out.print("Array with odd number of entries: " + new Median().median(test2));
    }
    
}
