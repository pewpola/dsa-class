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
        heap.updateValue(29, "Ian LW", "Arthur Veras");
        System.out.println(heap);
        heap.updateValue(1, "Davi", "Diego Benevides");
        System.out.println(heap);
        // System.out.println(heap.contains("Ian LW"));
        // System.out.println(heap.contains("Eduardo"));
        // System.out.println(heap.contains("Davi"));
        // System.out.println(heap.containsByEntry(12, "Nathan"));
        // System.out.println(heap.containsByKey(100));
        // System.out.println(heap.maxPriority());
        // System.out.println("Removido: " + heap.remove());
        // System.out.println(heap);
        // System.out.println(heap.maxPriority());
    }
}
