package collections;

public class SortedPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    @Override
    public void insert(K key, V value) {
        Node newNode = new Node(key, value);
        
        if (isEmpty() || ((Comparable<E>) key).compareTo(first.key) <= 0) {
            newNode.next = first;

            if (first != null) {
                first.previous = newNode;
            }

            first = newNode;
        } else {
            Node current = first;

            while (current.next != null && ((Comparable<E>) value).compareTo(current.next.key) > 0) {
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
