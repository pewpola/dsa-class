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
    }

    protected Node root;
    protected int size;
    protected Comparator<E> comparator;

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
        if (root == null) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void treeTraversal() {
        // TODO Auto-generated method stub

    }

}
