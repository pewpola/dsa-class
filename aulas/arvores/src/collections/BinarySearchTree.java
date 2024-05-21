package collections;

public class BinarySearchTree<E> extends AbstractTree<E> {

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
