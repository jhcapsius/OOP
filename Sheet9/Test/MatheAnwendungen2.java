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
    Arithmetik2<Long> arithmetikLong = new Arithmetik2<>();
    Arithmetik2<Float> arithmetikFloat = new Arithmetik2<>();
    Arithmetik2<Double> arithmetikDouble = new Arithmetik2<>();
    
    //an example of an not allowed implementation
    Arithmetik2<String> arithmetikString = new Arithmetik2<>();

    //test not allowed type
    System.out.println("Testfall Typ nicht erlaubt");
    arithmetikString.bestimmeRechenweg(new RechenwegPlusGeneric<>());
    System.out.println(arithmetikString.berechne("a", "b")+"\n");

    //Test calculation way not choosen
    System.out.println("Testfall Rechenweg nicht ausgewählt");
    arithmetikInteger.berechne(5, 5);
    System.out.println();
 
    //Test addition
    System.out.println("Testfall Addition mit den erlaubten Typen");
    arithmetikInteger.bestimmeRechenweg(new RechenwegPlusGeneric<>());
    arithmetikLong.bestimmeRechenweg(new RechenwegPlusGeneric<>());
    arithmetikFloat.bestimmeRechenweg(new RechenwegPlusGeneric<>());
    arithmetikDouble.bestimmeRechenweg(new RechenwegPlusGeneric<>());
    
    System.out.println(arithmetikInteger.berechne(5, 5));
    System.out.println(arithmetikLong.berechne(5L, 5L));
    System.out.println(arithmetikFloat.berechne(5.0f, 5.0f));
    System.out.println(arithmetikDouble.berechne(5.0, 5.0) +"\n");

    //Test subtraction
    System.out.println("Testfall Subtraktion mit den erlaubten Typen");
    arithmetikInteger.bestimmeRechenweg(new RechenwegMinusGeneric<>());
    arithmetikLong.bestimmeRechenweg(new RechenwegMinusGeneric<>());
    arithmetikFloat.bestimmeRechenweg(new RechenwegMinusGeneric<>());
    arithmetikDouble.bestimmeRechenweg(new RechenwegMinusGeneric<>());
    
    System.out.println(arithmetikInteger.berechne(5, 5));
    System.out.println(arithmetikLong.berechne(5L, 5L));
    System.out.println(arithmetikFloat.berechne(5.0f, 5.0f));
    System.out.println(arithmetikDouble.berechne(5.0, 5.0)+"\n");

    //Test multiplication
    System.out.println("Testfall Multiplikation mit den erlaubten Typen");
    arithmetikInteger.bestimmeRechenweg(new RechenwegMalGeneric<>());
    arithmetikLong.bestimmeRechenweg(new RechenwegMalGeneric<>());
    arithmetikFloat.bestimmeRechenweg(new RechenwegMalGeneric<>());
    arithmetikDouble.bestimmeRechenweg(new RechenwegMalGeneric<>());
    
    System.out.println(arithmetikInteger.berechne(5, 5));
    System.out.println(arithmetikLong.berechne(5L, 5L));
    System.out.println(arithmetikFloat.berechne(5.0f, 5.0f));
    System.out.println(arithmetikDouble.berechne(5.0, 5.0));
    
    
    



    }
}
