package collections;

public class DynamicStack<E> implements Stack<E>{
    
    class Node {
        E value;
        Node next;

        public Node (E value) {
            this.value = value;
        }

        private Node top;
        private int height;
    }
    
    @Override
    public int height() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void push(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E top() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
