package interfaces;

import exceptions.*;

public interface List {
    void add(int value);
    void insert(int value);
    void insert(int index, int value) throws IndexOutOfBoundsException;
    int removeLast() throws EmptyListException ;
    int removeFirst() throws EmptyListException;
    int removeByIndex(int index) throws IndexOutOfBoundsException,EmptyListException;
    boolean isFull();
    boolean isEmpty();
    int get(int index) throws IndexOutOfBoundsException;
    void set(int index, int value) throws IndexOutOfBoundsException;
}
