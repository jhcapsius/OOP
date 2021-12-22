/**
 * Stackdapter class, that implements the methods of the IStackAdapter interface
 * and an object of the Stack class.
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public class StackAdapter<T> implements IStackAdapter<T> {
    Stack<T> stack;

    /**
     * Constructor that initializes the Stack object
     */
    StackAdapter() {
        this.stack = new Stack<>();
    }

    /**
     * Overrides the empty method from the interface and calls the empthy method of
     * the stack object.
     */
    @Override
    public boolean empty() {
        return this.stack.empty();
    }

    /**
     * Overrides the empty method from the interface and calls the push method of
     * the stack object.
     */
    @Override
    public T push(T item) {
        return this.stack.push(item);
    }

    /**
     * Overrides the empty method from the interface and calls the pop method of the
     * stack object.
     */
    @Override
    public T pop() {
        return this.stack.pop();
    }

    /**
     * Overrides the empty method from the interface and calls the peek method of
     * the stack object.
     */
    @Override
    public T peek() {
        return this.stack.peek();
    }

}
