import java.util.HashMap;

public class Zahlenkombinationen {
    private int[][] array, maskHorizontal, maskVertical, maskDiagonal, maskMerge;
    private HashMap<Integer, Integer> uniqueValues;
    private int maxValue, row, column, valueCounter, currentValue;
    
    public void initArray(int hoehe, int breite, int maxValue){
        if(maxValue > 9 || maxValue < 1 ){
            System.out.println("max value invalid");
        }else if(breite <= 0 || hoehe <= 0){
            System.out.println("invalid width or height");
        }else if(breite == hoehe){
            System.out.println("Thats not a rectangle");
        }else{
            this.maxValue = maxValue;
            this.array = new int[hoehe][breite];
            this.maskHorizontal = new int[hoehe][breite];
            this.maskVertical = new int[hoehe][breite];
            this.maskDiagonal = new int[hoehe][breite];
            this.maskMerge = new int[hoehe][breite];
            for(int i = 0; i < this.array.length; i++){
                for(int k = 0; k < this.array[0].length; k++){
                    this.array[i][k] = (int) (Math.random() * this.maxValue + 1);
                }
            }
        }
    }

    public void loeschen(){
        setMaskHorizontal();
        setMaskVertical();
        maskMerge();
        

        
        
    }

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
    private boolean conditionHorizontalFillMask(int i, int k, int currentValue){
        return this.valueCounter > 2 && ((k+1 == this.array[0].length) || (k+1 < this.array[0].length && this.array[i][k+1] != currentValue));
    }

    private void fillMaskHorizontal(int h, int k){
        for(int i = 0; i < this.valueCounter; i++){
            this.maskHorizontal[h][k-i] = this.array[h][k-i];
        }

    }

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

    private boolean conditionVerticalFillMask(int i, int k, int currentValue){
        return this.valueCounter > 2 && ((k+1 == this.array.length) || (k+1 < this.array.length && this.array[k+1][i] != currentValue));
    }

    private void fillMaskVertical(int h, int k){
        for(int i = 0; i < this.valueCounter; i++){
            this.maskVertical[h-i][k] = this.array[h-i][k];
        }

    }

    private void setDiagonalMask(){

    }

    private void setDiagonalTopStartUpperHalf(){
        this.row = 0;
        this.column = 0;

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

            


        }while (true);
    }

    private boolean conditionDiagonalFillMask(int i, int k, int currentvalue){
        return true;
    }


    




    private void maskMerge(){
        for(int i = 0; i < this.maskMerge.length; i++){
            for (int k = 0; k < this.maskMerge[0].length; k++){
                if(this.maskHorizontal[i][k] != 0 || this.maskVertical[i][k] != 0 || this.maskDiagonal[i][k] != 0){
                    this.maskMerge[i][k] = -1;
                }
            }
        }
    }

    private void resetLoop(){
        this.valueCounter = 0;
        this.row = 0;
        this.column = 0;
        
    }

    private void loopLowerHalf(){
        this.valueCounter = 0;
        this.row = 1;
        this.column = 0;
        

    }


    public void printArr(){
        for(int i = 0; i < this.array.length; i++){
            for(int k = 0; k < this.array[0].length; k++){
                if(this.array[i][k] == -1){
                    System.out.print("-" + " ");
                }else{
                    System.out.print(this.array[i][k] + " ");
                }
                
            }
            System.out.println();
        }
        System.out.println();
    }    

    public void printMerge(){
        for(int i = 0; i < this.maskMerge.length; i++){
            for (int k = 0; k < this.maskMerge[0].length; k++){
                if(this.maskMerge[i][k] == 0){
                    System.out.print(" " + this.maskMerge[i][k] + " ");
                }else{
                    System.out.print(this.maskMerge[i][k] + " ");
                }
            }
            System.out.println();
        }
    }

    public void printHorizontal(){
        for(int i = 0; i < this.maskHorizontal.length; i++){
            for (int k = 0; k < this.maskHorizontal[0].length; k++){
                System.out.print(this.maskHorizontal[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printVertical(){
        System.out.println();
        for(int i = 0; i < this.maskVertical.length; i++){
            for (int k = 0; k < this.maskVertical[0].length; k++){
                System.out.print(this.maskVertical[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printDiagonal(){
        System.out.println();
        for(int i = 0; i < this.maskDiagonal.length; i++){
            for (int k = 0; k < this.maskDiagonal[0].length; k++){
                System.out.print(this.maskDiagonal[i][k] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Zahlenkombinationen zahlenkombinationen = new Zahlenkombinationen();
        zahlenkombinationen.initArray(5, 7, 2);
        zahlenkombinationen.printArr();
        zahlenkombinationen.loeschen();
        zahlenkombinationen.printHorizontal();
        zahlenkombinationen.printVertical();
    }

    
    
}
