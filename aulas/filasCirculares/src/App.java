import collections.CircularLinkedQueue;

public class App {
    public static void main(String[] args) throws Exception {
        CircularLinkedQueue<Integer> queue = new CircularLinkedQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);

        System.out.println(queue);
    }
}
