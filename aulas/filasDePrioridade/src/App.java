import collections.UnsortedPriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        UnsortedPriorityQueue<Integer, String> queue = new UnsortedPriorityQueue<>();
        queue.insert(3, "Ian");
        queue.insert(2, "Leone");
        queue.insert(0, "Anna");
        queue.insert(4, "Eduardo");
        queue.insert(0, "Nathan");
        queue.insert(3, "Davi");
        queue.remove();
        System.out.println(queue.maxPriority());
    }
}
