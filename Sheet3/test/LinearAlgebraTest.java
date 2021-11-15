/**
 * Testclass for LinearAlgebra
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class LinearAlgebraTest {
    public static void main(String[] args) {
        LinearAlgebra linearAlgebra = new LinearAlgebra();
        double[] vek1 = {1,2,3};
        double[] vek2 = {1,2};
        double[][] mtrx1 = {{1,2,3}, {1,2,3}};
        double[][] mtrx2 = {{1,2,3}, {1,2,3}, {1,2,3}};
        double[][] mtrx3 = {{1,2}, {1,2,3}};
        double[][] mtrx4 = {{1,2,3}, {1,2,}};

        //tests if the vectors are valid for multiplication
        System.out.print("\nVektor 1 [1,2,3] * Vektor 2 [1,2] ist null, da Dimensionen nicht gleich." +
        "\nResult: " + linearAlgebra.produkt(vek1, vek2) + "\n\n");

        //vector multiplication with valid dimesions
        System.out.print("Vektor 1 [1,2,3] * Vektor 1 [1,2,3] =\n");
        linearAlgebra.ausgabe(linearAlgebra.produkt(vek1, vek1));

        //tests if the vector and matrix are valid for multiplication
        System.out.println("Matrix 1 * Vektor 2 ist null, da Spalten Matrix 1 != Reihen Vektor 2.\nResult: " 
        + linearAlgebra.produkt(mtrx1, vek2));

        //matrix vector multiplication with valid dimesions
        System.out.print("\nMatrix 1 [1,2,3][1,2,3] * Vektor 1 [1,2,3] =\n");
        linearAlgebra.ausgabe(linearAlgebra.produkt(mtrx1, vek1));

        //tests if the rows are mismatched
        System.out.print("Matrix 1 [1,2,3][1,2,3] + Matrix 2 [1,2,3][1,2,3][1,2,3] ist null, da die Reihen "+
        "nicht gleich sind\nResult: " + linearAlgebra.add(mtrx1, mtrx2) + "\n");

        //tests if the columns are mismatched
        System.out.print("\nMatrix 1 [1,2,3][1,2,3] + Matrix 3 [1,2][1,2,3] ist null, da die Spalten "+
        "nicht gleich sind\nResult: " + linearAlgebra.add(mtrx1, mtrx3) + "\n");

        //tests if the columns are mismatched
        System.out.print("\nMatrix 1 [1,2,3][1,2,3] + Matrix 4 [1,2,3][1,2] ist null, da die Spalten "+
        "nicht gleich sind\nResult: " + linearAlgebra.add(mtrx1, mtrx4) + "\n");

        //matrix matrix addition with valid dimesions
        System.out.print("\nMatrix 1 [1,2,3][1,2,3] + Matrix1 1 [1,2,3][1,2,3] =\n");
        linearAlgebra.ausgabe(linearAlgebra.add(mtrx1, mtrx1));



        

        

        
        
        
    }
    
}
