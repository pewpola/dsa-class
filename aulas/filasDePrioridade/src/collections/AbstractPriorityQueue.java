package collections;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    class PriorityQueueEntry implements Entry<K,V> {
        K key;
        V value;
        
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
        
    }

    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
}
