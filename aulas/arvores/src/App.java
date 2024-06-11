import collections.AVLTree;

public class App {
    public static void main(String[] args) throws Exception {
        AVLTree<Integer> avl = new AVLTree<>();

        avl.insert(37);
        avl.insert(25);
        System.out.println(avl);
        System.out.println(avl.height());
        System.out.println(avl.contains(37));
        System.out.println(avl.contains(25));
        // bst.insert(60);
        // bst.insert(30);
        // bst.insert(90);
        // bst.insert(5);
        // bst.insert(45);
        // bst.insert(85);
        // bst.insert(150);
        // bst.insert(43);
        // bst.insert(70);
        // bst.insert(87);
        // bst.insert(100);
        // bst.insert(200);
    }
}