/**
 * The Clothing class inherits from the article class and additionally has the class attributes typ, colour, size and the constant clothes. The attributes can be set via the constructor and returned as a string with the toString method.
 */

public class Kleidung extends Artikel{
    private String typ, farbe, groesse;
    private static final String kleidung = "Kleidung";


    /**
     * sets the attributs via constructor
     * @param typ type of clothing
     * @param farbe type of colour
     * @param groesse size of the clothing
     * @param artikelNummer article number
     * @param nettoPreis net price
     */
    Kleidung(String typ, String farbe, String groesse, int artikelNummer, double nettoPreis){
        super(artikelNummer, (nettoPreis * 1.12));
        this.typ = typ;
        this. farbe = farbe;
        this.groesse = groesse;
    }

    /**
     * returns the attributes as string
     */
    @Override
    public String toString() {
        return kleidung + " - " + typ + ", " + farbe + " (" + groesse.toUpperCase() + ") "; 
    }
    
}
