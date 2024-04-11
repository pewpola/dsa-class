package collections;

import Exceptions.*;

public class LinkedDeque<E> implements Deque<E> {

    class Node {
        E value;
        Node next;
        Node previous;
        
        public Node(E value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    @Override
    public void add(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new EmptyDequeException("Queue is Empty!");
        }

        return first.value;
    }

    @Override
    public void insert(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E last() {
        if (isEmpty()) {
            throw new EmptyDequeException("Queue is Empty!");
        }

        return last.value;
    }

    @Override
    public E removeFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        return size;
    }
    
}
