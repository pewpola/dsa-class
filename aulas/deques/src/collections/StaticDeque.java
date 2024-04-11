package collections;

public class StaticDeque<E> implements Deque<E> {
    private int size;
    private E[] queue;
    private int first;

    @SuppressWarnings("unchecked")
    public StaticDeque(int maxSize) {
        queue = (E[]) new Object[maxSize];
    }

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
