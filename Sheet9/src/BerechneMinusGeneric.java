public class BerechneMinusGeneric<T> implements Rechenweg2<T> {

    @Override
    public T berechneErgebnis(T a, T b) {
        if(a instanceof Integer){
            return (T) ((Integer) ((Integer) a - (Integer) b));
        }
        return null;
    }

    

    
    
}
