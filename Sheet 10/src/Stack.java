import java.util.ArrayList;

public class Stack<T> {
    ArrayList<T> stack;

    Stack() {
        this.stack = new ArrayList<>();
    }

    public boolean empty() {
        return this.stack.isEmpty();
    }

    public T push(T item) {
        this.stack.add(item);
        return item;
    }

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
