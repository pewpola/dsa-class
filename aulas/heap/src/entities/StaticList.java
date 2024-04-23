package entities;

import exceptions.EmptyListException;
import exceptions.FullListException;

public class StaticList<E> implements List<E>{

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

    private void checkIndex(int index, int referenceIndex){
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

    public boolean isFull(){
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
        for(int i = index; i < size-1; i++){
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
