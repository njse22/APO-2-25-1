package ui;

import model.Person;
import model.PersonComparator;
import model.PersonController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person( "Person 1", 5, "A5");
        Person p2 = new Person( "Person 2", 2, "A2");
        Person p3 = new Person( "Person 3", 4, "A3");
        Person p4 = new Person( "Person 4", 1, "A4");
        Person p5 = new Person( "Person 5", 3, "A5");
        Person p6 = new Person( "Person 6", 5, "A5");
        Person p7 = new Person( "Person 7", 2, "A2");
        Person p8 = new Person( "Person 8", 4, "A3");
        Person p9 = new Person( "Person 9", 1, "A4");
        Person p10 = new Person("Person 10", 3, "A5");

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
        controller.getPeople().add(p6);
        controller.getPeople().add(p7);
        controller.getPeople().add(p8);
        controller.getPeople().add(p9);
        controller.getPeople().add(p10);

        System.out.println(controller.getPeople());

        // System.out.println(controller.selectionSort(controller.getPeople()));
        // System.out.println(controller.insertionSort(controller.getPeople()));

        // Collections.sort(controller.getPeople());
        // System.out.println(controller.getPeople());

        //Collections.sort(controller.getPeople(), comparatorCc);
        //System.out.println(controller.getPeople());


        Comparator<Person> copareInt = Comparator.comparingInt(Person::getAge);

        // Java 8 <
        Comparator<Person> paratorNames = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };


        // Java 11 >
        Comparator<Person> comp = (o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        };

        comp.compare(p1, p2);
        paratorNames.compare(p1, p2 );

        controller.selectionSort(controller.getPeople(), comp);

        System.out.println(controller.selectionSort(controller.getPeople(), comp));

        System.out.println(controller.binarySearch(controller.getPeople(), "Person 8"));

    }
}
