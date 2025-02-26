package ui;

import model.Person;
import model.PersonComparator;
import model.PersonController;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Person 1", 5, "A1");
        Person p2 = new Person("Person 2", 2, "A2");
        Person p3 = new Person("Person 3", 4, "A3");
        Person p4 = new Person("Person 3", 1, "A3");
        Person p5 = new Person("Person 3", 3, "A3");

        // Person p1 < Person p2
        System.out.println(p1.compareTo(p2));

        // Person p2 > Person p1
        System.out.println(p2.compareTo(p1));

        System.out.println(p2.compareTo(p3));

        // Comparación externa
        PersonComparator comparatorCc = new PersonComparator();
        System.out.println(comparatorCc.compare(p1, p2));

        PersonController controller = new PersonController();
        controller.getPeople().add(p1);
        controller.getPeople().add(p2);
        controller.getPeople().add(p3);
        controller.getPeople().add(p4);
        controller.getPeople().add(p5);

        System.out.println(controller.getPeople());

        // System.out.println(controller.selectionSort(controller.getPeople()));
        System.out.println(controller.insertionSort(controller.getPeople()));

    }
}
