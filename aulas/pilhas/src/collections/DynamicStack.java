package collections;

import exceptions.*;

public class DynamicStack<E> implements Stack<E>{
    
    class Node {
        E value;
        Node next;

        public Node (E value) {
            this.value = value;
        }
    }

    private Node top;
    private int height;

    @Override
    public int height() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        return height == 0;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is Empty!");
        }

        E value = top.value;
        top = top.next;
        
        return value;
    }

    @Override
    public void push(E value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        height++;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is Empty!");
        }

        return top.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        Node auxNode = top;

        while (auxNode != null) {
            sb.append(auxNode.value);

            if (auxNode == top) {
                sb.append(" <- top");
            }

            sb.append("\n");
            auxNode = auxNode.next;
        }

        return sb.toString();
    }
}
