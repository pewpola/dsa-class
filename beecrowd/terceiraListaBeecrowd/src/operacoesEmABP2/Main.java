package operacoesEmABP2;

import java.util.Comparator;
import java.util.Scanner;

abstract class AbstractTree<E> implements Tree<E> {

    class Node {
        Node left;
        Node right;
        E value;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
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

class RecursiveBinarySearchTree<E> extends AbstractTree<E> {

    private Node contains(E value, Node current) {
        if (current == null) {
            return null;
        }

        if (compare(value, current) < 0) {
            return contains(value, current.left);
        } else if (compare(value, current) > 0) {
            return contains(value, current.right);
        }
        return current;
    }

    @Override
    public boolean contains(E value) {
        return contains(value, root) != null;
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

    private void preOrder(Node current, StringBuilder sb) {
        if (current != null) {
            sb.append(current.value).append(" ");
            preOrder(current.left, sb);
            preOrder(current.right, sb);
        }
    }

    private void postOrder(Node current, StringBuilder sb) {
        if (current != null) {
            postOrder(current.left, sb);
            postOrder(current.right, sb);
            sb.append(current.value).append(" ");
        }
    }

    private void inOrder(Node current, StringBuilder sb) {
        if (current != null) {
            inOrder(current.left, sb);
            sb.append(current.value).append(" ");
            inOrder(current.right, sb);
        }
    }

    @Override
    public void insert(E value) {
        root = insert(value, root);
    }

    public String getTraversal(String type) {
        StringBuilder sb = new StringBuilder();
        if (type.equals("inOrder")) {
            inOrder(root, sb);
        } else if (type.equals("postOrder")) {
            postOrder(root, sb);
        } else {
            preOrder(root, sb);
        }
        return sb.toString().trim();
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

    @Override
    public void treeTraversal() {
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

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RecursiveBinarySearchTree<Integer> bst = new RecursiveBinarySearchTree<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.startsWith("I ")) {
                int element = Integer.parseInt(line.substring(2));
                bst.insert(element);
            } else if (line.equals("INFIXA")) {
                System.out.println(bst.getTraversal("inOrder"));
            } else if (line.equals("PREFIXA")) {
                System.out.println(bst.getTraversal("preOrder"));
            } else if (line.equals("POSFIXA")) {
                System.out.println(bst.getTraversal("postOrder"));
            } else if (line.startsWith("P ")) {
                int element = Integer.parseInt(line.substring(2));
                if (bst.contains(element)) {
                    System.out.println(element + " existe");
                } else {
                    System.out.println(element + " nao existe");
                }
            } else if (line.startsWith("R ")) {
                int element = Integer.parseInt(line.substring(2));
                bst.delete(element);
            }
        }
        sc.close();
    }
}