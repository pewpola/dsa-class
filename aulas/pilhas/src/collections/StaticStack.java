package collections;

import java.util.EmptyStackException;

public class StaticStack<E> implements Stack<E> {

    private int height;
    private E[] stack;

    @SuppressWarnings("unchecked")
    public StaticStack(int maxHeight) {
        stack = (E[])new Object[maxHeight];
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        return height == 0;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty!");
        }

        return stack[--height];
    }

    @Override
    public void push(E value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public E top() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
