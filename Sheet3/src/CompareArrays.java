/**
 * The program checks if two passed arrays are identical. Two arrays are identical if they have the same length and the components match in pairs. 
 * The order of the values does not matter and duplicate values are also allowed. 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class CompareArrays {
    private boolean status = false;
    private int b_length;

    /**
     * 
     * @param a first array
     * @param b second array
     * @return if the arrays are identical, returns true, otherwise returns false 
     */
    public boolean isEqual(int[] a, int[] b){

        //returns false, if the length does not match
        if(a.length != b.length){
            return this.status;
        }else{

            //loops compare the components of the two arrays
            this.b_length = b.length;
            for(int i = 0;  i < a.length; i++){
                for (int k = 0; k < b_length; k++){
             
                    //If the components are the same, the component at k is swapped with the last one in the array b at
                    if(a[i] == b[k]){
                        //Reduces the length of the array b by 1 to lock the last components
                        this.b_length -= 1;
                        b = swap(b, k, b_length);
                        //set k = b_length to end the loop and set status to true
                        k = this.b_length;
                        this.status = true;         
                    }else{
                        this.status = false;
                        //if no identical entry is found in an interval, the loops  terminated
                        if(k == this.b_length-1){
                            i = a.length;
                        }
                    }
                }
            }
        }
        return this.status;
    }

    /**
     * 
     * @param b array whose entries are to be swapped
     * @param k index 1
     * @param length index 2
     * @return An array where the entry at i has been swapped with the entry at length
     */
    private int[] swap(int[] b, int k, int length){
        int buffer = b[length];
        b[length] = b[k];
        b[k] = buffer;
        return b;
    }
}
