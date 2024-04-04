package collections;

public interface Queue<E> {
    void enqueue(E value);
    void dequeue();
    E first();
    int size();
    boolean isEmpty();
}