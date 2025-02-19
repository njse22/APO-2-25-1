package model;

import exceptions.PersonAllReadyExist;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    private Controller control;

    public void listWithElements(){
        control = new Controller();

        // Usar las funcionalidades del lenguaje
        control.getPeople().add(new Person("A1", 10, 1.80, 90));
        control.getPeople().add(new Person("A2", 20, 1.80, 90));
    }

    public ArrayList<Person> listWithElements2(){
        control = new Controller();
        ArrayList<Person> peopleToTest = new ArrayList<>();

        peopleToTest.add(new Person("A1", 10, 1.70, 60));
        peopleToTest.add(new Person("A2", 20, 1.70, 60));

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
            control.addPerson(name, age, 5, 7);
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
        double w = 60;
        double h = 60;

        try {
            control.addPerson(name, age, h, w);
        } catch (PersonAllReadyExist e) {

        }

        // Assert
        assertEquals(name, control.getPeople().get(2).getName());
        assertEquals(10, control.getPeople().get(2).getAge());
    }



    @Test
    void testException(){
        // init
        listWithElements();

        String name = "A1"; // Name in list
        int age = 40;
        double weight = 60;
        double height = 1.60;

        // Act / assert -> Prueba negativa
        assertThrows(PersonAllReadyExist.class, () -> { control.addPerson(
                name, age, weight, height
        );} );
    }

    @Test
    void testInList(){
        // init
        listWithElements();

        // Act
        Person personTest = new Person("A1", 10, 1.80, 90);

        // Assert -> True
        assertTrue(control.isInList(personTest));
    }

    @Test
    void testInListNegative(){
        // init
        listWithElements();

        // act
        Person personTest = new Person("A10", 10, 1.80, 90);

        // assert -> Flase
        assertFalse(control.isInList(personTest));
    }


}
