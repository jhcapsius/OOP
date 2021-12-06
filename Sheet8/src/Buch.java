public class Buch extends Artikel{
    private int erscheinungsjahr;
    private String autorName, buchtitel;
    private final String buch = "Buch";

    Buch(String autorName, String buchtitel, int erscheinungsjahr, int artikelNummer, double nettoPreis){
        super(artikelNummer, (nettoPreis * 1.07));
        this.autorName = autorName;
        this.buchtitel = buchtitel;
        this.erscheinungsjahr = erscheinungsjahr;
    }

    @Override
    public String toString() {
        return this.buch + " - " + this.autorName + ", " + this.buchtitel + " (" + this.erscheinungsjahr + ") ";
    }
}
