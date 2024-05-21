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
                
            }
        }
    }

    @Override
    public void treeTraversal() {
        // TODO Auto-generated method stub
        super.treeTraversal();
    }
    
}
