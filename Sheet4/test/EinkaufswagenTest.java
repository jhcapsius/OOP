/**
 * Testclass for Einkaufswagen
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class EinkaufswagenTest {
    public static void main(String[] args) {
        Einkaufswagen cart = new Einkaufswagen();
        cart.showContent();
        cart.addToCart("potato");
        cart.addToCart("carrot");
        cart.addToCart("onion");
        cart.addToCart("water");
        cart.addToCart("salad");
        cart.showContent();
        cart.addToCart("beer");
        cart.removeFromCart("beer");
        cart.removeFromCart("potato");
        cart.removeFromCart("onion");
        cart.removeFromCart("water");
        cart.showContent();
        cart.removeFromCart("carrot");
        cart.removeFromCart("salad");
        cart.showContent();
        cart.removeFromCart("salad");
        
    }
    
}
