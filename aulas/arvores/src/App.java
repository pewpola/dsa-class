// import collections.AVLTree;
import collections.RecursiveBinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
        // AVLTree<Integer> avl = new AVLTree<>();
        RecursiveBinarySearchTree<Integer> bst = new RecursiveBinarySearchTree<>();
        
        bst.insert(44);
        bst.insert(25);
        bst.insert(22);
        bst.insert(89);
        bst.insert(33);
        bst.insert(98);
        bst.insert(29);
        bst.treeTraversal();
        bst.delete(33);
        bst.treeTraversal();
        // System.out.println(avl);
        // System.out.println(avl.height());
        // System.out.println(avl.contains(37));
        // System.out.println(avl.contains(25));
        }
}