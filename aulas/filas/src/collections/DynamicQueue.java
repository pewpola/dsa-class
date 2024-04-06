package collections;

public class DynamicQueue<E> implements Queue<E> {

    class Node {
        E value;
        Node next;

        public Node (E value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
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
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
}
