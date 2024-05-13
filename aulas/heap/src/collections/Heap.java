package collections;

public class Heap<K, V> extends AbstractHeap<K, V> {

    @Override
    public void insert(K key, V value) {
        Entry<K, V> newEntry = new HeapEntry(key, value);
        heap.add(newEntry);

        int current = size() - 1;
        int parent = parent(current);

        while (current > 0 && compare(current, parent) == -1) {
            swap(current, parent);
            current = parent;
            parent = parent(current);
        }
    }

    private void swap(int index1, int index2) {
        Entry<K, V> auxEntry = heap.get(index1);
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
    public boolean contains(V value) {
        for (int i = 0; i < size(); i++) {
            Entry<K, V> auxEntry = heap.get(i);
            if (auxEntry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByKey(K key) {
        for (int i = 0; i < size(); i++) {
            Entry<K, V> auxEntry = heap.get(i);
            if (auxEntry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByEntry(K key, V value) {
        for (int i = 0; i < size(); i++) {
            Entry<K, V> auxEntry = heap.get(i);
            if (auxEntry.getKey().equals(key) && auxEntry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateValue(K key, V value, V newValue) {
        for (int i = 0; i < heap.size(); i++) {
            Entry<K, V> currentEntry = heap.get(i);
            if (currentEntry.getKey().equals(key) && currentEntry.getValue().equals(value)) {
                heap.get(i).setValue(newValue);
            }
        }
    }

    @Override
    public Entry<K, V> remove() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }

        Entry<K, V> entry;

        if (size() == 1) {
            entry = heap.removeLast();
        } else {
            entry = maxPriority();
            heap.set(0, heap.removeLast());
            sinkDown();
        }

        return entry;
    }

    private int rightChild(int parent) {
        return leftChild(parent) + 1;
    }

    private int leftChild(int parent) {
        return parent * 2 + 1;
    }

    private void sinkDown() {
        int current, min = 0;
        int leftChild, rightChild;

        do {
            current = min;
            leftChild = leftChild(current);
            rightChild = rightChild(current);

            if (leftChild < size() && compare(leftChild, min) == -1) {
                min = leftChild;
            }

            if (rightChild < size() && compare(rightChild, min) == -1) {
                min = rightChild;
            }

            if (current != min) {
                swap(current, min);
            }

        } while (current != min);
    }
}
