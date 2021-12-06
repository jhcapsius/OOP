public class Kleidung extends Artikel{
    private String typ, farbe, groesse;
    private final String kleidung = "Kleidung";

    Kleidung(String typ, String farbe, String groesse, int artikelNummer, double nettoPreis){
        super(artikelNummer, (nettoPreis * 1.12));
        this.typ = typ;
        this. farbe = farbe;
        this.groesse = groesse;
    }

    @Override
    public String toString() {
        return this.kleidung + " - " + typ + ", " + farbe + " (" + groesse.toUpperCase() + ") "; 
    }
    
}
