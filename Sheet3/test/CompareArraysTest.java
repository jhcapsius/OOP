/**
 * Testclass for to compare arrays
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class CompareArraysTest {
    public static void main(String[] args) {
        CompareArrays compareArrays = new CompareArrays();
    int[] arr1 = {1,2,3,4};
    int[] arr2 = {1,2,3};
    int[] arr3 = {1,2,4,4};
    int[] arr4 = {1,2,3,4};
    int[] arr5 = {2,4,1,3};
    int[] arr6 = {1,1,2,2};
    int[] arr7 = {2,2,1,1};


    System.out.println("Länge von arr1 und arr2 unterschiedlich, return daher false. Return: " + compareArrays.isEqual(arr1, arr2));
    System.out.println("Inhalt von arr1 und arr 3 sind unterschiedlich, return daher false. Return: " + compareArrays.isEqual(arr1, arr3));
    System.out.println("Inhalt von arr1 und arr4 ist gleich, return daher true. Return: " + compareArrays.isEqual(arr1, arr4));
    System.out.println("Inhalt von arr1 und arr5 ist gleich, aber andere Reihenfolge, muss trotzdem true sein. Return: " 
    + compareArrays.isEqual(arr1, arr5));
    System.out.println("Werte sind mehrfach in arr6 und arr7 vorhanden, das Array ist aber trotzdem gleich. Daher muss return true sein." +
    " Return: " + compareArrays.isEqual(arr6, arr7));
        
    }    
}
