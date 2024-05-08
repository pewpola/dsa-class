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

        // queue.getNodeByValue(2);

        // System.out.println(queue);

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            queue.dequeueByValue(r);
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
        Node previous;

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
    
    public Node getNodeByValue(E value) {
        Node auxNode = head;
        
        while (auxNode.next != null && !auxNode.value.equals(value)) {
            auxNode = auxNode.next;
        }
        
        return auxNode;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Linked List is Empty");
        }

        E value = head.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
        return value;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new EmptyQueueException("Linked List is Empty");
        }

        E value = tail.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }

        size--;

        return value;
    }

    public E dequeueByValue(E value) {
        if (isEmpty()) {
            throw new EmptyQueueException("Linked List is Empty");
        }

        Node auxNode = getNodeByValue(value);

        if (auxNode == null) throw new IllegalArgumentException("Value not found in the queue");

        if (auxNode == head) {
            dequeue();
        } else if (auxNode == tail) {
            removeLast();
        } else {
            auxNode.previous.next = auxNode.next;
            auxNode.next.previous = auxNode.previous;

            size--;
        }

        return auxNode.value;
    }

    @Override
    public void enqueue(E value) {
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