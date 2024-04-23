package collections;

public class Heap<K,V> extends AbstractHeap<K,V> {

    @Override
    public void insert(K key, V value) {
        // TODO Auto-generated method stub
        super.insert(key, value);
    }

    @Override
    public Entry<K, V> maxPriority() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty!");
        }

        return heap.get(0);
    }

    @Override
    public Entry<K, V> remove() {
        // TODO Auto-generated method stub
        return super.remove();
    }
    
}
