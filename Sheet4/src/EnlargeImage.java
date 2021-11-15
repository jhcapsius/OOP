/**
 * This class can be used to enlarge binary images with a factor f. Here the numbers 1 stand for white and 0 for black
 * 
 * @author Jan-Henrik Capsius   
 * @version 1.0
 */

public class EnlargeImage {
    private int counter, h, j;
    private int[][] zoomedImage;

    /**
     * enlarges a binary image
     * @param input binary image to be enlarged
     * @param f enlargement factor
     * @return enlarged binary image
     */

    public int[][] zoom(int[][] input, int f){
        //allows only nxn matrices
        if(!validMatrix(input)){
            System.out.println("Keine gültige Matrix");
            return null;

        //allows only enlargement factors bigger than 1    
        }else if(f <= 1){
            System.out.println("Der Faktor muss größer als 1 sein.");
            return null;
        }else{
            this.counter = 0;
            this.h = 0;
            this.j = 0;

            //matrix for the zooomed image
            this.zoomedImage = new int[input.length * f][input[0].length * f];

            /*
            The loops fill the matrix for the enlarged image. This means that each row and each field of the original image is added f times to the matrix. 
            The variable counter counts up each time a row is added. If the counter equals f, the next row and its fields of the original image are added f times.    
            */
            for(int i = 0; i < zoomedImage.length; i++){
                if(counter == f){
                    this.h += 1;
                    counter = 0;
                }
                for(int k = 0; k < zoomedImage.length; k++){
                    if((k % f) != 0 || k == 0){
                        zoomedImage[i][k] = input[this.h][this.j]; 
                    }else{
                        this.j += 1;
                        zoomedImage[i][k] = input[this.h][this.j];
                    }
                }
                this.j = 0;
                counter +=1;
            }
            return zoomedImage;
        }
    }

    /**
     * helper-function that checks if the orginal image matrix is valid
     * @param image original image
     * @return true if not valid and false if valid
     */
    private boolean validMatrix(int[][] image){
        for(int i = 0; i < image.length; i++){
            if(image.length != image[i].length){
                return false;
            }
        }
        return true;
    }

    /**
     * prints the original and enlarged image
     * @param image original or enlarged image
     */
    public void print(int[][] image){
        if(image == null){
        }else{
            for (int i = 0; i < image.length; i++){
                for (int k = 0; k < image[0].length; k++){
                    System.out.print(image[i][k] + " ");
                }
            System.out.println();
            }
        }
        System.out.println();
    }
   
}
