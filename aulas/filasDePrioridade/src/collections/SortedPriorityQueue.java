package collections;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    @Override
    public void insert(K key, V value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Entry<K, V> maxPriority() {
        return first.entry;
    }

    @Override
    public Entry<K, V> remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }

        first = first.next;
        first.previous = null;

        return first.entry;
    }
}
