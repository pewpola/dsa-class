import collections.DynamicQueue;

public class App {
    public static void main(String[] args) throws Exception {
        DynamicQueue<Integer> queue = new DynamicQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
    }
}
