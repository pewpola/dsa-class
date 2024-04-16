package collections;

import java.util.Comparator;

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

        @Override
        public String toString() {
            return "(" + key + " - " + value + ")";
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

    private Comparator<K> comparator;
    protected int size;
    protected Node first;
    protected Node last;

    public AbstractPriorityQueue() {
        comparator = new DefaultComparator<>();
    }

    public int compare(Entry<K,V> e1, Entry<K,V> e2) {
        return comparator.compare(e1.getKey(), e2.getKey());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node auxNode = first;
        while (auxNode != null) {
            sb.append(auxNode.entry);
            if (auxNode.next != null) {
                sb.append(", ");
            }
            auxNode = auxNode.next;
        }
        return sb.append("]").toString();
    }
}
