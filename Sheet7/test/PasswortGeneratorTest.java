/**
 * Test class for passgenerator
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class PasswortGeneratorTest {
    public static void main(String[] args) {
        PasswortGenerator passwortGenerator = new PasswortGenerator();
        
        String test = "java ist eine objekt-orientierte sprache!";
        String test2 = "Java ist auch eine Insel (von Christian Ullenboom)";
        String test3 = "java           /&%$§! 4 54 23 45 3 5 ist eine objekt-orientierte sprache!";
        passwortGenerator.erstellePasswort(test);
        System.out.println("Passwort: " + passwortGenerator.toString());
        passwortGenerator.erstellePasswort(test2);
        System.out.println("Passwort: " + passwortGenerator.toString());
        passwortGenerator.erstellePasswort(test3);
        System.out.println("Passwort: " + passwortGenerator.toString());
    }
    
}
