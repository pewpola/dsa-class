package collections;

public class Heap<K,V> extends AbstractHeap<K,V> {

    @Override
    public void insert(K key, V value) {
        
    }

    @Override
    public Entry<K, V> maxPriority() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty!");
        }

        return heap.get(0);
    }

    private int parent(int child) {
        return (child - 1) / 2;
    }

    @Override
    public Entry<K, V> remove() {
        return null;
    }
}
