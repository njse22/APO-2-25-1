package ui;

import structures.SimpleList;

public class Main {
    public static void main(String[] args) {
        SimpleList list = new SimpleList();

        list.add("A1");
        System.out.println(list.getFirst());
        list.add("A2");
        System.out.println(list.getFirst().getNext());
        list.add("A3");
        System.out.println(list.getFirst().getNext().getNext());
        list.add("A4");
        System.out.println(list.getFirst().getNext().getNext().getNext());
        list.add("A5");
        System.out.println(list.getFirst().getNext().getNext().getNext().getNext());

        System.out.println(list.getByIndex(6));

    }
}
