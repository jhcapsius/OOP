/**
 * With the Shopping Cart class, items can be added and removed using the addItem and removeItem methods. In addition, the contents of the shopping cart and the total price can be printed using the printContent method.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

import java.util.ArrayList;

public class Warenkorb {
    private ArrayList<Artikel> artikelListe = new ArrayList<>();
    private double totalPrice;

    /**
     * Method to add articles
     * @param artikel Article to be added
     */
    public void addItem(Artikel artikel){
        this.artikelListe.add(artikel);
    }

    /**
     * Method to remove articles
     * @param index Article to be removed
     */
    public void removeItem(int index){
        try{
            this.artikelListe.remove(index);
        }catch(IndexOutOfBoundsException e){
            System.out.println("An der Stelle gibt es kein Item.\n");
        }
        
    }

    /**
     * prints the content of the shopping card
     */
    public void printContent(){
        for(Artikel artikel : artikelListe){
            System.out.printf(artikel.toString() + " : %.2f Euro\n", artikel.getPreis());
        }

        printTotalPrice();
    }

    /**
     * calculates the total price
     */
    private void printTotalPrice(){
        if(this.totalPrice != 0){
            this.totalPrice = 0;
        }
        for (Artikel artikel : artikelListe) {
            totalPrice += artikel.getPreis();
        }
        System.out.printf("\nGesamtpreis: %.2f Euro\n\n", totalPrice);
    } 
    
}
