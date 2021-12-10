/**
 * Testclass for the generic Arithmetik class to test the calculationw ways
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class MatheAnwendungen2 {
    public static void main(String[] args) {
        //allowed implementation
    Arithmetik2<Integer> arithmetikInteger = new Arithmetik2<>();
    Arithmetik2<Double> arithmetikDouble = new Arithmetik2<>();
    Arithmetik2<Float> arithmetikFloat = new Arithmetik2<>();
    Arithmetik2<Long> arithmetikLong = new Arithmetik2<>();

    //an example of an not allowed implementatio
    Arithmetik2<String> arithmetikString = new Arithmetik2<>();

    //Test calculation way not choosen
    arithmetikInteger.berechne(5, 5);


    }
}
