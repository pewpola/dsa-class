package collections;

public class StaticQueue<E> implements Queue<E> {

    private int size;
    private E[] queue;

    @SuppressWarnings("unchecked")
    public StaticQueue(int maxSize) {
        queue = (E[]) new Object[maxSize];
    }

    @Override
    public void dequeue() {
        // TODO Auto-generated method stub

    }

    @Override
    public void enqueue(E value) {

    }

    @Override
    public E first() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    @Override
    public int size() {
        return size;
    }

}
