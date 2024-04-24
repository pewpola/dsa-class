package collections;

public class Heap<K,V> extends AbstractHeap<K,V> {

    @Override
    public void insert(K key, V value) {
        Entry<K,V> newEntry = new HeapEntry(key, value);
        heap.add(newEntry);

        int current = size() - 1;
        int parent = parent(current);

        while(current > 0 && compare(current, parent) == -1) {
            swap(current, parent);
            current = parent;
            parent = parent(current);
        }
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
