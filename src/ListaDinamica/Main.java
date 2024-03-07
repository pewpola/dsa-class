package ListaDinamica;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(3);
        System.out.println(list);
    }
}

// Exceptions
class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage) {
        super(errorMessage);
    }
}

// TAD - List
interface List<E> {
    int size();
    void add(E value);
    void insert(E value);
    void insert(int index, E value) throws IndexOutOfBoundsException;
    E removeLast() throws EmptyListException;
    E removeFirst() throws EmptyListException;
    E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException;
    boolean isEmpty();
    E get(int index) throws IndexOutOfBoundsException;
    void set(int index, E value) throws IndexOutOfBoundsException;
}

/*

class Node<E> {
    E value;
    Node<E> next;

    public Node(E value) {
        this.value = value;
    }
}

*/

class LinkedList<E> implements List<E> {

    class Node {
        E value;
        Node next;

        public Node(E value) {
            this.value = value;
        }
    }

    public LinkedList() {}

    public LinkedList(E value) {
        Node newNode = new Node(value);

        head = newNode;
        tail = newNode;
        size = 1;
    }

    private int size;
    private Node head;
    private Node tail;

    @Override
    public void add(E value) {
        Node newNode = new Node(value);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void insert(E value) {
        // TODO Auto-generated method stub

    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E removeLast() throws EmptyListException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub

    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        String linkedList = "[";

        Node auxNode = head;

        while (auxNode != null) {
            if (auxNode.next == null) {
                linkedList += auxNode.value;
            } else {
                linkedList += auxNode.value + ", ";
            }
            auxNode = auxNode.next;
        }

        return linkedList + "]";
    }
}