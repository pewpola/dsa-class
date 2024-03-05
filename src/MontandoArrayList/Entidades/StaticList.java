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

        for (int i = size; i > 0; ) {
            staticList[i] = staticList[i - 1];
        }
    }

    @Override
    public void insert(int index, int value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    
    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return false;
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
