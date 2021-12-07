/**
 * Test class for bild
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */


import java.time.LocalDate;

public class BildTest {
    public static void main(String[] args) {
        Bild bild = new Bild();

        //test output if no file was read in
        bild.print();

        //test output if a file was read in
        bild.leseBild("java.pgm");
        bild.print();

        //test rotates the picure and write a new file
        bild.rotiereBild();
        LocalDate date = LocalDate.now();
        String dataName = date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth();
        bild.schreibeBild(dataName+".pgm");
    }
    
}
