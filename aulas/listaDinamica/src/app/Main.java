package app;

import entities.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(2);
        list.add(3);
        System.out.println(list);
    }
}