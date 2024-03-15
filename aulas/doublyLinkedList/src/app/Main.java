package app;

import entities.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }

}