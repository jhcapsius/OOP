/**
 * Example class how to implement the Singleton-Pattern
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */


import java.util.HashMap;

public class Konfiguration {

    //private static final attrinute that contains the only instance of Konfiguration
    private static final Konfiguration singletonKonfiguation = new Konfiguration();

    private HashMap<String, String> keyValuePaare;

    //Private constructor to make sure, that no objects can be created.
    private Konfiguration(){
        System.out.println("Konfiguration wird erstellt.");
        this.keyValuePaare = new HashMap<>();
    }

    /**
     * static factory method for obtaining the instance
     * @return instance of Konfiguration
     */
    public static Konfiguration getKonfiguration(){
        return singletonKonfiguation;
    }

    /**
     * geter for the hashmap
     * @return hashmap
     */
    public HashMap<String, String> getWerte(){
        return this.keyValuePaare;
    }

    public void schreibeKonfiguartion(){

    }

    /**
     * setter for the hashmap
     * @param key key of the hashmap entry 
     * @param wert value of the hasmap entry
     */
    public void setWert(String key, String wert){
        this.keyValuePaare.put(key, wert);
    }
}
