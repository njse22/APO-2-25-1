package ui;

import structures.BST;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(35);
        bst.add(33);
        bst.add(60);
        bst.add(75);
        bst.add(73);
        bst.add(80);

        System.out.println(bst.inOrder());
    }
}
