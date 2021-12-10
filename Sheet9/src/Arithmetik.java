/**
 * This class uses different ways calculation ways. For this purpose, you have to set a calculation way with the method bestimmeRechenweg. After that, you can pass the two numbers a and b to the method berechne to get the result of the chosen calculation way.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */


public class Arithmetik{
    private Rechenweg rechnung;

    /**
     * sets the calculation way
     * @param rechnung one of the Rechenweg classes that implents the interface Rechenweg
     */
    public void bestimmeRechenweg(Rechenweg rechnung){
        this.rechnung = rechnung;
    }

    /**
     * calculates the result of number a and b according to the calculationw ay
     * @param a opperand 1
     * @param b opperand 2
     * @return result of opperand 1 and opperand 2
     */
    public double berechne(double a, double b){
        try{
            return this.rechnung.berechneErgebnis(a, b);
        }catch(NullPointerException e){
            System.out.println("Rechenweg muss vorher bestimmt werden");
            return -1;
        }
        
        
    }

}
