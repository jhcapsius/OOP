/**
 *Implementation of an arraylist like class mylist. Elements can be added and removed from the list dynamically. 
 *You can also remove duplicate entries and display all possible triples of entries that match the given number. 
 *
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

package src;

public class MyList {
    private int[] array;
    private int countDuplicates;

    /**
     * Creates an MyList-object with an empty list
     */
    public MyList(){
        array = new int[0];
    }

    /**
     * calls helper function to add an element
     * @param index position where the item is inserted
     * @param item number to be inserted
     */

    public void addToList(int index, int item){
        this.array = addToListFunction(index, item);
    }

    /**
     * private helperfunction to add an element to the list.
     * @param index position where the item is inserted
     * @param item number to be inserted
     * @return array with a new entry
     */

    private int[] addToListFunction(int index, int item){    
        int[] temp = new int[this.array.length + 1]; 

        //if the index is bigger that arraylength or smaller than 0, it prints an error and return the original array
        if(index > temp.length || index < 0){
            System.out.println("Index out of bounce.\n");
            return this.array;
        
        //attaches new element at the end
        }else if(index == this.array.length){
            for(int i = 0; i < this.array.length; i++){
                temp[i] = this.array[i];
            }
            temp[index] = item;
        }else{

            //inserts a new element at the passed index and the following elements move up one place
            for(int i = 0; i < index; i++){
                temp[i] = this.array[i];
            }
            temp[index] = item;
            for(int i = index+1; i < temp.length; i++){
                temp[i] = this.array[i-1];
            } 
        }
        return temp;
    }

    /**
     * calls helper function to remove an element
     * @param index position of the element to be removed 
     */

    public void removeFromList(int index){
        this.array = removeFromListFunction(index);
    }

    /**
     * private helperfunction to remove an element to the list.
     * @param index position of the element to be removed 
     * @return temp array without the removed element or the class arrray, when the list is empty or index out of bounce
     */

    private int[] removeFromListFunction(int index){
        //indicates that the list is empty and returns the original list
        if(this.array.length == 0){
            System.out.println("List is empty.\n");
            return this.array;
        }
        
        //indicates that the index is too large and returns the original list
        if(index >= this.array.length){
            System.out.println("Index out of bounce.\n");
            return this.array;
        }else{
            //copies the mylist array into the temporary array, but omits the elements to be deleted
            int[] temp = new int[this.array.length - 1];
            for(int i = 0; i < index; i++){
                temp[i] = this.array[i];
            }
            for(int i = index + 1; i < this.array.length; i++ ){
                temp[i-1] = this.array[i];
            }
            return temp;
        }
    }

    /**
     * calls helperfunction to remove duplicates
     * @return amount of removed elements
     */

    public int removeDuplicates(){
        return removeDuplicatesFunction();
    }

    /**
     * private helperfunction to remove duplicates
     * @return amount of removed elements
     */

    private int removeDuplicatesFunction(){

        //if the length is 0 or 1, there are no duplicates
        this.countDuplicates = 0;
        if(this.array.length == 0 || this.array.length == 1){
            return this.countDuplicates;
        }

        //iterates over the array and deletes duplicate entries
        for(int i = 0; i < this.array.length; i++){
            for(int k = i+1; k < this.array.length; k++){
                if(this.array[i] == this.array[k]){
                    removeFromList(k);
                    k--;
                    this.countDuplicates++;
                }
            }
        }
        return this.countDuplicates;
    }

    /**
     * calls helper function to find triples that equal to the given number
     * @param zahl number compared with triples
     */

    public void kombiZahl(int zahl){
        kombiZahlFunction(zahl);
    }

     /**
     * helper function to find triples that equal to the given number
     * @param zahl number compared with triples
     */

    private void kombiZahlFunction(int zahl){
        int[] temp = this.array;
        int k, j;
        temp = sort(temp);
        for (int i = 0; i < temp.length - 2; i++) {
            k = i + 1;
            j = temp.length - 1; 
            while (k < j) {
                if (temp[i] + temp[k] + temp[j] == zahl) {
                    System.out.print("Triplets equal " + zahl + ": [" + temp[i] + ", " + temp[k] + ", " + temp[j] + "]\n");
                    k++;
                    j--;
                }
                else if (temp[i] + temp[k] + temp[j] < zahl){
                    k++;
                }
                    
 
                else{
                    j--;
                }        
            }
        }
    }

    /**
     * algorithm to sort a given array
     * @param arr unsorted array
     * @return sorted array
     */

    private int[] sort(int[] arr){
        int buffer;

        //iterates over the array, swapping the entries until the smallest is first and the largest is last
        for(int i = 0; i < arr.length; i++){
            for(int k = i+1; k < arr.length; k++){
                if(arr[i] > arr[k]){
                    buffer = arr[i];
                    arr[i] = arr[k];
                    arr[k] = buffer;
                }
            }
        }
        return arr;
    }

    /**
     * prints the mylist array
     */
    public void printArray(){
        if(this.array.length == 0){
            System.out.println("Array ist leer\n");
        }else{
            System.out.println("Array:");
            for(int i = 0; i < this.array.length; i++){
                System.out.print(this.array[i] + " " );
            }
            System.out.print("\n\n");
        }
    }   
    
    public int getArrayLength(){
        return this.array.length;
    }

    public void setArray(int[] array){
        this.array = array;
    }
}
