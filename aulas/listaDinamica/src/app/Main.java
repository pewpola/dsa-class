package app;

import entities.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertOrdened(3);
        System.out.println(list);
        list.insertOrdened(2);
        System.out.println(list);
        list.insertOrdened(5);
        System.out.println(list);
        list.insertOrdened(1);
        System.out.println(list);
        list.insertOrdened(4);
        System.out.println(list);
        list.insertOrdened(0);
        System.out.println(list);
    }
}