package ListaDinamica.Entities;

import ListaDinamica.Interfaces.List;
import ListaDinamica.Exceptions.EmptyListException;

class LinkedList<E> implements List<E> {

    private class Node {
        E value;
        Node next;
    
        public Node(E value) {
            this.value = value;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public LinkedList() {}

    public LinkedList(E value) {
        add(value);
    }

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            head = newNode;            
        } else {
            tail.next = newNode;           
        }
        tail = newNode;
        size++;        
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeLast() throws EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        String linkedList = "[";

        Node auxNode = head;

        while(auxNode != null){
            if(auxNode.next == null){
                linkedList += auxNode.value;
                
            } else {
                linkedList += auxNode.value + ", ";
            }
            auxNode = auxNode.next;
        }

        return linkedList + "]";
    }
}
