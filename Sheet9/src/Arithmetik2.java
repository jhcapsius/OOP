public class Arithmetik2<T> {

    private Rechenweg2<T> rechnung;

    public void bestimmeRechenweg(Rechenweg2 <T> rechenwegGeneric){
        this.rechnung = rechenwegGeneric;
    }

    public T berechne(T a, T b){
        try{
            return this.rechnung.berechneErgebnis(a, b);
        }catch(NullPointerException e){
            System.out.println("Rechenweg muss vorher bestimmt werden");
            return null;
        }
    }
}
