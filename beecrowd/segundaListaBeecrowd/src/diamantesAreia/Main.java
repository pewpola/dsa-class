package diamantesAreia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            System.out.println(diamondsCounter(line));
        }
        sc.close();
    }

    public static int diamondsCounter(String line) {
       StaticStack<Character> stack = new StaticStack<>(line.length());

       int counter = 0;
       char less = '<';
       char greater = '>';

       for (int i = 0; i < line.length(); i++) {
        Character character = line.charAt(i);

        if (character == less) {
            stack.push(character);
        } else if (character == greater) {
            if (!stack.isEmpty() && stack.top() == less) {
                stack.pop();
                counter++;
            }
        }
       }

       return counter;
    }
}

interface Stack<E> {
    void push(E value);
    E pop();
    E top();
    boolean isEmpty();
    int height();
}

class StaticStack<E> implements Stack<E> {

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

class EmptyStackException extends RuntimeException {
    public EmptyStackException(String errorMessage) {
        super(errorMessage);
    }
}

class FullStackException extends RuntimeException {
    public FullStackException(String errorMessage) {
        super(errorMessage);
    }
}
