package ui;

import model.Controller;

public class Main {

    private Controller controller;

    public Main(){
        controller = new Controller();
    }

    public static void main(String[] args) {
        System.out.println("Hola");

        Main main = new Main();

        main.controller.addPerson("Name1", 10);
        main.controller.addPerson("Name2", 20);
        main.controller.addPerson("Name3", 30);
        main.controller.addPerson("Name4", 40);
        main.controller.addPerson("Name5", 50);

        System.out.println(main.controller.getJsonData());

        System.out.println(main.controller.fileProperties());

    }
}
