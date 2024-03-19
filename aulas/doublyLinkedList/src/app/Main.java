package app;

import entities.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insereOrdenado(3);
        list.insereOrdenado(1);
        System.out.println(list);
        list.insereOrdenado(2);
        System.out.println(list);
        list.insereOrdenado(4);
        System.out.println(list);
        list.insereOrdenado(0);
        System.out.println(list);
        list.insereOrdenado(6);
        System.out.println(list);
        list.insereOrdenado(5);
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