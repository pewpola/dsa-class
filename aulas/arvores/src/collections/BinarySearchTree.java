package collections;

public class BinarySearchTree<E> extends AbstractTree<E> {

    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(E value) {
        // TODO Auto-generated method stub
        return false;
    }

    private E removeMinNode(Node parent) {
        Node minNode = parent.right;
        while (minNode.left != null) {
            parent = minNode;
            minNode = minNode.left;
        }

        if (minNode.right != null) {
            if (parent.left == minNode) {
                parent.left = minNode.right;
            } else {
                parent.right = minNode.right;
            }
        } else {
            if (parent.left == minNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        return minNode.value;
    }

    @Override
    public E delete(E value) {
        if (isEmpty()) {
            throw new RuntimeException("Tree is empty!");
        }
        Node target = root, parent = null;

        // buscar o nó
        while (target != null && compare(value, target) != 0) {
            parent = target;
            if (compare(value, target) > 0) {
                target = target.right;
            } else {
                target = target.left;
            }
        }

        if (target == null) {
            return null;
        }

        if (target.left == null && target.right == null) {
            if (target == root) {
                root = null;
            } else {
                if (parent.left == target) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (target.left != null && target.right != null) {
            target.value = removeMinNode(target);
        } else {
            Node child = target.left != null ? target.left : target.right;

            if (target == root) {
                root = child;
            } else {
                if (parent.left == target) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }
        size--;
        return target.value;
    }

    public E get(E value) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node auxNode = root;
            while (true) {
                if (compare(newNode, auxNode) < 0) {
                    if (auxNode.left == null) {
                        auxNode.left = newNode;
                        break;
                    }
                    auxNode = auxNode.left;
                } else if (compare(newNode, auxNode) > 0) {
                    if (auxNode.right == null) {
                        auxNode.right = newNode;
                        break;
                    }
                    auxNode = auxNode.right;
                } else {
                    return;
                }
            }
        }
        size++;
    }

    private void preOrder() {
        Queue<Node> queue = new DynamicQueue<>();
        if (root != null) {
            queue.enqueue(root);
        }

        while (queue.size() != 0) {
            Node current = queue.dequeue();

            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.enqueue(current.left);
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }

    private void postOrder() {
        Queue<Node> queue = new DynamicQueue<>();
        if (root != null) {
            queue.enqueue(root);
        }

        while (queue.size() != 0) {
            Node current = queue.dequeue();

            if (current.left != null) {
                queue.enqueue(current.left);
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            }

            System.out.print(current.value + " ");
        }
    }

    private void inOrder() {
        Queue<Node> queue = new DynamicQueue<>();

        if (root != null) {
            queue.enqueue(root);
        }

        while (queue.size() != 0) {
            Node current = queue.dequeue();
            
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            
            System.out.print(current.value + " ");

            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }

    public void treeTraversal(String type) {
        if (type.equals("postOrder")) {
            postOrder();
        } else if (type.equals("inOrder")) {
            inOrder();
        } else {
            treeTraversal();
        }
    }

    @Override
    public void treeTraversal() {
        preOrder();
    }

    @Override
    public String toString() {
        return "BinarySearchTree []";
    }

}
