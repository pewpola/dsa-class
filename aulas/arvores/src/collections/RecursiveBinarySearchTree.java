package collections;

public class RecursiveBinarySearchTree<E> extends AbstractTree<E> {

    private Node contains(E value, Node current) {
        if (current == null) {
            return null;
        }

        if (compare(value, current) == 0) {
            current = contains(value, current.left);
        } else if (compare(value, current) < 0) {
            current = contains(value, current.right);
        }

        return current;
    }

    @Override
    public boolean contains(E value) {
        return contains(value, root) != null;
    }

    private Node minNode(Node current) {
        if (current.left == null) {
            return current;
        }

        return minNode(current.left);
    }

    private Node delete(E value, Node current) {
        if (current == null) {
            return null;
        }

        if (compare(value, current) < 0) {
            current.left = delete(value, current.left);
        } else if (compare(value, current) > 0) {
            current.left = delete(value, current.right);
        } else {
            if (current.left == null && current.right == null) {
                size--;
                current = null;
            } else if (current.left != null && current.right != null) {
                current.value = minNode(current.right).value;
                current.right = delete(current.value, current.right);
            } else {
                size--;
                current = current.left != null ? current.left : current.right;
            }
        }

        return current;
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

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public void treeTraversal() {
        // TODO Auto-generated method stub
        super.treeTraversal();
    }

}
