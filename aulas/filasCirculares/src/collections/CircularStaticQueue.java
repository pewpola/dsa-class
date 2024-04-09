package collections;

import exceptions.EmptyQueueException;
import exceptions.FullQueueException;

public class CircularStaticQueue<E> implements Queue<E> {

    private int size;
    private E[] queue;
    private int first;

    @SuppressWarnings("unchecked")
    public CircularStaticQueue(int maxSize) {
        queue = (E[]) new Object[maxSize];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is Empty");
        }

        E value = first();
        queue[first] = null;
        first = (first + 1) % queue.length;
        size--;

        return value;
    }

    @Override
    public void enqueue(E value) {
        if (isFull()) {
            throw new FullQueueException("Queue is Full!");
        }

        queue[(first + size) % queue.length] = value;
        size++;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is Empty!");
        }
        return queue[first];
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