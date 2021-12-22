/**
 * Implements the Ship class according to the specifications
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class Schiff extends Transport{
    private int kosten;
    private String name;

    Schiff(String transportName) {
        super(transportName);
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }

    public void deliver() {
        
    }
}
