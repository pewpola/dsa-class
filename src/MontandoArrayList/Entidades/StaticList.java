package MontandoArrayList.Entidades;

import MontandoArrayList.Exceptions.EmptyListException;
import MontandoArrayList.Exceptions.FullListException;

public class StaticList implements List {
    private int size;
    private int[] staticList;
    private final int MAX_SIZE = 5;

    public StaticList() {
        staticList = new int[MAX_SIZE];
    }

    @Override
    public void add(int value) {
        if (isFull()) {
            throw new FullListException("Static List is Full!");
        }
        staticList[size] = value;
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= MAX_SIZE) {
            throw new IndexOutOfBoundsException("Index " + index + " is not valid!");
        }
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        return 0;
    }

    @Override
    public void insert(int value) {
        if (isFull()) {
            throw new FullListException("Static List is Full!");
        }

        for (int i = size; i > 0; i--) {
            staticList[i] = staticList[i - 1];
        }

        staticList[0] = value;
        size++;
    }

    @Override
    public void insert(int index, int value) throws IndexOutOfBoundsException {
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isFull() {
        if (size == MAX_SIZE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int removeByIndex(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int removeFirst() throws EmptyListException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int removeLast() throws EmptyListException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void set(int index, int value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    public String toString() {
        String data = "[";

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                data += staticList[i];
            } else {
                data += staticList[i] + ", ";
            }
        }

        return data + "]";
    }
    
}
