package collections;

public class Node<E> {
    E entry;
    Node<E> next;
    Node<E> previous;

    public Node(E entry) {
        this.entry = entry;
    }
}
