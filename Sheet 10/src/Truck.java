/**
 * Implements the Truck class according to the specifications
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class Truck extends Transport {
    private int kosten;
    private String name;

    Truck(String transportName) {
        super(transportName);
    }

    public int getKosten() {
        return this.kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }

    
    public void deliver() {
    
    }
    
}
