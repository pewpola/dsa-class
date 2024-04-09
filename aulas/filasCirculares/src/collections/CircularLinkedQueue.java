package collections;

public class CircularLinkedQueue<E> implements Queue<E> {

    class Node {
        E value;
        Node next;
        
        public Node(E value) {
            this.value = value;
        }
    }

    private Node first;
    private int size;

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void enqueue(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E first() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
       
}
