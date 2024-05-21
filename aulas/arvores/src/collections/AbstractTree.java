package collections;

import java.util.*;

public class AbstractTree<E> implements Tree<E> {

    class Node {
        E value;
        Node left;
        Node right;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value = " + value;
        }
    }

    protected Node root;
    protected int size;
    protected Comparator<E> comparator;

    public AbstractTree() {
        comparator = new DefaultComparator<>();
    }

    public int compare(Node n1, Node n2) {
        return comparator.compare(n1.value, n2.value);
    }

    @Override
    public boolean contains(E value) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E delete(E value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(E value) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void treeTraversal() {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "BinarySearchTree []";
    }

}
