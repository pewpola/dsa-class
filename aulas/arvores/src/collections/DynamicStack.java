package collections;

public class DynamicStack<E> implements Stack<E> {

    class Node {
        E value;
        Node next;

        public Node(E value) {
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
        return top == null;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        E value = top.value;
        top = top.next;
        height--;
        return value;
    }

    @Override
    public void push(E value) {
        Node newNode = new Node(value);
        if (!isEmpty()) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return top.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Node auxNode = top;
        while (auxNode != null) {
            sb.append(auxNode.value);
            sb.append("\n");
            auxNode = auxNode.next;
        }
        return sb.toString();
    }

}
