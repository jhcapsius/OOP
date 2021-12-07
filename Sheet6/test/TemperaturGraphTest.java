/**
 * Testclass for the TemperaturGraph class
 * 
 * @author Jan-Herik Capsius
 * @version 1.0
 */

public class TemperaturGraphTest {
    public static void main(String[] args) {
        TemperaturGraph temperaturGraph = new TemperaturGraph(2004);
        
        //out of bounce test
        temperaturGraph.addTemperatur(0, -300);
        temperaturGraph.addTemperatur(30, 3000);
        
        //try to start plotting with less than 12 elements
        temperaturGraph.addTemperatur(1, 15);
        temperaturGraph.addTemperatur(2, 14);
        temperaturGraph.addTemperatur(3, 13);
        temperaturGraph.addTemperatur(4, 15);
        temperaturGraph.addTemperatur(5, 11);
        temperaturGraph.plotGraph();

        //try to add more than 12 elements
        temperaturGraph.addTemperatur(6, 11);
        temperaturGraph.addTemperatur(7, 12);
        temperaturGraph.addTemperatur(8, 13);
        temperaturGraph.addTemperatur(9, 11);
        temperaturGraph.addTemperatur(10, 12);
        temperaturGraph.addTemperatur(11, 11);
        temperaturGraph.addTemperatur(12, 11);
        temperaturGraph.addTemperatur(8, 21);

        //plot graph
        temperaturGraph.plotGraph();
    }
    
}
