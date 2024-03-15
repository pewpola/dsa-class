package listaDeCompras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        n = sc.nextInt();
    }
}

class SalesList {

}

interface List<E> {
    int size();

    void add(E value);

    void insert(E value);

    void insert(int index, E value) throws IndexOutOfBoundsException;

    E removeLast() throws EmptyListException;

    E removeFirst() throws EmptyListException;

    E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException;

    boolean isEmpty();

    E get(int index) throws IndexOutOfBoundsException;

    void set(int index, E value) throws IndexOutOfBoundsException;
}

class DoublyLinkedList<E> implements List<E> {

    private class Node {
        E value;
        Node next;
        Node previous;

        public Node(E value) {
            this.value = value;
        }
    }

    private int size;
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(E value) {
        add(value);
    }

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Linked List is Empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Illegal index " + index + ". Available indexes are [0 - " + (size - 1) + "]");
        }

        return getNode(index).value;
    }

    public E getInverse(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Linked List is Empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Illegal index " + index + ". Available indexes are [0 - " + (size - 1) + "]");
        }

        return getNodeInverse(index).value;
    }

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
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

    private Node getNodeInverse(int index) {
        Node auxNode = tail;

        for (int i = size - 1; i > index; i--) {
            auxNode = auxNode.previous;
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
            Node auxNode1 = getNode(index);
            Node auxNode2 = getNode(index - 1);

            newNode.next = auxNode2.next;
            newNode.previous = auxNode1.previous;
            auxNode2.next = newNode;
            auxNode1.previous = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Linked List is Empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Illegal index " + index + ". Available indexes are [0 - " + (size - 1) + "]");
        }

        E value = null;

        if (index == 0) {
            value = removeFirst();
        } else if (index == size - 1) {
            value = removeLast();
        } else {
            Node auxNode1 = getNode(index - 1);
            Node auxNode2 = auxNode1.next;
            auxNode1.next = auxNode2.next;
            auxNode1.next.previous = auxNode1;

            value = auxNode2.value;
            size--;
        }

        return value;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Linked List is Empty");
        }

        Node auxNode = head;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            auxNode.next = null;
        }
        size--;

        return auxNode.value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Linked List is Empty");
        }

        E value = tail.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node auxNode = getNode(size - 2);
            tail = auxNode;
            tail.next = null;
        }
        size--;
        return value;
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Linked List is Empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Illegal index " + index + ". Available indexes are [0 - " + (size - 1) + "]");
        }

        getNode(index).value = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node auxNode = head;
        while (auxNode != null) {
            sb.append(auxNode.value);
            if (auxNode.next != null) {
                sb.append(", ");
            }
            auxNode = auxNode.next;
        }
        return sb.append("]").toString();
    }

    public String inverseList() {
        StringBuilder sb = new StringBuilder("[");
        Node auxNode = tail;
        while (auxNode != null) {
            sb.append(auxNode.value);
            if (auxNode.previous != null) {
                sb.append(", ");
            }
            auxNode = auxNode.previous;
        }
        return sb.append("]").toString();
    }

    public boolean contains(E value) {
        Node auxNode = new Node(value);

        for (int i = 0; i < size ; i++) {
            auxNode = auxNode.next;
            if (auxNode.next == value) {
                return true;
            }
        }
        return false;
    }
}

class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage) {
        super(errorMessage);
    }
}

class FullListException extends RuntimeException {
    public FullListException(String errorMessage) {
        super(errorMessage);
    }
}
