package ui;

import structures.BST;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(80);
        bst.add(60);

        System.out.println(bst.inOrder());

        System.out.println(bst.preOrder());

        System.out.println(bst.postOrder());
    }
}
