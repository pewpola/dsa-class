package balancoDeParenteses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.next();

            if (line.isEmpty()) break;
            
            System.out.println(parenthesesChecker(line));
        }
        sc.close();

        sc.close();
    }

    public static String parenthesesChecker(String line) {
        StaticStack<Character> stack = new StaticStack<>(line.length());

        char open = '(';
        char close = ')';

        for (int i = 0; i < line.length(); i++) {
            Character character = line.charAt(i);

            if (character == open) {
                stack.push(character);
            } else if (character == close) {
                if (!stack.isEmpty() && stack.top() == open) {
                    stack.pop();
                } else {
                    return "incorrect";
                }
            }
            
        }

        if (stack.isEmpty()) {
            return "correct";
        } else {
            return "incorrect";
        }
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