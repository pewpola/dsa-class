import collections.StaticQueue;

public class App {
    public static void main(String[] args) throws Exception {
        StaticQueue<Integer> queue = new StaticQueue<>(10);

        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue);
        queue.enqueue(3);
        System.out.println(queue);
        queue.enqueue(4);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
