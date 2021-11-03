/**
 * This program calculates component-wise the product of two vectors, the product of a matrix and a vector and the sum of two matrices.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */


public class LinearAlgebra {
    private double puffer;
    private double[] result_product_vek;
    private double[] result_product_mtrx;
    private double[][] result_sum_mtrx; 

    /**
     * multiplies two vectors component by component
     * @param a vector 1
     * @param b vector 2
     * @return null, if the length does not match or an vector-array with the new values
     */
    public double[] produkt(double a[], double b[]){
        if(a.length != b.length){
            return null;
        }else{
            this.result_product_vek = new double[a.length];
            for (int i = 0; i < a.length; i++){
                this.result_product_vek[i] = a[i] * b[i];
            }
        return this.result_product_vek;
        }
    }
    /**
     * multiplies a matrix component by component with a vector
     * @param a matrix 1
     * @param b vektor 1
     * @return null, if the length foes no match or an vector-array with the new values
     */
    //produkt einer m x n Matrix mit einem nx1-Vektor
    public double[] produkt(double a[][], double b[]){
        if(a[0].length != b.length){
            return null;
        }else{
            this.result_product_mtrx = new double[a.length];
            for(int i = 0; i < a.length; i++){
                puffer = 0;
                for (int k = 0; k < b.length; k++){
                     puffer = puffer + (a[i][k] * b[k]);
                }
                this.result_product_mtrx[i] = this.puffer;
            }
            return result_product_mtrx;
        }
    }

    /**
     * adds two matrices componentwise
     * @param a matrix 1
     * @param b matrix 1
     * @return null, if the matrices dont match or an matrix-array with thhe new values
     */
    public double[][] add(double a[][], double b[][]){
        if(a.length != b.length){
            return null;
        }

        for (int i = 0; i < a.length; i++){
            if(a[i].length != b[i].length){
                return null;
            }
        }
        
        result_sum_mtrx = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++){
            for(int k = 0; k < a[0].length; k++){
                result_sum_mtrx[i][k] = a[i][k] + b[i][k];
            }
        }
        return result_sum_mtrx; 
    }
    
    /**
     * prints a vector
     * @param a given vector
     */
    public void ausgabe(double a[]){
        if(a == null){
            System.out.println("Leerer Vektor.");
        }else{
            System.out.print("[");
            for(int i = 0; i < a.length; i++ ){
                if( i + 1 != a.length){
                    System.out.printf("%.0f ", a[i]);
                }else{
                    System.out.printf("%.0f", a[i]);
                }
            }
        System.out.print("]\n\n");
        }
    }

    /**
     * prints a matrix
     * @param a given matrix
     */
    public void ausgabe(double a[][]){
        if(a == null){
            System.out.println("Leere Matrix");
        }else{
            System.out.print("[\n");
            for(int i = 0; i < a.length; i++){
                for(int k = 0; k < a[0].length; k++){
                    System.out.printf("%.0f ", a[i][k]);
                }
            System.out.println();
            }
            System.out.print("]\n\n");  
        }       
    }
}
