import java.util.HashMap;

public class Konfiguration {
    private static final Konfiguration singletonKonfiguation = new Konfiguration();

    private HashMap<String, String> keyValuePaare;

    private Konfiguration(){
        System.out.println("Konfiguration wird erstellt.");
        this.keyValuePaare = new HashMap<>();
    }

    public static Konfiguration getKonfiguration(){
        return singletonKonfiguation;
    }

    public HashMap<String, String> getWerte(){
        return this.keyValuePaare;
    }

    public void schreibeKonfiguartion(){

    }

    public void setWert(String key, String wert){
        this.keyValuePaare.put(key, wert);
    }
}
