/**
 * This program calculates the zeros of a quadratic function.
 * * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class CalcZeropoints {
    double a = 1, b = 3, c = 2, x1, x2, sqrt;

    public static void main(String[] args) {
        new CalcZeropoints().calculateZeros();
    }

    public void calculateZeros() {
        System.out.println("Quadratic function: " + this.a + "x^2 + " + this.b + "x + " + this.c);

        //calculates the value under the root. if the value is negative, there is no value in the real number space
        this.sqrt = ((this.b * this.b) - (4 * this.a * this.c));
        if (this.sqrt < 0) {
            System.out.print("There is no valid solution for x1 and x2!");
        } else {

            //calculates the values for x1 and x2 and prints them on the terminal
            this.x1 = ((-1) * this.b + Math.sqrt(this.sqrt)) / (2 * this.a);
            System.out.printf("x1: %.4f\n", this.x1);
            this.x2 = ((-1) * this.b - Math.sqrt(this.sqrt)) / (2 * this.a);
            System.out.printf("x2: %.4f\n", this.x2);
        }
    }
}

