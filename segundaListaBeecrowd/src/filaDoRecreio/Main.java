package filaDoRecreio;

import java.util.Comparator;

public class Main {
    
}

abstract class AbstractHeap<K,V> implements PriorityQueue<K,V> {

    class HeapEntry implements Entry<K,V> {

        K key;
        V value;        

        public HeapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ":" + value + ")";
        }
    }

    protected List<Entry<K,V>> heap;
    private Comparator<K> comparator;

    public AbstractHeap() {
        heap = new ArrayList<>();
        comparator = new DefaultComparator<>();
    }

    public int compare(int index1, int index2){
        return compare(heap.get(index1), heap.get(index2));
    }

    public int compare(Entry<K,V> e1, Entry<K,V> e2){
        return comparator.compare(e1.getKey(), e2.getKey());
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {        
        return heap.size();
    }

    @Override
    public String toString() {
        return heap.toString();
    }    
}
class Heap<K,V> extends AbstractHeap<K,V> {

    @Override
    public void insert(K key, V value) {
        Entry<K,V> newEntry = new HeapEntry(key, value);
        heap.add(newEntry);

        int current = size() - 1;
        int parent = parent(current);

        while(current > 0 && compare(current, parent) == -1) {
            swap(current, parent);
            current = parent;
            parent = parent(current);
        }
    }

    private void swap(int index1, int index2) {
        Entry<K,V> auxEntry = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, auxEntry);
    }
    
    private int parent(int child) {
        return (child - 1) / 2;
    }
    
    @Override
    public Entry<K, V> maxPriority() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty!");
        }
    
        return heap.get(0);
    }

    @Override
    public Entry<K, V> remove() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is Empty");
        }

        Entry<K,V> entry;

        if (size() == 1) {
            entry = heap.removeLast();
        } else {
            entry = maxPriority();
            heap.set(0, heap.removeLast());
            sinkDown();
        }

        return entry;
    }

    private int rightChild(int parent) {
        return leftChild(parent) + 1;
    }

    private int leftChild(int parent) {
        return parent * 2 + 1;
    }

    private void sinkDown() {
        int current, min = 0;
        int leftChild, rightChild;

        do {
            current = min;
            leftChild = leftChild(current);
            rightChild = rightChild(current);

            if (leftChild < size() && compare(leftChild, min) == -1) {
                min = leftChild;
            }

            if (rightChild < size() && compare(rightChild, min) == -1) {
                min = leftChild;
            }

            if (current != min) {
                swap(current, min);
            }

        } while (current != min);
    }
}

interface Entry<K,V> {
    K getKey();
    V getValue();
}

interface PriorityQueue<K,V> {
    void insert(K key, V value);
    Entry<K,V> maxPriority();
    Entry<K,V> remove();
    int size();
    boolean isEmpty();
}

class StaticList<E> implements List<E>{

    protected int size;
    protected E[] staticList;
    private final int MAX_SIZE = 5;

    @SuppressWarnings("unchecked")
    public StaticList(){
        staticList = (E[])new Object[MAX_SIZE];
        
    }

    @Override
    public void add(E value) {
        if(isFull()){
            throw new FullListException("Static List is Full!");
        }
        staticList[size] = value;
        size++;            
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return staticList[index];
    }

    @Override
    public void insert(E value) {
        if(isFull()){
            throw new FullListException("Static List is Full!");
        }

        for(int i = size ; i > 0 ; i--){
            staticList[i] = staticList[i-1];
        }
        staticList[0] = value;
        size++;
        
    }

    private void checkIndex(int index, int referenceIndex) {
        if(index < 0 || index>=referenceIndex){
            throw new IndexOutOfBoundsException("Index "+index+" is not valid!");
        }
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {
        if(isFull()){
            throw new FullListException("Static List is Full!");
        }

        checkIndex(index,MAX_SIZE);

        if(index>=size){
            add(value);
        }else{

            for(int i = size ; i > index ; i--){
                staticList[i] = staticList[i-1];
            }
            staticList[index] = value;
            size++;

        }

        
    }

    public boolean isFull() {
        return size == MAX_SIZE;
        // if(size == MAX_SIZE){
        //     return true;
        // }
        // return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E removeByIndex(int index) throws IndexOutOfBoundsException, EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Static List is Empty");
        }
        checkIndex(index, size);


        E value = staticList[index];

        for(int i = index; i < size-1; i++) {
            staticList[i] = staticList[i+1];
        }

        size--;

        return value;
    }

    @Override
    public E removeFirst() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Static List is Empty");
        }
        E value = staticList[0];
        for(int i = 0; i < size-1;i++){
            staticList[i] = staticList[i+1];
        }
        size--;
        return value;
    }

    @Override
    public E removeLast() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException("Static List is Empty");
        }
        return staticList[--size];
    }

    @Override
    public void set(int index, E value) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        staticList[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String data = "[";
        
        for(int i = 0; i < size; i++){
            if(i==size-1){
                data = data + staticList[i];
            }else{
                data = data + staticList[i]+", ";

            }
        }
        
        return data + "]";
    }
}

class ArrayList<E> extends StaticList<E> {
    @SuppressWarnings("unchecked")
    public ArrayList(){
        staticList = (E[]) new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    private void recreateStaticList(){
      
        E[] newStaticList = (E[])new Object[(staticList.length*3)/2+1];
        for(int i = 0; i < size; i++){
            newStaticList[i] = staticList[i];
        }
        staticList = newStaticList;
    }

    @Override
    public void add(E value) {
        if(size == staticList.length){
            recreateStaticList();
        }

        staticList[size] = value;
        size++;   
    }

    @Override
    public void insert(E value) {        
        super.insert(value);
    }

    @Override
    public void insert(int index, E value) throws IndexOutOfBoundsException {        
        super.insert(index, value);
    }
}

interface List<E> {
    void add(E value);
    void insert(E value);
    void insert(int index, E value) throws IndexOutOfBoundsException;
    E removeLast() throws EmptyListException ;
    E removeFirst() throws EmptyListException;
    E removeByIndex(int index) throws IndexOutOfBoundsException,EmptyListException;
    boolean isEmpty();
    E get(int index) throws IndexOutOfBoundsException;
    void set(int index, E value) throws IndexOutOfBoundsException;
    int size(); 
}


class DefaultComparator<E> implements Comparator<E>{

    @Override
    @SuppressWarnings("unchecked")
    public int compare(E o1, E o2) {
        return ((Comparable<E>) o1).compareTo(o2);
    }
}

class EmptyListException extends RuntimeException {
    public EmptyListException(String errorMessage){
        super(errorMessage);
    }
}

class FullListException extends RuntimeException {
    public FullListException(String errorMessage){
        super(errorMessage);
    }
}