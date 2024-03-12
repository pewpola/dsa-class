package entities;

import exceptions.EmptyListException;
import interfaces.List;

public class LinkedList<E> implements List<E> {

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

    public LinkedList() {
    }

    public LinkedList(E value) {
        add(value);
    }

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
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
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    private Node getNode(int index) {
        Node auxNode = head;

        for (int i = 0; i < index; i++) {
            auxNode = auxNode.next;
        }

        return auxNode;
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {
        if (index <= 0) {
            insert(value);
        } else if (index >= size) {
            add(value);
        } else {
            Node newNode = new Node(value);
            Node auxNode = getNode(index - 1);
            newNode.next = auxNode.next;
            auxNode.next = newNode;
            size++;
        }
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
        StringBuilder sb = new StringBuilder("[");

        Node auxNode = head;

        while (auxNode != null) {
            sb.append(auxNode.value);
            if (auxNode.next == null) {
                sb.append(", ");
            }
            auxNode = auxNode.next;
        }
        return sb.append("]").toString();
    }
}
