import collections.*;

public class App {
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer, String> heap = new Heap<>();
        heap.insert(5, "Leone");
        heap.insert(8, "Jardiana");
        heap.insert(6, "Anna");
        heap.insert(12, "Nathan");
        heap.insert(33, "Tales");
        heap.insert(29, "Ian LW");
        heap.insert(39, "Lucas");
        heap.insert(1, "Davi");

        System.out.println(heap);
    }
}
