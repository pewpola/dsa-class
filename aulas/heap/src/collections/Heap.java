package collections;

public class Heap<K,V> extends AbstractHeap<K,V> {

    @Override
    public void insert(K key, V value) {
        
    }

    private void swap(int index1, int index2) {
        Entry<K,V> auxEntry = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, auxEntry);
    }
    
    private int parent(int child) {
        return (child - 1) / 2;
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
        return null;
    }
}
