/**
 * Testclass for Memory
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class MemoryTest {
    public static void main(String[] args) {
        Memory memory = new Memory();
        memory.printField(memory.generateField(3));
        memory.printField(memory.generateField(35));
        memory.printField(memory.generateField(79));
        memory.printField(memory.generateField(4));
        memory.printField(memory.generateField(4));
        memory.printField(memory.generateField(6));
        memory.printField(memory.generateField(6));
    }
    
}
