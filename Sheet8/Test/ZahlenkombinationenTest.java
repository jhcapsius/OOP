/**
 *Testclass for Zahlenkombinationen.java
 *
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class ZahlenkombinationenTest {
    public static void main(String[] args) {
        Zahlenkombinationen zahlenkombinationen = new Zahlenkombinationen();
        
        //test when array is not initialized
        zahlenkombinationen.loeschen();
        zahlenkombinationen.anzeigen();
        zahlenkombinationen.auffuellen();
        System.out.println();

        //test fill array with random numbers between 1 and 4 and delete number chains of three or more.
        zahlenkombinationen.initArray(7, 5, 3);
        zahlenkombinationen.anzeigen();
        zahlenkombinationen.loeschen();
        zahlenkombinationen.anzeigen();

        //test fill the empty spaces when there are remaining values
        zahlenkombinationen.auffuellen();
        zahlenkombinationen.anzeigen();
    }
}
