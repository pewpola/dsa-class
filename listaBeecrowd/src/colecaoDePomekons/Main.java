package colecaoDePomekons;

public class Main {
    public static void main(String[] args) {
        
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
}

class NumbersList<E> implements List<E> {
    private int size;
    private Object[] numbersList;
    private final int MAX_SIZE;

    public NumbersList(int MAX_SIZE) {
        numbersList = new Object[MAX_SIZE];
        this.MAX_SIZE = MAX_SIZE;
    }

    @Override
    public void add(E value) {
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
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        @SuppressWarnings("unchecked")
        E result = (E) numbersList[index];
        return result;
    }

    @Override
    public void insert(E value) {
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
    public void insert(int index, E value) throws IndexOutOfBoundsException {
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
    public E removeByIndex(int index) throws IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new EmptyListException("Static List is Empty");
        }

        checkIndex(index, size);

        @SuppressWarnings("unchecked")
        E value = (E) numbersList[index];
        for (int i = index; i < size - 1; i++) {
            numbersList[i] = numbersList[i + 1];
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
        E value = (E) numbersList[0];

        for (int i = 0; i < size - 1; i++) {
            numbersList[i] = numbersList[i + 1];
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
        E value = (E) numbersList[--size];
        return value;
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        numbersList[index] = value;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                data.append(numbersList[i]);
            } else {
                data.append(numbersList[i]).append(", ");
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
