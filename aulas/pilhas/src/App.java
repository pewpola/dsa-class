import collections.StaticStack;

public class App {
    public static void main(String[] args) throws Exception {
        StaticStack<Integer> stack = new StaticStack<>(10);
        
        stack.push(7);
        stack.push(9);

        System.out.println(stack);
    }
}
