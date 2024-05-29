package collections;

public class BinarySearchTree<E> extends AbstractTree<E> {

    private Node getNodeByValue(E value) {
        if (isEmpty()) {
            throw new RuntimeException("Tree is empty");
        }

        Node auxNode = root;

        while (auxNode != null) {
            if (compare(value, auxNode) == 0) {
                return auxNode;
            } else if (compare(value, auxNode) > 0) {
                auxNode = auxNode.right;
            } else {
                auxNode = auxNode.left;
            }
        }

        return null;
    }

    @Override
    public boolean contains(E value) {
        return getNodeByValue(value) != null;
    }

    private E removeMinNode(Node parent) {
        Node minNode = parent.right;

        while (minNode.left != null) {
            parent = minNode;
            minNode = minNode.left;
        }

        if (minNode.right != null) {
            if (parent.left == minNode) {
                parent.left = minNode.right;
            } else {
                parent.right = minNode.right;
            }
        } else {
            if (parent.left == minNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        
        return minNode.value;
    }

    @Override
    public E delete(E value) {
        if (isEmpty()) {
            throw new RuntimeException("Tree is empty");
        }

        Node parent = null;
        Node target = root;

        while (target != null && compare(value, target) != 0) {
            parent = target;
            if (compare(value, target) > 0) {
                parent = target;
                target = target.right;
            } else {
                target = target.left;
            }
        }

        if (target == null) {
            return null;
        }

        if (target.left == null && target.right == null) {
            // folha
            if (target == root) {
                root = null;
            } else {
                if (parent.left == target) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (target.left != null && target.right != null) {
            target.value = removeMinNode(target);
        } else {
            // tem um filho
            Node child = target.left != null ? target.left : target.right;

            if (target == root) {
                root = child;
            } else {
                if (parent.left == target) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }
        size--;
        return target.value;

    }

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            root = newNode;
        } else {
            Node auxNode = root;

            while (true) {
                if (compare(newNode, auxNode) == 0) {
                    return;
                } else if (compare(newNode, auxNode) > 0) {
                    if (auxNode.right == null) {
                        auxNode.right = newNode;
                        break;
                    }
                    auxNode = auxNode.right;
                } else {
                    if (auxNode.left == null) {
                        auxNode.left = newNode;
                        break;
                    }
                    auxNode = auxNode.left;
                }
            }
        }

        size++;
    }

    @Override
    public void treeTraversal() {
        // TODO Auto-generated method stub
        super.treeTraversal();
    }

    @Override
    public String toString() {
        return "BinarySeachTree []";
    }
}
