package collections;

import exceptions.EmptyQueueException;

public class CircularLinkedQueue<E> implements Queue<E> {

    class Node {
        E value;
        Node next;
        
        public Node(E value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void enqueue(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is Empty!");
        }

        return first.value;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public int size() {
        return size;
    }
       
}
