/**
 * Class that implements a temperaturegraph. You can enter a year, add the average temperature of each month and plot these information as graph
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0.
 */


import java.util.Arrays;

public class TemperaturGraph {
    private int elements, year, minTemp, maxTemp;
    private int[] temperature;
    private String[][] plot;

    /**
     * Constructor that allows you to enter a year when u create a TemperaturGraph-object
     * @param year year of the data
     */

    TemperaturGraph(int year){
        this.year = year;
        this.temperature = new int[12];  
    }

    /**
     * let you add temperatures
     * @param monat which month
     * @param temperatur average temperature of the month
     */

    public void addTemperatur(int monat, int temperatur){
        // no adds when the index is out of bounce
        if(monat < 1 || monat > 12){
            System.out.println("out of bounce");

        //no adds when the list is full    
        }else if(elements >= 12){
            System.out.println("list is full");

        }else{
            this.temperature[monat-1] = temperatur;
            this.elements++;
        }
    }

    /**
     * Plots the temperature graph
     */
    public void plotGraph(){

        //checks if the graph is valid
        if(plotAllowed()){
            System.out.println("Year: " + this.year);

            //generates the plot
            generatePlot();

            //prints the plot
            for(int i = 0; i < this.plot.length; i++){
                for(int k = 0; k < this.plot[0].length; k++){
                    System.out.print(this.plot[i][k] + " ");
                }
                System.out.println();
            }

        //error message when the graph isnt valid    
        }else{
            System.out.println("Only plots when the list is full");
        }
    }

    /**
     * checks if all elements are set 
     * @return true if set, false if not set 
     */

    private boolean plotAllowed(){
        return this.elements == 12 ? true : false;
    }

    /**
     * Starts the generatePlot process
     */

    private void generatePlot(){
        setminTemp();
        setmaxTemp();
        setPlot();
    }

    /**
     * Sets the min temperature of the graph
     */
    private void setminTemp(){
        this.minTemp = this.temperature[0];
        for(int i = 1; i < this.temperature.length; i++){
            if(this.temperature[i] < this.minTemp){
                this.minTemp = this.temperature[i];
            }
        }
    }

    /**
     * Sets the max temperature of the graph
     */
    private void setmaxTemp(){
        this.maxTemp = this.temperature[0];
        for(int i = 1; i < this.temperature.length; i++){
            if(this.temperature[i] > this.maxTemp){
                this.maxTemp = this.temperature[i];
            }
        }
    }

    /**
     * 
     * Sets the array to plot
     */
    private void setPlot(){
        int j = 0;
        int l = 0;
        int[] temp = Arrays.copyOf(this.temperature, this.temperature.length);
        Arrays.sort(temp);
        this.plot = new String[this.maxTemp-this.minTemp +1][13];

        //sets the temperature to the first column of the 2d array
        for(int i = this.plot.length - 1; i >= 0; i--){
            if(i == this.plot.length - 1){
                this.plot[i][0] = String.valueOf(temp[i]);
            }else{
                int temp2 = Integer.parseInt(this.plot[i+1][0]);
                temp2++;
                this.plot[i][0] = String.valueOf(temp2);
            }
        }

        //fills the remaining rows and columns 
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
