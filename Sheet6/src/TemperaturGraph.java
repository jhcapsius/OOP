import java.util.Arrays;

public class TemperaturGraph {
    private int elements, year, minTemp, maxTemp;
    private int[] temperature;
    private String[][] plot;

    TemperaturGraph(int year){
        this.year = year;
        this.temperature = new int[12];  
    }

    public void addTemperatur(int monat, int temperatur){
        if(monat < 1 || monat > 12){
            System.out.println("out of bounce");
        }else if(elements >= 12){
            System.out.println("list is full");
        }else{
            this.temperature[monat-1] = temperatur;
            this.elements++;
        }
    }

    public void plotGraph(){
        if(plotAllowed()){
            System.out.println("Year: " + this.year);
            generatePlot();
            for(int i = 0; i < this.plot.length; i++){
                for(int k = 0; k < this.plot[0].length; k++){
                    System.out.print(this.plot[i][k] + " ");
                }
                System.out.println();
            }
        }else{
            System.out.println("Only plots when the list is full");
        }
    }

    private boolean plotAllowed(){
        return this.elements == 12 ? true : false;
    }

    private void generatePlot(){
        setminTemp();
        setmaxTemp();
        setPlot();
    }

    private void setminTemp(){
        this.minTemp = this.temperature[0];
        for(int i = 1; i < this.temperature.length; i++){
            if(this.temperature[i] < this.minTemp){
                this.minTemp = this.temperature[i];
            }
        }
    }

    private void setmaxTemp(){
        this.maxTemp = this.temperature[0];
        for(int i = 1; i < this.temperature.length; i++){
            if(this.temperature[i] > this.maxTemp){
                this.maxTemp = this.temperature[i];
            }
        }
    }

    private void setPlot(){
        int j = 0;
        int l = 0;
        int[] temp = Arrays.copyOf(this.temperature, this.temperature.length);
        Arrays.sort(temp);
        this.plot = new String[this.maxTemp-this.minTemp +1][13];
        for(int i = this.plot.length - 1; i >= 0; i--){
            if(i == this.plot.length - 1){
                this.plot[i][0] = String.valueOf(temp[i]);
            }else{
                int temp2 = Integer.parseInt(this.plot[i+1][0]);
                temp2++;
                this.plot[i][0] = String.valueOf(temp2);
            }
        }
        for(int i = this.plot.length - 1; i >= 0 ; i--){
            for(int k = 1; k < this.plot[0].length; k++){
                if(this.temperature[j] >= this.minTemp + l){
                    this.plot[i][k] = "#";
                }else{
                    this.plot[i][k] = " ";
                }
                j++;
            }
            j = 0;
            l ++;
        }
    }  
}
