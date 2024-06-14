// import collections.AVLTree;
import collections.RecursiveBinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
        // AVLTree<Integer> avl = new AVLTree<>();
        RecursiveBinarySearchTree<Integer> bst = new RecursiveBinarySearchTree<>();
        
        // bst.insert(47);
        // bst.insert(30);
        // bst.insert(89);
        // bst.insert(8);
        // bst.insert(38);
        // bst.insert(5);
        // bst.insert(61);
        // bst.insert(100);
        bst.insert(5);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.treeTraversal();
        // bst.treeTraversal("inOrder");
        // bst.treeTraversal("postOrder");
        // bst.treeTraversal();
        // System.out.println(avl);
        // System.out.println(avl.height());
        // System.out.println(avl.contains(37));
        // System.out.println(avl.contains(25));
        }
}