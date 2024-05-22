import collections.BinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        
        bst.insert(50);
        bst.insert(1442);
        bst.insert(21);
        bst.insert(80);
        System.out.println(bst.contains(80));
        System.out.println(bst);
    }
}
