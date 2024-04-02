import collections.DynamicStack;

public class App {
    public static void main(String[] args) throws Exception {
        DynamicStack<Integer> stack = new DynamicStack<>();

        stack.push(3);
        stack.push(9);
        stack.push(5);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
