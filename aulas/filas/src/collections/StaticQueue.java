package collections;

import exceptions.FullQueueException;

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
        if (isFull()) {
            throw new FullQueueException("Queue is full!");
        }

        queue[size] = value;
        size++;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for (int i = size - 1; i >= 0; i--) {
            sb.append(queue[i]);

            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
