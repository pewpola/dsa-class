package app;

import entities.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        list.removeByIndex(2);
        System.out.println(list);
    }
}