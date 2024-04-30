package collections;

public interface Map<K,V> {
    void put(K key, V value);
    Entry<K,V> get(K key);
    Entry<K,V> delete(K key);
    int size();
    boolean isEmpty();
}
