package fila;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DynamicQueue<Integer> queue = new DynamicQueue<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            queue.enqueue(p);
        }

        System.out.println(queue);
        sc.close();
    }
}


interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    E first();
    int size();
    boolean isEmpty();
}

class DynamicQueue<E> implements Queue<E> {

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
        } else {
            tail.next = newNode;
        }        
        tail = newNode;
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

class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String error) {
        super(error);
    }
}