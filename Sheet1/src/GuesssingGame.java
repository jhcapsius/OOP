/**
 * This is a simple guessing game. The player is asked to enter a number between 0 and 100.
 * If the number is too big or too small, the player is told. At the end the number of attempts is displayed.
 *
 * @author Jan-Henrik Capsius
 * @version 1.0
 */



import java.util.Scanner;

public class GuesssingGame {
    int randomNumber, readInt, counter;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new GuesssingGame().rateZahl();
    }

    public void rateZahl(){

        //generates a random number between 0 and 100
        this.randomNumber = (int) (Math.random() * 101.0);
        do {
            do {
                //checks if the entered number is valid
                System.out.println("Geben sie eine Zahl zwischen 0 und 100 ein: ");
                this.readInt = sc.nextInt();
                if(this.readInt < 0 || this.readInt > 100){
                    System.out.println("Ungültige Zahl");
                }
            }while (this.readInt < 0 || this.readInt > 100);

            //asks if the number is too big, too small or the number you are looking for and increases the counter by 1.
            if (this.readInt < this.randomNumber){
                System.out.println("Zufallszahl ist groesser!");
                counter +=1;
            }else if(this.readInt > this.randomNumber){
                System.out.println("Zufallszahl ist kleiner!");
                counter +=1;
            }else {
                counter +=1;
                System.out.println("Geschafft! Zufallszahl war " + this.randomNumber);
                System.out.println("Anzahl der Versuche = " + this.counter);
            }
        }while (this.readInt != this.randomNumber);
    }
}
