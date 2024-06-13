package lendaDeFlavious;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int NC = scanner.nextInt();

        for (int testCase = 1; testCase <= NC; testCase++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int lastMan = josephus(n, k);

            System.out.println("Case " + testCase + ": " + lastMan);
        }
        
        scanner.close();
    }

    public static int josephus(int n, int k) {
        CircularStaticQueue<Integer> soldiers = new CircularStaticQueue<>(n);

        for (int i = 1; i <= n; i++) {
            soldiers.enqueue(i);
        }

        while (soldiers.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                soldiers.enqueue(soldiers.dequeue());
            }
            soldiers.dequeue();
        }

        return soldiers.dequeue();
    }
}


interface Queue<E> {
    void enqueue(E value);
    E dequeue();
    E first();
    int size();
    boolean isEmpty();
}

class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String error) {
        super(error);
    }
}

class FullQueueException extends RuntimeException {
    public FullQueueException(String error) {
        super(error);
    }
}

class CircularStaticQueue<E> implements Queue<E> {

    private int size;
    private E[] queue;
    private int first;

    @SuppressWarnings("unchecked")
    public CircularStaticQueue(int maxSize) {
        queue = (E[]) new Object[maxSize];
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is Empty");
        }

        E value = first();
        queue[first] = null;
        first = (first + 1) % queue.length;
        size--;

        return value;
    }

    @Override
    public void enqueue(E value) {
        if (isFull()) {
            throw new FullQueueException("Queue is Full!");
        }

        queue[(first + size) % queue.length] = value;
        size++;
    }

    @Override
    public E first() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is Empty!");
        }
        return queue[first];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < size; i--) {
            sb.append(queue[(first + i) % queue.length]);
            
            if (i != size - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
