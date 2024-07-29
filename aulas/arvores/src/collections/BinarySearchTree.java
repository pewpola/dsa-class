package collections;

public class BinarySearchTree<E> extends AbstractTree<E> {

    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean contains(E value) {
        Node current = root;

        while (current != null) {
            if (compare(value, current) > 0) {
                current = current.right;
            } else if (compare(value, current) < 0) {
                current = current.left;
            } else {
                return true;
            }
        }
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
        Node current = root;

        while (current != null) {
            if (compare(value, current) > 0) {
                current = current.right;
            } else if (compare(value, current) < 0) {
                current = current.left;
            } else {
                return current.value;
            }
        }
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

    private void preOrder(Node current) {
        Stack<Node> pilha = new DynamicStack<>();

        if (current != null) {
            pilha.push(current);
        }

        while (!pilha.isEmpty()) {
            Node auxNode = pilha.pop();

            System.out.print(auxNode.value + " ");

            if (auxNode.right != null) {
                pilha.push(auxNode.right);
            }

            if (auxNode.left != null) {
                pilha.push(auxNode.left);
            }
        }
    }

    private void inOrder(Node current) {
        Stack<Node> pilha = new DynamicStack<>();

        while (!pilha.isEmpty() || current != null) {
            while (current != null) {
                pilha.push(current);
                current = current.left;
            }

            current = pilha.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }

    private void postOrder(Node current) {
        Stack<Node> stack1 = new DynamicStack<>();
        Stack<Node> stack2 = new DynamicStack<>();

        if (current != null) {
            stack1.push(current);
        }

        // stack1.push(current);

        while (!stack1.isEmpty()) {
            Node auxNode = stack1.pop();
            stack2.push(auxNode);

            if (auxNode.left != null) {
                stack1.push(auxNode.left);
            }

            if (auxNode.right != null) {
                stack1.push(auxNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    public void treeTraversal(String type) {
        if (type.equals("postOrder")) {
            postOrder(root);
        } else if (type.equals("inOrder")) {
            inOrder(root);
        } else {
            treeTraversal();
        }
    }

    @Override
    public void treeTraversal() {
        preOrder(root);
    }

    @Override
    public String toString() {
        return "BinarySearchTree []";
    }
}