package listaDeCompras;

import java.util.Scanner;

public class Main {
    public static void printarFormatado(StaticList<String> list) {
        String line = "";
        String formatedLine = _concatenarStrings(list, 0, line);
        System.out.println(formatedLine);
    }

    public static String _concatenarStrings(StaticList<String> list, int index, String line) {
        if (index == list.size) {
            return line;
        }
        if (index == list.size - 1) {
            line = line + list.get(index);
        } else {
            line = line + list.get(index) + " ";
        }
        return _concatenarStrings(list, index + 1, line);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            String[] lineWithItems = scanner.nextLine().split(" ");
            ListaDeCompras listaDeCompras = new ListaDeCompras(lineWithItems);
            StaticList<String> ordenedList = listaDeCompras.listaDeComprasOrdened();
            printarFormatado(ordenedList);
        }
        scanner.close();
    }
}


class ListaDeCompras {
    StaticList<String> items;

    public ListaDeCompras(String[] listaDeCompras) {
        items = new StaticList<String>(100);
        for (String element : listaDeCompras) {
            items.add(element);
        }
    }

    public StaticList<String> listWithoutReps() {
        StaticList<String> listNoReps = new StaticList<String>(100);

        addNewElements(listNoReps, 0);
        return listNoReps;
    }

    private void addNewElements(StaticList<String> listNoReps, int startIndex) {
        if (startIndex == this.items.size) {
            return;
        }

        String element = this.items.get(startIndex);
        boolean elementInList = listNoReps.contains(element);
        if (!elementInList) {
            listNoReps.add(element);
            addNewElements(listNoReps, startIndex + 1);
        } else {
            addNewElements(listNoReps, startIndex + 1);
        }
    }

    public static String chooseFirstInAlphabeticalOrder(String a, String b) {
        if (a.compareTo(b) < 0) {
            return a;
        }
        return b;
    }

    public static boolean comeFirstAlphabeticalOrder(String a, String b) {
        return a.compareTo(b) < 0;
    }

    public StaticList<String> listaDeComprasOrdened() {
        StaticList<String> noDuplicated = listWithoutReps();
        listTraversal(noDuplicated, 0);
        return noDuplicated;
    }

    private void listTraversal(StaticList<String> noDuplicated, int i) {
        if (i == noDuplicated.size) {
            return;
        }

        orderList(noDuplicated, i, 0);
        listTraversal(noDuplicated, i + 1);
    }

    private void orderList(StaticList<String> noDuplicated, int i, int j) {
        if (j == noDuplicated.size - 1) {
            return;
        }
        if (!comeFirstAlphabeticalOrder(noDuplicated.get(j), noDuplicated.get(j + 1))) {
            String temp = noDuplicated.get(j);
            noDuplicated.set(j, noDuplicated.get(j + 1));
            noDuplicated.set(j + 1, temp);
        }
        orderList(noDuplicated, i, j + 1);
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