package filaDoRecreio;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(scanner.nextLine());
            String[] testLines = scanner.nextLine().split(" ");
            PriorityQueue<Integer, Integer> queue = new HeapPriorityQueue<Integer, Integer>(M);
            int counter = 0;
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(testLines[j]);
                queue.insert(value, value);

            }

            for (int j = 0; j < M; j++) {
                Integer comparedValue = Integer.parseInt(testLines[j]);
                if (queue.remove().getKey().compareTo(comparedValue) == 0) {
                    counter++;
                }
            }
            System.out.println(counter);

        }
        scanner.close();
    }
}

class DefaultComparator<Key> implements Comparator<Key> {

    @SuppressWarnings("unchecked")
    @Override
    public int compare(Key keyA, Key keyB) {

        return ((Comparable<Key>) keyA).compareTo(keyB);
    }

}

interface Entry<Key, Value> {
    Key getKey();

    Value getValue();
}

interface PriorityQueue<Key, Value> {
    void insert(Key key, Value value);

    Entry<Key, Value> top();

    Entry<Key, Value> remove();

    int size();

    boolean isEmpty();
}

class HeapPriorityQueue<Key, Value> implements PriorityQueue<Key, Value> {

    class QueueEntry implements Entry<Key, Value> {
        Key key;
        Value value;

        public QueueEntry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Key getKey() {
            return this.key;
        }

        @Override
        public Value getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return "(" + key + " - " + value + ")";
        }

    }

    private Comparator<Key> comparator;
    protected int size;
    protected Entry<Key, Value>[] heap;

    @SuppressWarnings("unchecked")
    public HeapPriorityQueue(int capacity) {
        this.comparator = new DefaultComparator<>();
        this.heap = (Entry<Key, Value>[]) new Entry[capacity];
        this.size = 0;

    }

    @Override
    public void insert(Key key, Value value) {
        if (isFull())
            throw new Error("Queue is full");
        Entry<Key, Value> newEntry = new QueueEntry(key, value);
        int index = size();
        heap[index] = newEntry;
        this.size++;
        while (index != 0 && comparator.compare(heap[index].getKey(), heap[parent(index)].getKey()) > 0) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    @Override
    public Entry<Key, Value> top() {
        if (isEmpty())
            throw new Error("Empty queue");
        return heap[0];
    }

    public Entry<Key, Value> remove() {
        if (isEmpty())
            throw new Error("Empty queue");

        Entry<Key, Value> root = heap[0];
        heap[0] = heap[size() - 1];
        this.size--;
        maxHeapify(0);
        return root;
    }

    private void maxHeapify(int index) {
        int largest = index;
        int leftChildPosition = leftChild(index);
        int rightChildPosition = rightChild(index);

        if (leftChildPosition < size() &&
                comparator.compare(heap[leftChildPosition].getKey(), heap[largest].getKey()) > 0) {
            largest = leftChildPosition;
        }
        if (rightChildPosition < size() &&
                comparator.compare(heap[rightChildPosition].getKey(), heap[largest].getKey()) > 0) {
            largest = rightChildPosition;
        }

        if (largest != index) {
            swap(index, largest);
            maxHeapify(largest);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return this.heap.length == size();
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        Entry<Key, Value> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < size(); i++) {
            if (i == size() - 1) {
                s.append(heap[i]);
            } else {
                s.append(heap[i]);
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}
