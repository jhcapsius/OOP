/**
 * The program calculates the power of a to the power of b
 * * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class Power {
    public static void main(String[] args) {
        int a = 2;
        int b = 2;
        int result = 1;
        for (int i = 1; i <= b; i++){
                result = result * a;
        }
        System.out.println("Result: " + result);
    }
}
