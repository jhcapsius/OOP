/**
 *The Zahlenkombinationen contains a private 2-D integer array that can be initialized using the initArray method and passing the height, width, and a maximum value between 0 and 10. With the loeschen method any chain of three or more horizontally, vertically or diagonally equal values can be deleted. The auffuellen method can be used to fill empty spaces in the array. The anzeigen methode can be used to display the array.
 *
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

public class Zahlenkombinationen {
    private int[][] array, maskHorizontal, maskVertical, maskDiagonal;
    private int row, column, valueCounter, currentValue, counterRow, counterColumn;
    
    /**
     * Checks if the passed maximum value, height and width is valid. If they are not valid, an error message is displayed. Afterwards the arrays are initialized and the array is filled with randomly generated numbers between 1 and the max value
     * @param hoehe number of rows of the array
     * @param breite number of columns of the array
     * @param maxValue biggest value in the array
     */
    public void initArray(int breite, int hoehe, int maxValue){
        if(maxValue > 9 || maxValue < 1 ){
            System.out.println("max value invalid");
        }else if(breite <= 0 || hoehe <= 0){
            System.out.println("invalid width or height");
        }else if(breite == hoehe){
            System.out.println("Thats not a rectangle");
        }else{
            this.array = new int[hoehe][breite];
            this.maskHorizontal = new int[hoehe][breite];
            this.maskVertical = new int[hoehe][breite];
            this.maskDiagonal = new int[hoehe][breite];
            this.maskHorizontal = fillMasksWithMinus1(this.maskHorizontal);
            this.maskVertical = fillMasksWithMinus1(this.maskVertical);
            this.maskDiagonal = fillMasksWithMinus1(this.maskDiagonal);
            Random rand = new Random();
            for(int i = 0; i < this.array.length; i++){
                for(int k = 0; k < this.array[0].length; k++){
                    this.array[i][k] = rand.nextInt(maxValue+1);
                }
            }
        }
    }

    /**
     * fills the given array with -1
     * @param arr array with zeros
     * @return array with -1
     */
    private int[][] fillMasksWithMinus1(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int k = 0; k < arr[0].length; k++){
                arr[i][k] = -1;
            }
        }
        return arr;
    }    



    /**
     * Searches the rows, columns and diagonals for chains of 3 or more equal values and stores the position in the corresponding array. At the end the masks are merged with the original array and only single values or pairs remain. Catches a nullpointer exception when the arrays are not initalized.
     */
    public void loeschen(){
        try{
            setMaskHorizontal();
            setMaskVertical();
            setDiagonalMask();
            maskMerge(); 
        }catch(NullPointerException e){
            System.out.println("The array must be initialized first");
        }
        
    }

    /**
     * Subfunction of loeschen. Searches for chains of 3 or more of the same values in the rows of the 2D array and stores them.
     */
    private void setMaskHorizontal(){
        for(int i = 0; i < this.array.length; i++){
            for(int k = 0; k < this.array[0].length; k++){
                if(k == 0){
                    this.currentValue = this.array[i][k];
                    this.valueCounter = 1;
                }else if(this.array[i][k] == currentValue){
                    this.valueCounter++;
                }else{
                    this.valueCounter = 1;
                    this.currentValue = this.array[i][k];
                }
                
                if(conditionHorizontalFillMask(i, k, this.currentValue)){
                    fillMaskHorizontal(i, k);
                }
            }
            this.valueCounter = 0;
        }
    }

    /**
     * Checks if there is a number chain that should be saved
     * @param i row index of the last element in the chain
     * @param k column index of the last element in the chain
     * @param currentValue value of the chain
     * @return Returns true if there are 3 or more equal values in a row and it is the end of the row or the following value is different. 
     */

    private boolean conditionHorizontalFillMask(int i, int k, int currentValue){
        return this.valueCounter > 2 && ((k+1 == this.array[0].length) || (k+1 < this.array[0].length && this.array[i][k+1] != currentValue));
    }


    /**
     * Subfunction of setMaskHorizontal. Stores the number chain  in the masking array of the rows.
     * @param h row index of the last element in the chain
     * @param k column index of the last element in the chain
     */

    private void fillMaskHorizontal(int h, int k){
        for(int i = 0; i < this.valueCounter; i++){
            this.maskHorizontal[h][k-i] = this.currentValue;
        }

    }

     /**
     * Subfunction of loeschen. Searches for chains of 3 or more of the same values in the columns of the 2D array and stores them.
     */
    private void setMaskVertical(){
        for(int i = 0; i < this.array[0].length; i++){
            for(int k = 0; k < this.array.length; k++){
                if(k == 0){
                    this.currentValue = this.array[k][i];
                    this.valueCounter = 1;
                }else if(this.array[k][i] == currentValue){
                    this.valueCounter++;
                }else{
                    this.valueCounter = 1;
                    this.currentValue = this.array[k][i];
                }

                if(conditionVerticalFillMask(i, k, this.currentValue)){
                    fillMaskVertical(k, i);
                }
            }
            this.valueCounter = 0;
        }
        
    }

     /**
     * Checks if there is a number chain that should be saved
     * @param i row index of the last element in the chain
     * @param k column index of the last element in the chain
     * @param currentValue value of the chain
     * @return Returns true if there are 3 or more equal values in a column and it is the end of the column or the following value is different. 
     */

    private boolean conditionVerticalFillMask(int i, int k, int currentValue){
        return this.valueCounter > 2 && ((k+1 == this.array.length) || (k+1 < this.array.length && this.array[k+1][i] != currentValue));
    }

    /**
     * Subfunction of setMaskVertical. Stores the number chains in the masking array for the columns.
     * @param h row index of the last element in the chain
     * @param k column index of the last element in the chain
     */
    
    private void fillMaskVertical(int h, int k){
        for(int i = 0; i < this.valueCounter; i++){
            this.maskVertical[h-i][k] = this.currentValue;
        }

    }

    /**
     * Subfunction of loeschen. Searches for chains of 3 or more of the same values in the diagonals of the 2D array and stores them.
     */
    private void setDiagonalMask(){
        setDiagonalTopToBottom();
        setDiagonalBottomToTop();

    }

    /**
     * Subfunction of setDiagonalMask. Searches for chains of 3 or more of the same values in the diagonals of the 2D array and stores them. The start point is i = 0 and k = 0
     */
    private void setDiagonalTopToBottom(){
        this.row = 0;
        this.column = 0;
        this.counterColumn = 0;
        do{
            do{
                if(this.row == 0){
                    currentValue = this.array[this.row][this.column];
                    this.valueCounter = 1;
                }else if(this.array[this.row][this.column] == this.currentValue){
                    this.valueCounter++;
                }else{
                    this.valueCounter = 1;
                    this.currentValue = this.array[this.row][this.column];
                }
    
                if(conditionDiagonalFillMaskTopToBottom()){
                    fillMaskDiagonalFromTopToBottom();
                }
                this.row++;
                this.column++;
            }while (this.row < this.array.length && this.column < this.array[0].length);
            this.row = 0;
            this.counterColumn++;
            this.column = this.counterColumn;
        }while(this.column < this.array[0].length);

        this.row = 1;
        this.column = 0;
        this.counterRow = 1;
        do{
            do{
                if(this.column == 0){
                    currentValue = this.array[this.row][this.column];
                    this.valueCounter = 1;
                }else if(this.array[this.row][this.column] == this.currentValue){
                    this.valueCounter++;
                }else{
                    this.valueCounter = 1;
                    this.currentValue = this.array[this.row][this.column];
                }

                if(conditionDiagonalFillMaskTopToBottom()){
                    fillMaskDiagonalFromTopToBottom();
                }
                this.row++;
                this.column++;
            }while(this.row < this.array.length);
            this.column = 0;
            this.counterRow++;
            this.row = this.counterRow;
        }while(this.row < this.array.length);
        
    }

    /**
     * Checks if there is a number chain that should be saved
     * @param this.row row index of the last element in the chain
     * @param this.collumn column index of the last element in the chain
     * @param currentValue value of the chain
     * @return Returns true if there are 3 or more equal values in a diagonal and it is the end of the diagonal or the following value is different. 
     */

    private boolean conditionDiagonalFillMaskTopToBottom(){
        return this.valueCounter > 2 && (this.row+1 == this.array.length || this.column+1 == this.array[0].length || (this.row+1 < this.array.length && this.column+1 < this.array[0].length && this.array[this.row+1][this.column+1] != this.currentValue));
    }

     /**
     * Subfunction of setMaskDiagonal. Stores the number chains in the masking array for the doiagonals.
     * @param this.row row index of the last element in the chain
     * @param this.column column index of the last element in the chain
     */

    private void fillMaskDiagonalFromTopToBottom(){
        for(int i = 0; i < this.valueCounter; i++){
            this.maskDiagonal[this.row-i][this.column-i] = this.currentValue;
        }

    }

    /**
     * Subfunction of setDiagonalMask. Searches for chains of 3 or more of the same values in the diagonals of the 2D array and stores them. The start point is i = array.length-1 and k = 0
     */
    private void setDiagonalBottomToTop(){
        this.row = this.array.length - 1;
        this.column = 0;
        this.counterColumn = 0;
        do{
            do{
                if(this.row == this.array.length -1){
                    this.currentValue = this.array[this.row][this.column];
                    this.valueCounter = 1;
                }else if(this.array[this.row][this.column] == this.currentValue){
                    this.valueCounter++;
                }else{
                    this.valueCounter = 1;
                    this.currentValue = this.array[this.row][this.column];
                }

                if(conditionDiagonalFillMaskBottomToTop()){
                  fillMaskDiagonalBottomToTop();
                }

                this.row--;
                this.column++;
            }while(this.row >= 0 && this.column < this.array[0].length);
            this.row = this.array.length - 1;
            this.counterColumn++;
            this.column = this.counterColumn;
        }while(this.column < this.array[0].length);

        this.row = this.array.length -2;
        this.column = 0;
        this.counterRow = 0;
        do{
            do{
                if(this.column == 0){
                    this.currentValue = this.array[this.row][this.column];
                    this.valueCounter = 1;
                }else if(this.array[this.row][this.column] == this.currentValue){
                    this.valueCounter++;
                }else{
                    this.valueCounter = 1;
                    this.currentValue = this.array[this.row][this.column];
                }

                if(conditionDiagonalFillMaskBottomToTop()){
                    fillMaskDiagonalBottomToTop();
                }
                this.row--;
                this.column++;
            }while(this.row >= 0 && this.column < this.array[0].length);
            this.column = 0;
            this.counterRow--;
            this.row = (this.array.length - 2) + this.counterRow;
        }while(this.row >= 0);


    }

    /**
     * Checks if there is a number chain that should be saved
     * @param this.row row index of the last element in the chain
     * @param this.collumn column index of the last element in the chain
     * @param currentValue value of the chain
     * @return Returns true if there are 3 or more equal values in a diagonal and it is the end of the diagonal or the following value is different. 
     */
    private boolean conditionDiagonalFillMaskBottomToTop(){
        return this.valueCounter > 2 && (this.row-1 == -1 || this.column+1 == this.array[0].length || (this.row-1 < this.array.length && this.column+1 < this.array[0].length && this.array[this.row-1][this.column+1] != this.currentValue));
    }

     /**
     * Subfunction of setMaskDiagonal. Stores the number chains in the masking array for the doiagonals.
     * @param this.row row index of the last element in the chain
     * @param this.column column index of the last element in the chain
     */
    private void fillMaskDiagonalBottomToTop(){
        for(int i = 0; i < this.valueCounter; i++){
            this.maskDiagonal[this.row+i][this.column-i] = this.currentValue;
        }
    }

    /**
     * Subfunction of loeschen. Merges the main array with the masks.
     */
    private void maskMerge(){
        for(int i = 0; i < this.array.length; i++){
            for (int k = 0; k < this.array[0].length; k++){
                if(this.maskHorizontal[i][k] != -1 || this.maskVertical[i][k] != -1 || this.maskDiagonal[i][k] != -1){
                    this.array[i][k] = -1;
                }
            }
        }
    }

    /**
     * fills the empty spaces in the array if values exist in the column
     */
    public void auffuellen(){
        try{
            ArrayList<Point> elements = new ArrayList<>();
            for(int i = 0; i < this.array[0].length; i++){
                for(int k = 0; k < this.array.length; k++){
                    if(this.array[k][i] != -1){
                        elements.add(new Point(k,i));
                    }
                }
                int counter = elements.size()-1;
                for(int k = this.array.length - 1; k >= 0; k-- ){
                    if(counter > -1){
                        this.array[k][i] = this.array[elements.get(counter).x][elements.get(counter).y];
                    }else{
                        this.array[k][i] = -1;
                    }
                    counter--;
                }
                elements.clear();
            }
        }catch(NullPointerException e){
            System.out.println("The array must be initialized first");
        }
        
    }
    
    /**
     * Prints the array
     */
    public void anzeigen(){
        try{
            for(int i = 0; i < this.array.length; i++){
                for(int k = 0; k < this.array[0].length; k++){
                    if(this.array[i][k] == -1){
                        System.out.print("- " );
                    }else{
                        System.out.print(this.array[i][k] + " ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }catch(NullPointerException e){
            System.out.println("The array must be initialized first");
        }   
    }   
}
