package ui;

import structures.DoubleLinkedList;

public class Main {

    public static void main(String[] args) {

        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        list.addToFirst("A1");
        System.out.println("primero: "+ list.getFirst());
        System.out.println("Ultimo: "+ list.getLast());

        list.addToFirst("A2");
        System.out.println("primero: "+ list.getFirst());
        System.out.println("Ultimo: "+ list.getLast());

        list.addToFirst("A3");
        System.out.println("primero: "+ list.getFirst());
        System.out.println("Ultimo: "+ list.getLast());

        list.addToFirst("A4");
        System.out.println("primero: "+ list.getFirst());
        System.out.println("Ultimo: "+ list.getLast());

        list.addToFirst("A5");
        System.out.println("primero: "+ list.getFirst());
        System.out.println("Ultimo: "+ list.getLast());

        System.out.println(list.inverserOrder());



    }
}
