/**
 * Testclass for the Konfiguration class.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class KonfigurationTest {
    public static void main(String[] args) {
        //Calls the private Konfiguration instance of the Konfiguration class
        Konfiguration konfiguration = Konfiguration.getKonfiguration();
        
        //Test adds two key value pairs to the hashmap
        konfiguration.setWert("key", "wert");
        konfiguration.setWert("wert", "key");
        System.out.println(konfiguration.getWerte());

        //Test overwrites the value, because the key is already existing
        konfiguration.setWert("key", "anderer wert");
        System.out.println(konfiguration.getWerte());
        
    }
}
