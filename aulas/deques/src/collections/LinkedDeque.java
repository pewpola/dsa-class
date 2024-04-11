package collections;

public class LinkedDeque<E> implements Deque<E> {

    class Node {
        E value;
        Node next;
        
        public Node(E value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;
    
    @Override
    public void add(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E first() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E last() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
