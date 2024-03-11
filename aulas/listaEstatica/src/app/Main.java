package app;

import entidades.*;

public class Main {
    public static void main(String[] args) {
        StaticList list = new StaticList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.insert(1,2);
        list.insert(0);
        list.removeByIndex(2);

        System.out.println(list);
    }
}