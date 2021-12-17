public class Truck extends Transport {
    private int kosten;
    private String name;

    Truck(String transportName) {
        super(transportName);
        this.name = transportName;
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
