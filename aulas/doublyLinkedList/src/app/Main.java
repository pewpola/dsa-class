package app;

import entities.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.removeLast());
        System.out.println(list);
        /* 
        System.out.println(list);
        list.clear();
        System.out.println(list);
        System.out.println(list.size());
        */
    }
    
}