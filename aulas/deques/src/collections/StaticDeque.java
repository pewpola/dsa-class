package collections;

import Exceptions.*;

public class StaticDeque<E> implements Deque<E> {
    private int size;
    private E[] deque;
    private int first;

    @SuppressWarnings("unchecked")
    public StaticDeque(int maxSize) {
        deque = (E[]) new Object[maxSize];
    }

    @Override
    public void add(E value) {
        if (isFull()) {
            throw new FullDequeException("Queue is Full!");
        }

        deque[(first + size) % deque.length] = value;
        size++;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new EmptyDequeException("Queue is Empty!");
        }

        return deque[first];
    }

    @Override
    public void insert(E value) {
        if (isFull()) {
            throw new FullDequeException("Queue is Empty!");
        }

        first = (first - 1 + deque.length) % deque.length;
        deque[first] = value;
        
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == deque.length;
    }

    @Override
    public E last() {
        if (isEmpty()) {
            throw new EmptyDequeException("Queue is Empty!");
        }

        return deque[((first + size - 1) % deque.length)];
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new EmptyDequeException("Queue is Empty!");
        }

        E value = first();
        deque[first] = null;
        first = (first + 1) % deque.length;
        
        size--;
        return value;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new EmptyDequeException("Queue is Empty!");
        }

        E value = last();
        deque[(first - 1 + size) % deque.length] = null;

        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }   
}
