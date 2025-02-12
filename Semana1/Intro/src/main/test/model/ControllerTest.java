package model;

import exceptions.PersonAllReadyExist;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {

    private Controller control;

    public void listWithElements(){
        control = new Controller();

        // Usar las funcionalidades del lenguaje
        control.getPeople().add(new Person("A1", 10));
        control.getPeople().add(new Person("A2", 20));
    }

    public ArrayList<Person> listWithElements2(){
        ArrayList<Person> peopleToTest = new ArrayList<>();

        peopleToTest.add(new Person("A1", 10));
        peopleToTest.add(new Person("A2", 20));

        return peopleToTest;
    }

    @Test
    public void test1(){
        // init -> Escenario
        listWithElements();

        // Act ->
        String name = "A3";
        int age = 30;

        try {
            control.addPerson(name, age);
        } catch (PersonAllReadyExist e) {

        }

        // Assert
        assertEquals(name, control.getPeople().get(2).getName());
        assertEquals(10, control.getPeople().get(2).getAge());
    }

    @Test
    public void test2(){
        // init -> Escenario
        control.setPeople(listWithElements2());

        // Act ->
        String name = "A3";
        int age = 30;

        try {
            control.addPerson(name, age);
        } catch (PersonAllReadyExist e) {

        }

        // Assert
        assertEquals(name, control.getPeople().get(2).getName());
        assertEquals(10, control.getPeople().get(2).getAge());
    }

}
