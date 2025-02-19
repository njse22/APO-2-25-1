package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactBookTest {

    private ContactBook contactBook;

    private void setupScenary1(){
        contactBook = null;
    }

    void setupScenary2(){
        contactBook = new ContactBook();
    }

    void setupScenary3(){
        contactBook = new ContactBook();
        contactBook.getContacts().add(new Contact(
                "luis", "luis@mail.com", "001"));
        contactBook.getContacts().add(new Contact(
                "fernando", "fernando@mail.com", "002"));
        contactBook.getContacts().add(new Contact(
                "javier", "javier@mail.com", "003"));
    }

    @Test
    void test1(){
        // init
        setupScenary1();

        // act
        contactBook = new ContactBook();

        // Assert
        // 1. valida que el objeto se crea exitosamente
        assertNotNull(contactBook);

        // 2. que la lista este vacia
        assertEquals(contactBook.getContacts().size(), 0);
    }

    @Test
    void test2(){
        // init
        setupScenary2();

        // act

        // Valores de entrada
        String name="Pablo Herrera";
        String email="pablo@icesi.edu.co";
        String phone="3112345678";

        boolean addResult = contactBook.addContact(name, email, phone);

        // assert

        /*
        * true
          Se agregó correctamente un nuevo contacto con nombre Pablo Herrera,
          * correo pablo@icesi.edu.co y telefono 3112345678 a la lista de contactos.
          * La lista de contactos ahora tiene un tamaño igual a 1.
        * */

        assertTrue(addResult);

        assertEquals(contactBook.getContacts().get(0).getName(), name);
        assertEquals(contactBook.getContacts().get(0).getEmail(), email);
        assertEquals(contactBook.getContacts().get(0).getPhone(), phone);

        assertEquals(contactBook.getContacts().size(), 1);
    }

    @Test
    void test3(){
        // init
        setupScenary3();

        // act
        String name="Santiago Hurtado";
        String email= "santi@icesi.edu.co";
        String phone= "3123874610";

        boolean addResult = contactBook.addContact(name, email, phone);

        // assert

        assertTrue(addResult);

        assertEquals(contactBook.getContacts().get(3).getName(), name);
        assertEquals(contactBook.getContacts().get(3).getEmail(), email);
        assertEquals(contactBook.getContacts().get(3).getPhone(), phone);

        assertEquals(contactBook.getContacts().size(), 4);
    }

}
