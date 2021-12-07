/**
 * This class is an implementation of fractions. you can create fraction, add/multply them with other fraction and print them. 
 *
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class Bruch {
    private int a, b, resultTop, resultBottom;
    
    /**
     * constructor for "bruch" (fraction). a/b
     * @param a top of the fraction
     * @param b bottom of the fraction
     */
    Bruch(int a, int b){
        this.a = a;
        this.b = b;
    }

    /**
     * adds two "brüche" (fractions).
     * @param f Fraction to be added
     * @return fraction with a/b + c/d as result
     */
    public Bruch add(Bruch f){
        if(this.b != f.b){
            this.resultTop = (this.a * f.b) + (f.a * this.b);
            this.resultBottom = (this.b * f.b);
        }else{
            this.resultTop = this.a + f.a;
            this.resultBottom = this.b;
        }
        return new Bruch(this.resultTop,this.resultBottom);
    }

    /**
     * multiplies two "brüche" (fractions)
     * @param f fraction to be multiplied
     * @return fraction with a/b * b/c as result
     */
    public Bruch multiply(Bruch f){
        this.resultTop = this.a * f.a;
        this.resultBottom = this.b * f.b;
        return new Bruch(this.resultTop, this.resultBottom);
    }

    /**
     * Overrides the toString method to print a "bruch" (fraction)
     */
    @Override
    public String toString() {
        return this.a + "/" + this.b;
    }
}
