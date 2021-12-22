/**
 * Implements the Transport class according to the specifications
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class Transport {
    private int kosten;
    private String transportName;
   
    Transport(String transportName){
        this.transportName = transportName;
    }

    public int getKosten() {
        return this.kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }

    public void deliver(){
        
    }
}
