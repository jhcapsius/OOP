public class StackAdapter<T> implements IStackAdapter<T> {
    Stack<T> stack;

    StackAdapter() {
        this.stack = new Stack<>();
    }

    @Override
    public boolean empty() {
        return this.stack.empty();
    }

    @Override
    public T push(T item) {
        return this.stack.push(item);
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }

    @Override
    public T peek() {
        return this.stack.peek();
    }

}
