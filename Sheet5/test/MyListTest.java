/**
 * Testclass for MyList.java
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

package test;
import src.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList myList = new MyList();
        MyList mylist2 = new MyList();
        
        //add element to mylist test index out of bounce
        myList.addToList(20, 20);

        //add element to mylist test empty list
        myList.addToList(0, 1);
        myList.printArray();

        //add element to mylist test element add to the end
        myList.addToList(myList.getArrayLength(), 2);
        myList.printArray();

        //add element to mylist test element between first and last element
        myList.addToList(1, 1);
        myList.addToList(1, 2);
        myList.addToList(1, 3);
        myList.addToList(1, 4);
        myList.addToList(1, 9);
        myList.addToList(1, 6);
        myList.printArray();

        //remove duplicates test list has duplicates
        System.out.println("Amount of removed duplicates: " + myList.removeDuplicates());
        myList.printArray();

        //remove duplicates test list has no duplicates
        System.out.println("Amount of removed duplicates: " + myList.removeDuplicates());
        myList.printArray();

        //remove from list test index out of bounce
        myList.removeFromList(myList.getArrayLength());

        //remove from list test list is empty
        mylist2.removeFromList(0);

        //remove from list test remove last entry
        System.out.println("Before remove");
        myList.printArray();
        myList.removeFromList(myList.getArrayLength()-1);
        System.out.println("After remove");
        myList.printArray();

        //remove from list test remove first entry
        System.out.println("Before remove");
        myList.printArray();
        myList.removeFromList(0);
        System.out.println("After remove");
        myList.printArray();

        //remove from list test remove entry between first and last
        System.out.println("Before remove");
        myList.printArray();
        myList.removeFromList(2);
        System.out.println("After remove");
        myList.printArray();

        //get triplets that equals given number test
        int[] array = {21,12,3,27,4,6,9,1,2,8,7,10,11,15,14,0};
        myList.printArray();
        myList.setArray(array);
        myList.kombiZahl(18);



        
        
    }

    
}
