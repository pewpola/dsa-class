package collections;

public class AVLTree<E> extends AbstractTree<E> {

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private int height(Node current) {
        if (current == null) {
            return 0;
        }

        return 1 + max(height(current.left), height(current.right));
    }

    public int height () {
        return height(root);
    }
    
    @Override
    public boolean contains(E value) {
        // TODO Auto-generated method stub
        return super.contains(value);
    }

    @Override
    public E delete(E value) {
        // TODO Auto-generated method stub
        return super.delete(value);
    }

    private Node insert(E value, Node current) {
        if (current == null) {
            size++;
            return new Node(value);
        }
        
        if (compare(value, current) < 0) {
            current.left = insert(value, current.left);
        } else if (compare(value, current) > 0) {
            current.right = insert(value, current.right);
        }
        
        return current;
    }
    
    @Override
    public void insert(E value) {
        root = insert(value, root);
    }
    
}
