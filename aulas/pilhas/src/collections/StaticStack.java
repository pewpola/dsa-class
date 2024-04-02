package collections;

import exceptions.*;

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

    public boolean isFull() {
        return height == stack.length;
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
        if (isFull()) {
            throw new FullStackException("Stack is full!");
        }

        stack[height++] = value;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is Empty!");
        }

        return stack[height - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");

        for (int i = height - 1; i >= 0; i--) {
            sb.append(stack[i]);

            if (i != 0) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
