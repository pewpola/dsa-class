package arvoreBinariaDeBusca;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {
            int n = sc.nextInt();
            
            String[] linha = sc.next().split(" ");
            RecursiveBinarySearchTree<Integer> bst = new RecursiveBinarySearchTree<Integer>();
            for (int j = 0; j < n; j++) {
                bst.insert(Integer.parseInt(linha[j]));
            }
            System.out.println("Case " + (Integer.toString(i + 1)) + ":");
            System.out.print("Pre.: ");
            bst.treeTraversal();
            System.out.println();
            System.out.print("In..: ");
            bst.treeTraversal("inOrder");
            System.out.println();
            System.out.print("Post: ");
            bst.treeTraversal("postOrder");
            System.out.println();
        }
        sc.close();
    }
}

class RecursiveBinarySearchTree<E> extends AbstractTree<E> {

    private Node contains(E value, Node current) {
        if (current == null) {
            return null;
        }

        if (compare(value, current) < 0) {
            current = contains(value, current.left);
        } else if (compare(value, current) > 0) {
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
            current.right = delete(value, current.right);
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
        int previousSize = size;
        root = delete(value, root);
        if (previousSize != size) {
            return value;
        }
        return null;
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

    private void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.value + " ");
            preOrder(current.left);
            preOrder(current.right);

        }
    }

    private void postOrder(Node current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.value + " ");

        }
    }

    private void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(current.value + " ");
            inOrder(current.right);
        }
    }

    public void treeTraversal(String type) {
        if (type.equals("inOrder")) {
            inOrder(root);
        } else if (type.equals("postOrder")) {
            postOrder(root);
        } else {
            treeTraversal();
        }
    }

    @Override
    public void insert(E value) {
        root = insert(value, root);
    }

    @Override
    public void treeTraversal() {
        preOrder(root);

    }

    @Override
    public String toString() {
        return "RecursiveBinarySearchTree []";
    }
}

class DefaultComparator<T> implements Comparator<T> {

    @Override
    @SuppressWarnings("unchecked")
    public int compare(T o1, T o2) {
        return ((Comparable<T>) o1).compareTo(o2);
    }
}

interface Tree<E> {
    void insert(E value);
    E delete(E value);
    boolean contains(E value);
    boolean isEmpty();
    int size();
    void treeTraversal();
}

abstract class AbstractTree<E> implements Tree<E> {

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

