package collections;

public class HashTable<K,V> implements Map<K,V> {

    private int size;
    private Node<Entry<K,V>>[] hashTable;

    public HashTable(int mapSize) {
        hashTable = new Node[mapSize];
    }

    public static int hashCode(String key) {
        int hashCode = 0;
        int a = 5;

        for (int i = 0; i < key.length(); i++) {
            hashCode = hashCode << a | hashCode >>> (32 - a);
            hashCode += key.charAt(i);
        }

        return hashCode;
    }

    public int compression(int hashCode) {
        int comp = hashCode % hashTable.length;

        if (comp < 0) {
            comp *= -1;
        }

        return comp;
    }

    public int hashFunction(K key) {
        if (key instanceof String) {
            return compression(hashCode((String) key));
        }

        throw new RuntimeException("Hash Function does not support that data type");
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
        return size == 0;
    }

    @Override
    public void put(K key, V value) {
        int index = hashFunction(key);
        Entry<K,V> entry = new HashEntry<>(key, value);
        Node<Entry<K,V>> newNode = new Node(entry);

        if(hashTable[index] == null) {
            hashTable[index] = newNode;
        } else {
            Node<Entry<K,V>> auxNode = hashTable[index];
          
            while(auxNode!=null) {
                if(auxNode.entry.getKey().equals(key)){
                    auxNode.entry.setValue(value);
                    return;
                }

                auxNode = auxNode.next;
            }

            newNode.next = hashTable[index];
            hashTable[index].previous = newNode;
            hashTable[index] = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < hashTable.length; i++) {
            sb.append(i);
            sb.append(":");

            Node<Entry<K,V>> auxNode = hashTable[i];
            while(auxNode!=null) {
                sb.append("\n    ");
                sb.append(auxNode.entry);

                auxNode = auxNode.next;
            }

            sb.append("\n");
        }

        return sb.toString();
    }    
}
