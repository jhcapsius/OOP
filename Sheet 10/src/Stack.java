
/**
 * This class implements a stack.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> stack;

    /**
     * Contructor that initialzed the array list
     */
    Stack() {
        this.stack = new ArrayList<>();
    }

    /**
     * returns the status of the stack
     * 
     * @return true if the stack is empty or false if the stack is not empty
     */
    public boolean empty() {
        return this.stack.isEmpty();
    }

    /**
     * appends an item
     * 
     * @param item item that we want to append
     * @return item
     */
    public T push(T item) {
        this.stack.add(item);
        return item;
    }

    /**
     * removes the last item of the stack. if the stack is empty a runtime exception
     * is throwns and will be catched with the message, that the stack is empty.
     * 
     * @return item that we want to remove
     */
    public T pop() {
        try {
            if (empty()) {
                throw new RuntimeException("Stack is empty");
            } else {
                T data = this.stack.get(this.stack.size() - 1);
                this.stack.remove(this.stack.size() - 1);
                return data;
            }
        } catch (RuntimeException e) {
            System.out.println("Stack is empty");
            return null;
        }

    }

    /**
     * shows the last item of the stack. if the stack is empty a runtime exception
     * is throwns and will be catched with the message, that the stack is empty.
     * 
     * @return last item of the stack
     */

    public T peek() {
        try {
            if (empty()) {
                throw new RuntimeException("Stack is empty");
            } else {
                return this.stack.get(this.stack.size() - 1);
            }
        } catch (RuntimeException e) {
            System.out.println("Stack is empty");
            return null;
        }
    }

}
