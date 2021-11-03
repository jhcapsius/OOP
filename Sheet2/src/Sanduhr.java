/**
 * The program outputs an hourglass in the terminal based on a given width.
 *
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class Sanduhr{

    /**
     * outputs the hourglass in the terminal
     * @param width user value that specifies the width of the first line. Must not be less than three, otherwise you
     *              cannot build an hourglass.
     */
    public void printSanduhr(int width) {
        System.out.print("Breite der Sanduhr: " + width);
        System.out.println();

        //checks whether the selected width is permissible
        if (width < 3){
            System.out.println("An hourglass cannot be created with values less than three.");
        }else{

            //generates the lines of the upper half of the hourglass
            for (int i = 0; i < width; i += 2){

                //generates the distances of the characters from the left margin
                for (int k = 0; k < i-1; k+=2){
                    System.out.print(" ");
                }

                //generates the characters that represent the hourglass at the end of the program
                for (int j = i; j < width; j++){
                    System.out.print("*");
                }

                //creates a new line
                System.out.println();
            }

            //finds out if the width is even or odd
            if (width % 2 != 0){

                //generates the rows of the lower half of the hourglass if the width is odd
                for (int i = width - 2; i > 0; i -= 2){

                    //generates the distances of the characters from the left margin
                    for (int k = i; k > 2 ; k -= 2){
                        System.out.print(" ");
                    }

                    //generates the characters that represent the hourglass at the end of the program
                    for (int j = i; j <= width; j++){
                        System.out.print("*");
                    }

                    //erstellt eine neue Zeile
                    System.out.println();
                }
            }else {

                //generates the rows of the lower half of the hourglass when the width is even
                for (int i = width - 2; i > 0; i -= 2){

                    //generates the distances of the characters from the left margin
                    for (int k = i; k > 2 ; k -= 2){
                        System.out.print(" ");
                    }

                    //generates the characters that represent the hourglass at the end of the program
                    for (int j = i; j <= width+1; j++){
                        System.out.print("*");
                    }

                    //creates a new line
                    System.out.println();
                }
            }
        }
        //creates a new line
        System.out.println();
    }
}
