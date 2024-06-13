package colecaoDePomekons;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        n = sc.nextInt();

        PomekonList list = new PomekonList();

        for (int i = 0; i < n; i++) {
            String pomekon = sc.next();
            list.capturePomekon(pomekon);
        }

        sc.close();

        System.out.println("Falta(m) " + list.remainingPomekons() + " pomekon(s).");
    }
}

class PomekonList {
    public StaticList<String> pomekons;

    public PomekonList() {
        pomekons = new StaticList<String>(151);
    }

    public void capturePomekon(String pomekon) {
        if (!pomekons.contains(pomekon)) {
            pomekons.add(pomekon);
        }
    }

    public int remainingPomekons() {
        return 151 - pomekons.size;
    }
}

interface List<E> {
    void add(E value);

    void insert(E value);

    void insert(int index, E value) throws IndexOutOfBoundsException;

    E removeLast() throws EmptyListException;

    E removeFirst() throws EmptyListException;

    E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException;

    boolean isFull();

    boolean isEmpty();

    E get(int index) throws IndexOutOfBoundsException;

    void set(int index, E value) throws IndexOutOfBoundsException;

    boolean contains(E value);
}

class StaticList<E> implements List<E> {
    public int size;
    private Object[] list;
    private final int MAX_SIZE;

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public StaticList(int MAX_SIZE) {
        list = new Object[MAX_SIZE];
        this.MAX_SIZE = MAX_SIZE;
    }

    @Override
    public void add(E value) {
        if (isFull()) {
            throw new FullListException("Static List is Full!");
        }
        list[size] = value;
        size++;
    }

    private void checkIndex(int index, int referenceIndex) {
        if (index < 0 || index >= referenceIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is not valid!");
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        @SuppressWarnings("unchecked")
        E result = (E) list[index];
        return result;
    }

    @Override
    public void insert(E value) {
        if (isFull()) {
            throw new FullListException("Static List is Full!");
        }

        for (int i = size; i > 0; i--) {
            list[i] = list[i - 1];
        }

        list[0] = value;
        size++;
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {
        if (isFull()) {
            throw new FullListException("Static List is Full");
        }

        checkIndex(index, MAX_SIZE);

        if (index >= size) {
            add(value);
        } else {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }

            list[index] = value;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_SIZE;
    }

    @Override
    public E removeByIndex(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Static List is Empty");
        }

        checkIndex(index, size);

        @SuppressWarnings("unchecked")
        E value = (E) list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }

        size--;
        return value;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static List is Empty");
        }

        @SuppressWarnings("unchecked")
        E value = (E) list[0];

        for (int i = 0; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;

        return value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static List is Empty");
        }
        @SuppressWarnings("unchecked")
        E value = (E) list[--size];
        return value;
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        list[index] = value;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                data.append(list[i]);
            } else {
                data.append(list[i]).append(", ");
            }
        }
        data.append("]");
        return data.toString();
    }
}

class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage) {
        super(errorMessage);
    }
}

class FullListException extends RuntimeException {
    public FullListException(String errorMessage) {
        super(errorMessage);
    }
}
