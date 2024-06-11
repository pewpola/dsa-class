package collections;

import java.util.Comparator;

public abstract class AbstractTree<E> implements Tree<E> {

    class Node {
        Node left;
        Node right;
        int height;
        E value;

        public Node(E value) {
            this.value = value;
            height = 1;
        }

        @Override
        public String toString() {
            return "Value: " + value + " Height: " + height;
        }

    }

    protected Node root;
    protected int size;
    protected Comparator<E> comparator;

    public AbstractTree() {
        comparator = new DefaultComparator<>();
    }

    public int compare(E v1, E v2) {
        return comparator.compare(v1, v2);
    }

    public int compare(Node n1, Node n2) {
        return comparator.compare(n1.value, n2.value);
    }

    public int compare(E v1, Node n2) {
        return comparator.compare(v1, n2.value);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

}
