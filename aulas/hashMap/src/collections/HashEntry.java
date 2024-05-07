package collections;

public class HashEntry<K,V> implements Entry<K,V> {

    private K key;
    private V value;

    public hashEntry(K key, V Value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public void setValue(V value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "{" + ":" + "}";
    }
}
