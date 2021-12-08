/**
 * The Item class is the main class from which the Book, DVD and Clothing classes inherit. In addition, the class contains the attributes item number and net price. With the method getPrice the price can be returned and with the method getInfo the article number and the net price as two-digit decimal number. 
 * 
 *@author Jan-Henrik Capsius
 *@version 1.0
 */

public class Artikel {
    private int artikelNummer;
    private double nettoPreis;
    
    /**
     * sets the attributs via constructor
     * @param artikelNummer article number of the article
     * @param nettoPreis net price
     */
    Artikel(int artikelNummer, double nettoPreis){
        this.artikelNummer = artikelNummer;
        this.nettoPreis = nettoPreis;
    }

    /**
     * getter fpr the net price
     * @return net price
     */
    public double getPreis(){
        return this.nettoPreis;
    }

    /**
     * toString-like method to output the attributes of the class as a string.
     * @return article number and net price as a string
     */
    public String getInfo(){
        return this.artikelNummer + " : " + String.format("%.2f", this.nettoPreis) + " Euro";
    }
    
}
