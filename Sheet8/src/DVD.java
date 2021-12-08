/**
 * The DVD class inherits from the article class and additionally has the class attributes hours, minutes, movie title and the constant dvd. The attributes can be set via the constructor and returned as a string with the toString method.
 */

public class DVD extends Artikel{
    private int minuten, stunden;
    private String filmTitel;
    private static final String dvd = "DVD";

    
    /**
     * sets the attributs via constructor
     * @param filmTitel movietitle
     * @param dauer duration of the movie
     * @param artikelNummer article number
     * @param nettoPreis net price
     */
    DVD(String filmTitel, int dauer, int artikelNummer, double nettoPreis){
        super(artikelNummer, (nettoPreis * 1.19));
        this.filmTitel = filmTitel;
        this.stunden = dauer / 60;
        this.minuten = dauer % 60;
    }
    /**
     * //returns the attributes as string
     */
    @Override
    public String toString() {
        return  this.minuten >= 10 ? dvd + " - " + this.filmTitel + " (" + this.stunden + ":" + this.minuten + ") " : dvd + " - " + this.filmTitel + " (" + this.stunden + ":" + "0" + this.minuten + ") ";
    }
    
}
