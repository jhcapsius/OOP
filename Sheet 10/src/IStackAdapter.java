/**
 * Stackdapter Interface
 * 
 * @author Jan-Henrik Capsius
 * @version 1.0
 */

public interface IStackAdapter<T> {
    boolean empty();

    T push(T item);

    T pop();

    T peek();
}
