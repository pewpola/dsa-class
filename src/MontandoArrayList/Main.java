package MontandoArrayList;

import MontandoArrayList.Entidades.StaticList;

public class Main {
    public static void main(String[] args) {
        StaticList list = new StaticList();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);
    }
}
