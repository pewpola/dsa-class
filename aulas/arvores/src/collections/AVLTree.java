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

    private Node rightRotation(Node x) {
        Node y = x.left;
        Node T2 = y.right;
        y.right = x;
        x.left = T2;

        return y;
    }

    private Node leftRotation(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        
        return y;
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
        
        int diff1 = height(current.right) - height(current.left);

        if (diff1 > 1) {
            System.out.println("Desbalanceada - Direita");
            int diff2 = height(current.right.right) - height(current.right.left);

            if (diff2 == 0 || diff2 == 1) {
                System.out.println("Rotação esquerda!");
                current = leftRotation(current);
            } else {
                System.out.println("Rotação direita do filho e rotação esquerda!");
                current.right = rightRotation(current.right);
                current = leftRotation(current);
            }
        } else if (diff1 < -1) {
            System.out.println("Desbalanceada - Esquerda");
            int diff2 = height(current.right.right) - height(current.right.left);

            if (diff2 == 0 || diff2 == -1) {
                System.out.println("Rotação direita!");
                current = rightRotation(current);
            } else {
                System.out.println("Rotação esquerda do filho e rotação direita!");
                current.left = leftRotation(current.left);
                current = rightRotation(current);
            }

        }

        return current;
    }
    
    @Override
    public void insert(E value) {
        root = insert(value, root);
    }

    private StringBuilder preOrder(StringBuilder sb, Node current) {
        if (current != null) {
            sb.append(current.value + " ");
            preOrder(sb, current.left);
            preOrder(sb, current.right);
        }

        return sb;
    }

    @Override
    public String toString() {
        return "";
    }
    
}
