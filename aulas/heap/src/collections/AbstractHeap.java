package collections;

import entities.List;
import entities.StaticList;

public class AbstractHeap<K,V> implements PriorityQueue<K,V> {

    K key;
    V value;

    public AbstractHeap(K key, V value) {
        this.key = key;
        this.value = value;
    }

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

    protected List<Entry<K,V>> heap;

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public String toString() {
        return "(" + key + ":" + value + ")";
    }
    
}
