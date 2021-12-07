/**
 * This class creates a frame of stars around the given text
 */

public class Frame {
    private int longestEntry, counter = 2;
    private char[] temp;
    
    /**
     * starts the printing process
     * @param arr array that we want to print
     */
    public void printFrame(String[] arr){
        setLongestEntry(arr);
        printTopBot();
        printSides(arr);
        printTopBot();
    }

    /**
     * setter for longest entry
     * @param arr arary that we want to print
     */
    private void setLongestEntry(String[] arr){
        this.longestEntry = arr[0].length();
        for(int i = 1; i < arr.length; i++){
            if(this.longestEntry < arr[i].length()){
                this.longestEntry = arr[i].length();
            }
        }
    }

    /**
     * prints the top and bottom line of stars
     */
    private void printTopBot(){
        for(int i = 0; i < this.longestEntry + 4; i++){
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * prints the stars on the side and the text
     * @param arr array that we want to print
     */

    private void printSides(String[] arr){
        this.temp = new char[this.longestEntry+4];
        this.temp[0] = '*';
        this.temp[1] = ' ';
        this.temp[temp.length-1] = '*';
        this.temp[temp.length-2] = ' ';
        for(int i = 0; i < arr.length; i++){
            for(int k = 0; k < this.longestEntry; k++){
                if(this.counter < arr[i].length()+2){
                    this.temp[counter] = arr[i].charAt(k);
                    this.counter++;
                }else{
                    this.temp[counter] = ' ';
                    this.counter++;
                }
            }
            for(int k = 0; k < this.temp.length; k++){
                System.out.print(this.temp[k]);
            }
            this.counter = 2;
            System.out.println();
        }
    }
}
