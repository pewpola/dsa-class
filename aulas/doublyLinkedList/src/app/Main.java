package app;

import entities.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.ordenedInsert(3);
        list.ordenedInsert(1);
        System.out.println(list);
        list.ordenedInsert(2);
        System.out.println(list);
        list.ordenedInsert(4);
        System.out.println(list);
        list.ordenedInsert(0);
        System.out.println(list);
        list.ordenedInsert(6);
        System.out.println(list);
        list.ordenedInsert(5);
        System.out.println(list);

        /*
        System.out.println(list.removeLast());
        System.out.println(list);
        System.out.println(list.inverseList());
        list.add(4);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list.inverseList());
        */
        /* 
        System.out.println(list);
        list.clear();
        System.out.println(list);
        System.out.println(list.size());
        */
    }
    
}