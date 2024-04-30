package collections;

public class HashTable<K,V> implements Map<K,V> {

    private int size;
    private Node<Entry<K,V>>[] hashTable;

    public HashTable(int mapSize) {
        hashTable = new Node[mapSize];
    }

    @Override
    public Entry<K, V> delete(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry<K, V> get(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void put(K key, V value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        
        for (int i = 0; i < hashTable.length; i++) {
            sb.append(i);
            sb.append(":");

            sb.append("\n");
        }

        return sb.toString();
    }
    
}
