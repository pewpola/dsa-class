package collections;

import java.util.Comparator;

import entities.ArrayList;
import entities.DefaultComparator;
import entities.List;
import entities.StaticList;

public class AbstractHeap<K,V> implements PriorityQueue<K,V> {

    class HeapEntry implements Entry<K,V> {

        K key;
        V value;        

        public HeapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ":" + value + ")";
        }
    }

    protected List<Entry<K,V>> heap;
    private Comparator<K> comparator;

    @Override
    public void insert(K key, V value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Entry<K, V> maxPriority() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry<K, V> remove() {
        // TODO Auto-generated method stub
        return null;
    }

    public AbstractHeap() {
        heap = new ArrayList<>();
        comparator = new DefaultComparator<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    public int compare(int index1, int index2) {
        return compare(heap.get(index1), heap.get(index2));
    }

    public int compare(Entry<K,V> e1, Entry<K,V> e2) {
        return comparator.compare(e1.getKey(), e2.getKey());
    }

    @Override
    public String toString() {
        return "(" + key + ":" + value + ")";
    }
    
}
