package collections;

public class UnsortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

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
