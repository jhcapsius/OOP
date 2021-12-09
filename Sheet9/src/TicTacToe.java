

public class TicTacToe {
    private int[] feld = new int[9];
    private int turnCounter; 

    TicTacToe(){
        reset();
    }

    

    private void reset(){
        for(int i = 0; i < this.feld.length; i++){
            this.feld[i] = 0;
        }
        this.turnCounter = 1;
    }

    public void macheZug(int x, int y){
        if(this.turnCounter <= 9){
            if((x >= 0 || x <= 2) && (y >= 0 || y <= 2)){
                if(x == 0){
                    switch(y){
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
                }else if(x == 1){
                    switch(y){
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
                }else if(x == 2){
                    switch(y){
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
                System.out.println("\n\nUngültiger Zug");
            }
        }else{
            System.out.println("\n\nFeld ist voll, bitte einen Reset vornehmen");
        }
    }

    private void setSign(int y){
        if(this.feld[y] == 0 && this.turnCounter % 2 != 0){
            this.feld[y] = 1;
            this.turnCounter++;
        }else if(this.feld[y] == 0 && this.turnCounter % 2 == 0){
            this.feld[y] = 2;
            this.turnCounter++;
        }else{
            System.out.println("Zelle ist bereits belegt");
        }
    }

    public void zeigeSpielfeld(){
        for(int i = 0; i < this.feld.length; i++){
            if(this.feld[i] == 1){
                System.out.print("X");
            }else if(this.feld[i] == 2){
                System.out.print("0");
            }else{
                System.out.print(" ");
            }
            if(i + 1 != this.feld.length){
                System.out.print(" | ");
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.macheZug(0, 0);
        ticTacToe.macheZug(0, 1);
        ticTacToe.macheZug(0, 2);
        ticTacToe.macheZug(1, 0);
        ticTacToe.macheZug(1, 1);
        ticTacToe.macheZug(1, 2);
        ticTacToe.macheZug(2, 0);
        ticTacToe.macheZug(2, 1);
        ticTacToe.macheZug(2, 2);
        ticTacToe.zeigeSpielfeld();
        ticTacToe.macheZug(0,0);
        ticTacToe.reset();
        ticTacToe.zeigeSpielfeld();
    }
}
