package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    private Person person;

    void setup1(){
        person = new Person("Person1", 20, 1.60, 60);
    }

    @Test
    void testImc(){
        setup1();
        double actualImc = person.getImc();
        assertEquals(22.8, actualImc, 0.9);
        assertEquals(23.0, actualImc, 0.5);
        assertEquals(23.3, actualImc, 0.3);
        assertEquals(23.437, actualImc, 0.05);
    }
}
