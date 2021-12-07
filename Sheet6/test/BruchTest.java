/**
 * Testclass for the Bruch class
 * 
 * @author Jan-Herik Capsius
 * @version 1.0
 */

public class BruchTest {
    public static void main(String[] args) {
        Bruch fraction1 = new Bruch(3, 7);
        Bruch fraction2 = new Bruch(3,6);
        System.out.println("Fraction1: " + fraction1.toString());
        System.out.println("Fraction2: " + fraction2.toString());
        System.out.println(fraction1.toString() + " + " + fraction1.toString() + " = " + fraction1.add(fraction1).toString());
        System.out.println(fraction1.toString() + " + " + fraction2.toString() + " = " + fraction1.add(fraction2).toString());
        System.out.println(fraction1.toString() + " * " + fraction2.toString() + " = " + fraction1.multiply(fraction2).toString());
    }

}
