/**
 * Testclass for Arithmetik class to test the calculationw ays
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class MatheAnwendung {
    public static void main(String[] args) {
        Arithmetik arithmetik = new Arithmetik();
       
        //Test calculation way was not determined
        arithmetik.berechne(5, 5);

        //Test addition
        arithmetik.bestimmeRechenweg(new RechenwegPlus());
        System.out.println(arithmetik.berechne(5, 5));

        //Test subtraction
        arithmetik.bestimmeRechenweg(new RechenwegMinus());
        System.out.println(arithmetik.berechne(5, 5));
        
        //Test multiplication
        arithmetik.bestimmeRechenweg(new RechenwegMal());
        System.out.println(arithmetik.berechne(5, 5));
  
    }
}
