package collections;

public class HashEntry<K,V> implements Entry<K,V> {

    private K key;
    private V value;

    @Override
    public K getKey() {
        return key;
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
