import collections.CircularStaticQueue;

public class App {
    public static void main(String[] args) throws Exception {
        CircularStaticQueue<Integer> queue = new CircularStaticQueue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
    }
}
