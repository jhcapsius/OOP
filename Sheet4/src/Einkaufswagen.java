/**
 * With this class, a shopping cart can be realized in which five items can be placed and taken out. 
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

import java.util.ArrayList;

public class Einkaufswagen {
    private ArrayList <String> cart;

    public Einkaufswagen(){
        cart = new ArrayList<>();
    }
    
    /**
     * adds an item to the shopping cart as long as it is not full
     * @param item new item
     */
    public void addToCart(String item){
        if(this.cart.size() < 5){
            this.cart.add(item);
            System.out.println("A " + item + " was added to the shopping cart.\n");
        }else{
            System.out.println("Shopping cart is full. " + item + " could not be added.\n");
        }
    }
    
    /**
     * removes an item from the shopping cart as long as it is not empty
     * @param item item that someone wants to remove
     */
    public void removeFromCart(String item){
        if(this.cart.size() == 0){
            System.out.println("The shopping cart is empty. Nothing more can be taken out\n");
        }else{

            //searches for the item and removes it
            for (int i = 0; i < this.cart.size(); i++){
                if(this.cart.get(i).equals(item)){
                    this.cart.remove(i);
                    System.out.println("A " + item + " was taken out of the shopping cart.\n");
                    break;
                }else if(i + 1 == this.cart.size()){
                    System.out.println("Item not in shopping cart.\n");
                }
            }
        }
    }

    /**
     * Prints the content of the shopping cart
     */
    public void showContent(){
        if(this.cart.size() == 0){
            System.out.println("Shopping cart is empy.\n");
        }else{
            System.out.println("Shopping cart content:");
            for(int i = 0; i < this.cart.size(); i++){
                System.out.println(this.cart.get(i));
            }
            System.out.println();
        }     
    }
}
