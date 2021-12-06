public class DVD extends Artikel{
    private int minuten, stunden;
    private String filmTitel;
    private final String dvd = "DVD";

    

    DVD(String filmTitel, int dauer, int artikelNummer, double nettoPreis){
        super(artikelNummer, (nettoPreis * 1.19));
        this.filmTitel = filmTitel;
        this.stunden = dauer / 60;
        this.minuten = dauer % 60;
    }

    @Override
    public String toString() {
        return  this.minuten >= 10 ? this.dvd + " - " + this.filmTitel + " (" + this.stunden + ":" + this.minuten + ") " : this.dvd + " - " + this.filmTitel + " (" + this.stunden + ":" + "0" + this.minuten + ") ";
    }
    
}
