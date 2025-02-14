package ui;

import exceptions.PersonAllReadyExist;
import model.Controller;
import model.Person;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private Controller controller;

    public Main(){
        controller = new Controller();
    }

    public static void main(String[] args) {
        System.out.println("Hola");

        Main main = new Main();

        try {
            main.controller.addPerson("Name1", 10, 1.70, 70 );
            main.controller.addPerson("Name2", 20, 1.70, 70 );
            main.controller.addPerson("Name3", 30, 1.70, 70 );
            main.controller.addPerson("Name4", 40, 1.70, 70 );
            main.controller.addPerson("Name5", 50, 1.70, 70 );
            main.controller.addPerson("Name5", 50, 1.70, 70 );
        } catch (PersonAllReadyExist error){
            Logger logger = Logger.getLogger(Main.class.getName());
            logger.log(Level.SEVERE, error.getMessage());
            // error.printStackTrace();
        }

        main.controller.isInList(new Person("Name1", 10, 1.70, 70 ));

        System.out.println(main.controller.getJsonData());

        System.out.println(main.controller.fileProperties());

        main.controller.saveJson();
        main.controller.getPeople().clear();

        main.controller.loadJson();

        System.out.println(main.controller.getPeople());

        System.out.println(main.controller.getPeople().get(0).getName());

        main.controller.saveCsv();

        main.controller.loadCsv();

        System.out.println(main.controller.getPeople());
    }
}
