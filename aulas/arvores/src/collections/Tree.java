package collections;

public interface Tree<E> {
    void insert(E value);
    E delete(E value);
    boolean contains(E value);
    boolean isEmpty();
    int size();
    void treeTraversal();
}