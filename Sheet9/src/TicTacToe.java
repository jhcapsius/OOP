/**
 * This class represents an implementation of the game TicTacToe. With the method macheZug the game fields can be occupied. The method zeigeSPielfeld displays the playfield on the terminal and with the reset method you can delete all entries and start the game again.
 */

public class TicTacToe {
    private int[] feld;
    private int turnCounter; 

    TicTacToe(){
        reset();
    }

    
    /**
     * resets the playing field
     */
    public void reset(){
        this.feld = new int[9];
        this.turnCounter = 1;
    }


    /**
     * make a move and sets a sign at the given position
     * @param x column
     * @param y row
     */
    public void macheZug(int x, int y){
        if(this.turnCounter > 9){
            System.out.println("Feld ist voll!");
        }else if((x >= 0 && x <= 2) && (y >= 0 && y <= 2)){
            if(y == 0){
                switch(x){
                    case 0:
                        setSign(0);
                        break;
                    case 1:
                        setSign(1);
                        break;
                    case 2:
                        setSign(2);
                        break;        
                }
            }else if(y == 1){
                switch(x){
                    case 0:
                        setSign(3);
                        break;
                    case 1:
                        setSign(4);
                        break;
                    case 2:
                        setSign(5);
                        break;        
                }
            }else if(y == 2){
                switch(x){
                    case 0:
                        setSign(6);
                        break;
                    case 1:
                        setSign(7);
                        break;
                    case 2:
                        setSign(8);
                        break;        
                }
            }
        }else{
            System.out.println("\nUngültiger Zug\n");
        }
    }

    /**
     * subfunction for macheZug. sets an 1 for an odd number of moves and a 2 for an even number of moves. If a cell is already occupied, an error message is displayed.
     * @param y position in the array
     */
    private void setSign(int y){
        if(this.feld[y] == 0 && this.turnCounter % 2 != 0){
            this.feld[y] = 1;
            this.turnCounter++;
        }else if(this.feld[y] == 0 && this.turnCounter % 2 == 0){
            this.feld[y] = 2;
            this.turnCounter++;
        }else{
            System.out.println("Zelle ist bereits belegt\n");
        }
    }

    /**
     * prints the playing field on the terminal
     */
    public void zeigeSpielfeld(){
        System.out.println("Spielfeld");
        for(int i = 0; i < this.feld.length; i++){
            if( i>= 0 && i <2 || i>= 3 && i<5 || i>=6 && i< 8){
                if(this.feld[i] == 1){
                    System.out.print("X|");
                }else if(this.feld[i] == 2){
                    System.out.print("O|");
                }else{
                    System.out.print(" |");
                }
            }else if(i == 2 || i == 5){
                if(this.feld[i] == 1){
                    System.out.print("X");
                }else if(this.feld[i] == 2){
                    System.out.print("O");
                }else{
                    System.out.print(" ");
                }
                System.out.println("\n-+-+-");
            }else{
                if(this.feld[i] == 1){
                    System.out.print("X");
                }else if(this.feld[i] == 2){
                    System.out.print("O");
                }else{
                    System.out.print(" ");
                }
            }
        }
        System.out.println("\n");
    }

}
