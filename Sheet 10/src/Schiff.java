public class Schiff extends Transport{
    private int kosten;
    private String name;

    Schiff(String transportName) {
        super(transportName);
        this.name = transportName;
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
