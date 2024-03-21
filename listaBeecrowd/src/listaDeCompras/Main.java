package listaDeCompras;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            
            StaticList<String> list = new StaticList<>(100);
            String[] items = sc.nextLine().split(" ");

            for (String item : items) {
                list.add(item);
            }
            System.out.println(list);
        }

        sc.close();
    }
}

class StaticListaDeCompras {
    StaticList<String> items;

    public StaticListaDeCompras(String[] listaDeElementos) {
        items = new StaticList<String>(100);
        for (String elemento : listaDeElementos) {
            items.add(elemento);
        }
    }

    public StaticList<String> getListaSemRepeticao() {
        StaticList<String> listaSemDuplicatas = new StaticList<String>(100);

        _adicionarNovos(listaSemDuplicatas, 0);
        return listaSemDuplicatas;
    }

    private void _adicionarNovos(StaticList<String> listaSemDuplicatas, int indiceDePartida) {
        if (indiceDePartida == this.items.size) {
            return;
        }

        String elemento = this.items.get(indiceDePartida);
        boolean existeNaLista = listaSemDuplicatas.contains(elemento);
        if (!existeNaLista) {
            listaSemDuplicatas.add(elemento);
            _adicionarNovos(listaSemDuplicatas, indiceDePartida + 1);
        } else {
            _adicionarNovos(listaSemDuplicatas, indiceDePartida + 1);
        }
    }

    public static String escolherPrimeiroEmOrdemAlfabetica(String a, String b) {
        if (a.compareTo(b) < 0) {
            return a;
        }
        return b;
    }

    public static boolean vemPrimeiroNoAlfabeto(String a, String b) {
        return a.compareTo(b) < 0;
    }

    public StaticList<String> getListaDeComprasOrdenada() {
        StaticList<String> semDuplicatas = getListaSemRepeticao();
        _percorrerLista(semDuplicatas, 0);
        return semDuplicatas;
    }

    private void _percorrerLista(StaticList<String> semDuplicatas, int i) {
        if (i == semDuplicatas.size) {
            return;
        }

        _ordenarLista(semDuplicatas, i, 0);
        _percorrerLista(semDuplicatas, i + 1);
    }

    private void _ordenarLista(StaticList<String> semDuplicatas, int i, int j) {
        if (j == semDuplicatas.size - 1) {
            return;
        }
        if (!vemPrimeiroNoAlfabeto(semDuplicatas.get(j), semDuplicatas.get(j + 1))) {
            String temp = semDuplicatas.get(j);
            semDuplicatas.set(j, semDuplicatas.get(j + 1));
            semDuplicatas.set(j + 1, temp);
        }
        _ordenarLista(semDuplicatas, i, j + 1);
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