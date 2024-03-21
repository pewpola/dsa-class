package listaDeNomes;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StaticList namesList = new StaticList(1000);
        int N = scanner.nextInt();
    
        for (int i = 0; i < N; i++) {
            String nameTitle = scanner.next();
            namesList.add(new Name(nameTitle));
        }
        NamesList list = new NamesList(namesList);
        list.printFormatted();
    
        scanner.close();
    }
}

class StaticList {
    Object[] elements;
    int size;
    int defaultSize = 5;

    public StaticList(int capacity) {
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public StaticList(Object[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    public StaticList() {
        this.elements = new Object[defaultSize];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(Object element, int position) {
        _checkInvalidPosition(position);
        _increaseCapacity();
        for (int i = size - 1; i >= position; i--) {
            this.elements[i + 1] = this.elements[i];
        }
        setElement(position, element);
        this.size++;
    }

    public void setElement(int position, Object element) {
        this.elements[position] = element;
    }

    public void clear() {
        this.elements = new Object[defaultSize];
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean _isValidPosition(int position) {
        return position >= 0 && position < size;
    }

    private void _checkInvalidPosition(int position) throws IllegalArgumentException {
        if (!_isValidPosition(position))
            throw new IllegalArgumentException("Invalid position access");
    }

    private void _increaseCapacity() {
        if (_isFull()) {
            int currentCapacity = this.elements.length;
            int newCapacity = currentCapacity * 2;
            Object[] newLargerArray = new Object[newCapacity];
            for (int i = 0; i < this.size; i++) {
                newLargerArray[i] = this.elements[i];
            }
            this.elements = newLargerArray;
        }
    }

    private boolean _isFull() {
        return size == this.elements.length;
    }

    public void add(Object element) {
        _increaseCapacity();
        setElement(this.size, element);
        this.size++;
    }

    public Object getByIndex(int position) throws IllegalArgumentException {
        _checkInvalidPosition(position);
        return this.elements[position];
    }

    public int indexOf(Object element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object element) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public String toString() {
        StringBuilder listAsString = new StringBuilder();
        listAsString.append("[");
        for (int i = 0; i < this.size; i++) {
            listAsString.append(this.elements[i]);
            if (i < this.size - 1) {
                listAsString.append(", ");
            }
        }
        listAsString.append("]");
        return listAsString.toString();
    }

    public boolean remove(int position) {
        _checkInvalidPosition(position);
        for (int i = position; i < size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.size--;
        return true;
    }

    public boolean remove(Object element) {
        int position = indexOf(element);
        if (position == -1)
            return false;
        return this.remove(position);
    }

    public Object[] toArray() {
        Object[] array = new Object[this.size];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.elements[i];
        }
        return array;
    }
}

class Name {
    private String name;
    private int size;

    public Name(String name) {
        this.name = name;
        this.size = name.length();
    }

    @Override
    public boolean equals(Object obj) {
        Name name = (Name) obj;
        return name.getSize() == this.getSize();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Name: " + this.name;
    }
}

class NamesList {

    StaticList allNames;

    public NamesList(StaticList names) {
        this.allNames = names;
    }

    private void _createRowsRecursively(StaticList twoDimensionalList, int position) {
        if (position == getTwoDimensionalListSize()) {
            return;
        }
        twoDimensionalList.add(new StaticList());
        _createRowsRecursively(twoDimensionalList, position + 1);
    }

    private void _addElementsRecursively(StaticList twoDimensionalList, int j, Name name) {
        if (j == twoDimensionalList.size()) {
            return;
        }
        boolean contains = ((StaticList) twoDimensionalList.getByIndex(j)).contains(name);
        if (!contains) {
            ((StaticList) twoDimensionalList.getByIndex(j)).add(name);
            return;
        }
        _addElementsRecursively(twoDimensionalList, j + 1, name);
    }

    private void _iterateOverNamesRecursively(StaticList twoDimensionalList, int i, int j) {
        if (i == allNames.size()) {
            return;
        }
        Name name = (Name) this.allNames.getByIndex(i);
        _addElementsRecursively(twoDimensionalList, j, name);
        _iterateOverNamesRecursively(twoDimensionalList, i + 1, j);
    }

    public StaticList getTwoDimensionalList() {
        StaticList twoDimensionalList = new StaticList();
        int iCreateRows = 0;
        _createRowsRecursively(twoDimensionalList, iCreateRows);

        int j = 0;
        int i = 0;
        _iterateOverNamesRecursively(twoDimensionalList, i, j);
        return twoDimensionalList;
    }

    private void _swapVariables(int j2, StaticList row) {
        if (j2 == row.size() - 1) {
            return;
        }
        if (((Name) row.getByIndex(j2)).getSize() > ((Name) row.getByIndex(j2 + 1)).getSize()) {
            Name auxiliary = new Name(((Name) row.getByIndex(j2 + 1)).getName());
            row.setElement(j2 + 1, row.getByIndex(j2));
            row.setElement(j2, auxiliary);
        }
        _swapVariables(j2 + 1, row);
    }

    private void _iterateOverRowToSort(int j, StaticList row, int j2) {
        if (j == row.size()) {
            return;
        }
        _swapVariables(j2, row);
        _iterateOverRowToSort(j + 1, row, j2);
    }

    private void _iterateOverTwoDimensionalList(int i, int j, int j2, StaticList twoDimensionalList) {
        if (i == twoDimensionalList.size()) {
            return;
        }
        StaticList row = (StaticList) twoDimensionalList.getByIndex(i);
        _iterateOverRowToSort(j, row, j2);
        _iterateOverTwoDimensionalList(i + 1, j, j2, twoDimensionalList);
    }

    public StaticList getSortedTwoDimensionalList() {
        StaticList twoDimensionalList = getTwoDimensionalList();
        int j2 = 0;
        int i = 0;
        int j = 0;

        _iterateOverTwoDimensionalList(i, j, j2, twoDimensionalList);
        return twoDimensionalList;
    }

    public void printFormatted() {
        StaticList sortedList = this.getSortedTwoDimensionalList();
        int j = 0;
        int i = 0;
        _iterateToPrint(sortedList, i, j);
    }

    private void _iterateToPrint(StaticList sortedList, int i, int j) {
        if (i == sortedList.size()) {
            return;
        }
        if (((StaticList) sortedList.getByIndex(i)).size() > 0) {
            String formattedLine = _concatenateStrings(sortedList, i, j, "");
            System.out.println(formattedLine);
        }
        _iterateToPrint(sortedList, i + 1, j);
    }

    private String _concatenateStrings(StaticList sortedList, int i, int j, String formattedLine) {
        if (j == ((StaticList) sortedList.getByIndex(i)).size()) {
            return formattedLine;
        }
        String comma = j < ((StaticList) sortedList.getByIndex(i)).size() - 1 ? ", " : "";
        formattedLine = formattedLine + ((Name) ((StaticList) sortedList.getByIndex(i)).getByIndex(j)).getName()
                + comma;
        return _concatenateStrings(sortedList, i, j + 1, formattedLine);
    }

    public StaticList getListWithoutRepetitions() {
        StaticList listWithoutDuplicates = new StaticList();

        _addNewOnes(listWithoutDuplicates, 0);
        return listWithoutDuplicates;
    }

    private void _addNewOnes(StaticList listWithoutDuplicates, int startingIndex) {
        if (startingIndex == this.allNames.size()) {
            return;
        }

        Name name = (Name) this.allNames.getByIndex(startingIndex);
        boolean existsInList = listWithoutDuplicates.contains(name);
        if (!existsInList) {
            listWithoutDuplicates.add(name);
            _addNewOnes(listWithoutDuplicates, startingIndex + 1);
        } else {
            _addNewOnes(listWithoutDuplicates, startingIndex + 1);
        }
    }

    public int getTwoDimensionalListSize() {
        return this.allNames.size() - this.getListWithoutRepetitions().size();
    }
}