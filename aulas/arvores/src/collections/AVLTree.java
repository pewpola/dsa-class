package collections;

public class AVLTree<E> extends AbstractTree<E> {

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private void updateHeight(Node current) {
        current.height = 1 + max(height(current.left), height(current.right));
    }

    private int height(Node current) {
        if (current == null) {
            return 0;
        }
        return current.height;
    }
    
    private Node contains(E value, Node current) {
        if (current == null) {
            return null;
        }
        
        int cmp = compare(value, current);
        if (cmp < 0) {
            return contains(value, current.left);
        } else if (cmp > 0) {
            return contains(value, current.right);
        } else {
            return current;
        }
    }
    

    @Override
    public boolean contains(E value) {
        return contains(value, root) != null;
    }
    
    public int height() {
        return height(root);
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
                return current;
            } else if (current.left != null && current.right != null) {
                current.value = maxNode(current.left).value;
                current.left = delete(current.value, current.left);
            } else {
                size--;
                current = current.left != null ? current.left : current.right;
            }
        }
        if (current != null) {
            updateHeight(current);
            current = balance(current);
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

    private Node maxNode(Node current) {
        if (current.right == null) {
            return current;
        }

        return maxNode(current.right);
    }

    @Override
    public void insert(E value) {
        root = insert(value, root);
    }

    private Node rightRotation(Node x) {
        Node y = x.left;
        Node T2 = y.right;
        y.right = x;
        x.left = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node leftRotation(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node balance(Node current) {
        int difference1 = height(current.right) - height(current.left);
        if (difference1 > 1) {
            System.out.println("Desbalanceado - Direita");
            int difference2 = height(current.right.right) - height(current.right.left);
            if (difference2 == 0 || difference2 == 1) {
                current = leftRotation(current);
            } else {
                current.right = rightRotation(current.right);
                current = leftRotation(current);
            }

        } else if (difference1 < -1) {
            System.out.println("Desbalanceado - Esquerda");
            int difference2 = height(current.left.right) - height(current.left.left);
            if (difference2 == 0 || difference2 == -1) {
                current = rightRotation(current);
            } else {
                current.left = leftRotation(current.left);
                current = rightRotation(current);
            }
        }
        return current;
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
        // atualiza a altura
        updateHeight(current);
        current = balance(current);
        return current;
    }

    @Override
    public void treeTraversal() {
        // TODO Auto-generated method stub

    }

    private StringBuilder preOrder(StringBuilder sb, Node current) {
        if (current != null) {
            sb.append(current).append("\n");
            preOrder(sb, current.left);
            preOrder(sb, current.right);

        }
        return sb;
    }

    @Override
    public String toString() {
        return preOrder(new StringBuilder(), root).toString();
    }

}
