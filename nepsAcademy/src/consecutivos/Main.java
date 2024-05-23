package consecutivos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            list.add(v);
        }

        // System.out.println(list);
        System.out.println(list.consecutiveCounter(n, list));    

        sc.close();
    }
}

class DoublyLinkedList<E> {

    private class Node {
        E value;
        Node next;
        Node previous;

        private Node(E value) {
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

    public boolean contains(E value) {
        Node auxNode = head;

        for (int i = 0; i < size; i++) {
            if (auxNode.value.equals(value)) {
                return true;
            }
            auxNode = auxNode.next;
        }
        return false;
    }

    public int consecutiveCounter(int n, DoublyLinkedList<Integer> list) {
        int maxSequence = 1;
        int actualSequence = 1;
        Node auxNode = head;

        for (int i = 1; i < n; i++) {
            if (auxNode.value.equals(auxNode.next.value)) {
                actualSequence += 1;
            } else {
                if (actualSequence > maxSequence) {
                    maxSequence = actualSequence;
                }
                actualSequence = 1;
            }
            auxNode = auxNode.next;
        }

        if (actualSequence > maxSequence) {
            maxSequence = actualSequence;
        }

        return maxSequence;
    }

    public void add(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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