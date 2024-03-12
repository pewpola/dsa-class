package paresImpares;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        n = sc.nextInt();

        NumbersList evenList = new NumbersList(n);
        NumbersList oddList = new NumbersList(n);

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (number % 2 == 0) {
                evenList.add(number);
            } else {
                oddList.add(number);
            }
        }

        QuickSort.quickSort(evenList, 0, evenList.size - 1);
        QuickSort.ordenaListaDecrescente(oddList, 0, oddList.size - 1);

        for (int i = 0; i < evenList.size; i++) {
            System.out.println(evenList.get(i));
        }

        for (int i = 0; i < oddList.size; i++) {
            System.out.println(oddList.get(i));
        }

        sc.close();
    }
}

interface List {
    void add(int value);

    void insert(int value);

    void insert(int index, int value) throws IndexOutOfBoundsException;

    int removeLast() throws EmptyListException;

    int removeFirst() throws EmptyListException;

    int removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException;

    boolean isFull();

    boolean isEmpty();

    int get(int index) throws IndexOutOfBoundsException;

    void set(int index, int value) throws IndexOutOfBoundsException;
}

class NumbersList implements List {
    public int size;
    public int[] numbersList;
    public int MAX_SIZE;

    public NumbersList(int MAX_SIZE) {
        numbersList = new int[MAX_SIZE];
        this.MAX_SIZE = MAX_SIZE;
    }

    @Override
    public void add(int value) {
        if (isFull()) {
            throw new FullListException("Static List is Full!");
        }
        numbersList[size] = value;
        size++;
    }

    private void checkIndex(int index, int referenceIndex) {
        if (index < 0 || index >= referenceIndex) {
            throw new IndexOutOfBoundsException("Index " + index + " is not valid!");
        }
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return numbersList[index];
    }

    @Override
    public void insert(int value) {
        if (isFull()) {
            throw new FullListException("Static List is Full!");
        }

        for (int i = size; i > 0; i--) {
            numbersList[i] = numbersList[i - 1];
        }

        numbersList[0] = value;
        size++;
    }

    @Override
    public void insert(int index, int value) throws IndexOutOfBoundsException {
        if (isFull()) {
            throw new FullListException("Static List is Full");
        }

        checkIndex(index, MAX_SIZE);

        if (index >= size) {
            add(value);
        } else {
            for (int i = size; i > index; i--) {
                numbersList[i] = numbersList[i - 1];
            }

            numbersList[index] = value;
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
    public int removeByIndex(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Static List is Empty");
        }

        checkIndex(index, size);

        int value = numbersList[index];
        for (int i = index; i < size - 1; i++) {
            numbersList[i] = numbersList[i + 1];
        }

        return value;
    }

    @Override
    public int removeFirst() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static List is Empty");
        }

        int value = numbersList[0];

        for (int i = 0; i < size - 1; i++) {
            numbersList[i] = numbersList[i + 1];
        }
        size--;

        return value;
    }

    @Override
    public int removeLast() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException("Static List is Empty");
        }
        return numbersList[--size];
    }

    @Override
    public void set(int index, int value) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        numbersList[index] = value;
    }

    @Override
    public String toString() {
        String data = "[";

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                data += numbersList[i];
            } else {
                data += numbersList[i] + ", ";
            }
        }

        return data + "]";
    }
}

class QuickSort {
    private static int partition(NumbersList lista, int comeco, int fim) {
        int pivot = lista.get(fim);
        int i = comeco - 1;
        for (int j = comeco; j <= fim - 1; j++) {
            if (lista.get(j) < pivot) {
                i++;
                int auxiliar = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, auxiliar);
            }
        }
        i++;
        int auxiliar = lista.get(i);
        lista.set(i, lista.get(fim));
        lista.set(fim, auxiliar);
        return i;
    }

    public static void quickSort(NumbersList lista, int comeco, int fim) {
        if (fim <= comeco) {
            return;

        }
        int pivot = partition(lista, comeco, fim);
        quickSort(lista, pivot + 1, fim);
        quickSort(lista, comeco, pivot - 1);

    }

    private static int partitionDecrescente(NumbersList lista, int comeco, int fim) {
        int pivot = lista.get(fim);
        int i = comeco - 1;
        for (int j = comeco; j <= fim - 1; j++) {
            if (lista.get(j) > pivot) {
                i++;
                int auxiliar = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, auxiliar);
            }
        }
        i++;
        int auxiliar = lista.get(i);
        lista.set(i, lista.get(fim));
        lista.set(fim, auxiliar);
        return i;
    }

    public static void ordenaListaDecrescente(NumbersList lista, int comeco, int fim) {
        if (fim <= comeco) {
            return;

        }
        int pivot = partitionDecrescente(lista, comeco, fim);
        ordenaListaDecrescente(lista, pivot + 1, fim);
        ordenaListaDecrescente(lista, comeco, pivot - 1);
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
