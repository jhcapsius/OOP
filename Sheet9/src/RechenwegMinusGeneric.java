/**
 * Implements generic subtraction for the rechnung attribute in Arithmetik2 class
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class RechenwegMinusGeneric<T> implements Rechenweg2<T> {

    @Override
    public T berechneErgebnis(T a, T b) {
        if(a instanceof Integer){
            return (T) ((Integer) ((Integer) a - (Integer) b));
        }else if(a instanceof Double){
            return (T) ((Double) ((Double) a - (Double) b));
        }else if(a instanceof Integer){
            return (T) ((Float) ((Float) a - (Float) b));
        }else if(a instanceof Long){
            return (T) ((Long) ((Long) a - (Long) b));
        }else{
            throw new IllegalArgumentException();
        }    
    }

    

    
    
}
