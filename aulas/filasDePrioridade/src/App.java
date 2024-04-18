import collections.SortedPriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        SortedPriorityQueue<Integer, String> queue = new SortedPriorityQueue<>();
        queue.insert(3, "Ian");
        queue.insert(2, "Leone");
        queue.insert(0, "Anna");
        queue.insert(4, "Eduardo");
        queue.insert(0, "Nathan");
        queue.insert(3, "Davi");
        System.out.println(queue);
    }
}
