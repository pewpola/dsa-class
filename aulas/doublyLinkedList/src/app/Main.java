package app;

import entities.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.getInverse(0));
        System.out.println(list.getInverse(1));
        System.out.println(list.getInverse(2));
        System.out.println(list.getInverse(3));
        System.out.println(list.inverseList());
    }

}