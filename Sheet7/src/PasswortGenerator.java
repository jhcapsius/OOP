/**
 * Implementation of a program that generates a password from a sentence by using the first letters of each word. The letters are stored alternately as upper or lower case letters.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */


public class PasswortGenerator {
    private String password;
    private String[] splitted;

    /**
     * creates a password by a given sentence
     * @param sentence given sentence
     */
    public void erstellePasswort(String sentence){
        //replaces all special characters except whitespaced
        sentence = sentence.replaceAll("[^a-zA-Z\\s]", "");
        //removes duplicate spaces
        sentence = sentence.replaceAll(" +", " ");
        //split string into pieces at space
        this.splitted = sentence.split(" ");

        //Sets the first letter of the password as uppercase and then switches between uppercase and lowercase
        for(int i = 1; i <= this.splitted.length; i++){
            if(i == 1){
                this.password = this.splitted[i-1].substring(0,1).toUpperCase();
            }else if(i % 2 != 0){
                this.password = this.password + this.splitted[i-1].substring(0,1).toUpperCase();
            }else{
                this.password = this.password + this.splitted[i-1].substring(0,1).toLowerCase();
            }
        }
    }

    //overrides tostring method to print the private password
    @Override
    public String toString() {
        return this.password;
    }
   
}
