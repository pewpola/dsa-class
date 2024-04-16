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
            /*
            if (auxNode.entry.getKey() <= minNode.entry.getKey()) {
                minNode = auxNode;
            }
            */
            auxNode = auxNode.previous;
        }

        return null;
    }

    @Override
    public Entry<K, V> maxPriority() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Entry<K, V> remove() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
