package app;

import entities.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        list.set(3, 4);
        System.out.println(list);
    }
}