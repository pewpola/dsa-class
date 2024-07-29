package collections;

public interface Stack<E> {
    void push(E value);
    E pop();
    E top();
    boolean isEmpty();
    int height();
}
