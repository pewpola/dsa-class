package MontandoArrayList.Entidades;

import MontandoArrayList.Exceptions.EmptyListException;

public class ArrayList extends StaticList {

    public ArrayList() {
        staticList = new int[5];
    }

    private void recreateStaticList() {
        int [] newStaticList = new int[staticList.length * 2];
        for (int i = 0; i < size; i++) {
            newStaticList[i] = staticList[i];
        }
        staticList = newStaticList;
    }

    @Override
    public void add(int value) {
        if (size == staticList.length) {

        }

        staticList[size] = value;
        size++;
    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return super.get(index);
    }

    @Override
    public void insert(int value) {
        // TODO Auto-generated method stub
        super.insert(value);
    }

    @Override
    public void insert(int index, int value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        super.insert(index, value);
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return super.isEmpty();
    }

    @Override
    public boolean isFull() {
        // TODO Auto-generated method stub
        return super.isFull();
    }

    @Override
    public int removeByIndex(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        return super.removeByIndex(index);
    }

    @Override
    public int removeFirst() throws EmptyListException {
        // TODO Auto-generated method stub
        return super.removeFirst();
    }

    @Override
    public int removeLast() throws EmptyListException {
        // TODO Auto-generated method stub
        return super.removeLast();
    }

    @Override
    public void set(int index, int value) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        super.set(index, value);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    
}
