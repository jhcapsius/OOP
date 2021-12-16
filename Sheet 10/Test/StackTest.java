public class StackTest {
    public static void main(String[] args) {
        IStackAdapter<Integer> stackAdapter = new StackAdapter<>();
        
        //Test stack is empty
        System.out.println(stackAdapter.empty() + "\n"); 
        
        //test peek when stack is empty
        System.out.println(stackAdapter.peek() + "\n");

        //test pop when stack is empty
        System.out.println(stackAdapter.pop() + "\n");

        //test add an item
        System.out.println(stackAdapter.push(2) + "\n");

        //test stack is not empty
        System.out.println(stackAdapter.empty() + "\n");

        //test peek when stack is not empty
        System.out.println(stackAdapter.peek() + "\n");

        //test pop when stack is not empty
        System.out.println(stackAdapter.pop() + "\n");


        

    }
}
