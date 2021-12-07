/**
 * Testclass for the Frame class
 * 
 * @author Jan-Herik Capsius
 * @version 1.0
 */
public class FrameTest {
    public static void main(String[] args) {
        Frame frame = new Frame();
        String[] arr = {"Rahmen", "sind", "toll"};
        String[] arr2 = {"Das ist", "ein", "Test"};
        frame.printFrame(arr);
        frame.printFrame(arr2);
    }
}
