package filaDoSupermercado;

import java.util.*;

public class Main {
    
}

class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    @Override
    public void insert(K key, V value) {
        Node newNode = new Node(key, value);

        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        size++;
    }

    private Node findMaxPriorityNode() {
        Node minNode = last;
        Node auxNode = last.previous;

        while (auxNode != null) {
            int comp = compare(auxNode.entry, minNode.entry);
            if (comp <= 0) {
                minNode = auxNode;
            }
            auxNode = auxNode.previous;
        }

        return null;
    }

    @Override
    public Entry<K, V> maxPriority() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }

        return findMaxPriorityNode().entry;
    }

    @Override
    public Entry<K, V> remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        
        Node maxPriorityNode = findMaxPriorityNode();

        if (size == 1) {
            first = null;
            last = null;    
        } else {
            if (maxPriorityNode == first) {
                first = first.next;
                first.previous = null;
            } else if (maxPriorityNode == last) {
                last = last.previous;
                last.next = null;
            } else {
                maxPriorityNode.next.previous = maxPriorityNode.previous;
                maxPriorityNode.previous.next = maxPriorityNode.next;
            }
        }

        size--;

        return maxPriorityNode.entry;
    }
}

class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    @Override
    @SuppressWarnings("unchecked")
    public void insert(K key, V value) {
        Node newNode = new Node(key, value);
        
        if (isEmpty() || ((Comparable<K>) key).compareTo(first.entry.getKey()) < 0) {
            newNode.next = first;

            if (first != null) {
                first.previous = newNode;
            }

            first = newNode;
        } else {
            Node current = first;

            while (current.next != null && ((Comparable<K>) key).compareTo(current.next.entry.getKey()) >= 0) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.previous = current;
            current.next = newNode;

            if (newNode.next != null) {
                newNode.next.previous = newNode;
            }
        }

        if (newNode.next == null) {
            last = newNode;
        }

        size++;        
    }

    @Override
    public Entry<K, V> maxPriority() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        
        return first.entry;
    }

    @Override
    public Entry<K, V> remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }

        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }

        return first.entry;
    }
}

interface Entry<K,V> {
    K getKey();
    V getValue();
}

interface PriorityQueue<K,V> {
    void insert(K key, V value);
    Entry<K,V> maxPriority();
    Entry<K,V> remove();
    int size();
    boolean isEmpty();
}

class DefaultComparator<K> implements Comparator<K> {

    @Override
    @SuppressWarnings("unchecked")
    public int compare(K o1, K o2) {
        return ((Comparable<K>)o1).compareTo(o2);
    }
    
}

abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V> {

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