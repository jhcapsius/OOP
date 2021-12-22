/**
 * Testclass
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TransportTest {
    public static void printClassInfos(Object obj) {
        Class class1 = obj.getClass();
        System.out.println("Name der Klasse: " + class1.getName() + "\nAnzahl Modifier: " + class1.getModifiers()
                + "\nOberklasse: " + class1.getSuperclass() + "\n");

    }

    public static void printMethodInfos(Object obj) {
        Class class1 = obj.getClass();
        Method[] methods = class1.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Name der Methode: " + methods[i].getName() + "\nAnzahl Modifier: "
                    + methods[i].getModifiers() + "\nRueckgabewert: " + methods[i].getReturnType() + "\n");
        }

    }

    public static void main(String[] args) throws Exception {
        Transport transport = new Transport("Flugzeug");
        Truck truck = new Truck("Truck");
        Schiff schiff = new Schiff("Schiff");

        Class class1 = truck.getClass();
        try{
            Field name = class1.getDeclaredField("name");
            name.setAccessible(true);
            name.set(truck, "Reflection");
        }catch(Exception e){
            System.out.println("There is no attribute named name");
        }

        class1 = schiff.getClass();
        try{
            Field name = class1.getDeclaredField("name");
            name.setAccessible(true);
            name.set(schiff, "Reflection");
        }catch(Exception e){
            System.out.println("There is no attribute named name");
        }

        System.out.println("Info Transportklasse");
        TransportTest.printClassInfos(transport);
        System.out.println("Info Transportmethoden");
        TransportTest.printMethodInfos(transport);
        System.out.println("------------------------------------\n");
        System.out.println("Info Truckklasse");
        TransportTest.printClassInfos(truck);
        System.out.println("Info Truckmethoden");
        TransportTest.printMethodInfos(truck);
        System.out.println("------------------------------------\n");
        System.out.println("Info Schiffklasse");
        TransportTest.printClassInfos(schiff);
        System.out.println("Info Schiffmethoden");
        TransportTest.printMethodInfos(schiff);
    }
}
