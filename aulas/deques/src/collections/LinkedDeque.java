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
        Node newNode = new Node(value);

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last; 
        }

        last = newNode;
        last.next = first;
        first.previous = last;

        size++;
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
        Node newNode = new Node(value);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
        }

        last.next = first;
        first.previous = last;
        
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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
