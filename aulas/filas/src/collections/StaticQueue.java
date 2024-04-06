package collections;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class StaticQueue<E> implements Queue<E> {

    private int size;
    private E[] queue;

    @SuppressWarnings("unchecked")
    public StaticQueue(int maxSize) {
        queue = (E[]) new Object[maxSize];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is Empty");
        }

        E removedElement = queue[0];

        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }

        queue[size - 1] = null;
        size--;

        return removedElement;
    }

    @Override
    public void enqueue(E value) {
        if (isFull()) {
            throw new FullQueueException("Queue is Full!");
        }

        queue[size] = value;
        size++;
    }

    @Override
    public E first() {
        return queue[0];
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
