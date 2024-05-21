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

    @Override
    public E delete(E value) {
        // TODO Auto-generated method stub
        return super.delete(value);
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
    
}
