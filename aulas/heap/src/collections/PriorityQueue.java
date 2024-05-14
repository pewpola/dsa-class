package collections;

public interface PriorityQueue<K,V> {
    void insert(K key, V value);
    Entry<K,V> maxPriority();
    Entry<K,V> remove();
    int size();
    boolean isEmpty();
    boolean contains(V value);
    boolean containsByKey(K key);
    boolean containsByEntry(K key, V value);
    void updateValue(K key, V value, V newValue);
}