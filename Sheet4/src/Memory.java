/**
 * With this class a memory game field can be realized as nxn matrix. Only even numbers for n are allowed.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class Memory {
    private int[][] field;
    private int positionX, positionY, cardCounter;


    /**
     * creates an playing field nxn matrix
     * @param n number of rows and columns
     * @return playing field with number pairs between 1 and n/2, otherwise returns null
     */
    public int[][] generateField(int n){
        //only allows even numbers
        if(n % 2 != 0){
            System.out.println("Only even numbers are allowed.");
            return null;
        }else{
            this.field = new int[n][n];
            this.field = fillFieldWithZeros(this.field);
            this.field = fillFieldWithPairs(this.field);
            return this.field;
        }
    }

    /**
     * helper-function, that fills the given nxn with zeros 
     * @param field empty playing field
     * @return playing field with zeros
     */
    private int[][] fillFieldWithZeros(int[][] field){
        for(int i = 0; i < this.field.length; i++){
            for(int k = 0; k < this.field.length; k++){
                field[i][k] = 0;
            }
        }
        return field;
    }

    /**
     * helper-function that replaces the zeros in the playfield with pairs of numbers
     * @param field playing field with zeros
     * @return playing field with pairs of numbers 
     */
    private int[][] fillFieldWithPairs(int[][] field){
        for(int i = 1; i <= (field.length*field.length) / 2; i++){
            this.cardCounter = 0;
            //replaces the entry with i at [x][y] in the matrix, if the entry equals zero. Otherwise it will creates a new card position.
            do{
                this.positionX = (int) (Math.random()*field.length);
                this.positionY = (int) (Math.random()*field.length);
                if(field[this.positionX][this.positionY] == 0){
                    field[this.positionX][this.positionY] = i;
                    this.cardCounter +=1;
                }
            }while(cardCounter < 2);
        }
        return field;
    }

    /**
     * helperfunction, that prints the playingfield
     * @param field playing field
     */
    public void printField(int[][] field){
        if(field == null){
            
        }else{
            System.out.println("Memory Field:");
            for (int i = 0; i < field.length; i++){
                for(int k = 0; k < field[0].length; k++){
                    System.out.print(field[i][k] + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
