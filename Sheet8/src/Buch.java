/**
 * The book class inherits from the article class and additionally has the class attributes publication year, author name book title and the constate book. The attributes can be set via the constructor and returned as a string with the toString method.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */


public class Buch extends Artikel{
    private int erscheinungsjahr;
    private String autorName, buchtitel;
    private static final String buch = "Buch";

    /**
     * sets the attributs via constructor
     * @param autorName name of the author
     * @param buchtitel title of the book
     * @param erscheinungsjahr year of publication
     * @param artikelNummer article number
     * @param nettoPreis net price
     */
    Buch(String autorName, String buchtitel, int erscheinungsjahr, int artikelNummer, double nettoPreis){
        super(artikelNummer, (nettoPreis * 1.07));
        this.autorName = autorName;
        this.buchtitel = buchtitel;
        this.erscheinungsjahr = erscheinungsjahr;
    }


    //returns the attributes as string
    @Override
    public String toString() {
        return buch + " - " + this.autorName + ", " + this.buchtitel + " (" + this.erscheinungsjahr + ") ";
    }
}
