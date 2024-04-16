package collections;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

    class PriorityQueueEntry implements Entry<K,V> {
        K key;
        V value;
        
        public PriorityQueueEntry(K key, V value) {
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
        
    }

    class Node {
        Node next;
        Node previous;
        Entry<K,V> entry;

        public Node(Entry<K,V> entry) {
            this.entry = entry;
        }

        public Node(K key, V value) {
            entry = new PriorityQueueEntry(key, value);
        }
    }

    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
}
