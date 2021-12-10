import java.util.HashMap;

public class Konfiguration {
    private HashMap<String, String> keyValuePaare;

    public Konfiguration(){
        this.keyValuePaare = new HashMap<>();
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
