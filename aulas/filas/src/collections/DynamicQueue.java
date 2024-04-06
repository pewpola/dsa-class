package collections;

import exceptions.EmptyQueueException;

public class DynamicQueue<E> implements Queue<E> {

    class Node {
        E value;
        Node next;

        public Node(E value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Node getNode(int index) {
        Node auxNode = head;

        for (int i = 0; i < index; i++) {
            auxNode = auxNode.next;
        }

        return auxNode;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Linked List is Empty");
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
    public void enqueue(E value) {
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

    @Override
    public E first() {
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        Node auxNode = head;

        while (auxNode != null) {
            sb.append(auxNode.value);
            sb.append(" ");
            auxNode = auxNode.next;
        }

        return sb.toString();
    }

}
