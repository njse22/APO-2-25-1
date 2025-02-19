package model;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {

    private List<Contact> contacts;

    public ContactBook() {
        this.contacts = new ArrayList<Contact>();
    }

    public boolean addContact(String name, String email, String phone) {
        Contact newContact = new Contact(name, email, phone);
        return contacts.add(newContact);
    }

    public Contact search(String email) {
        Contact foundContact = null;
        boolean found = false;
        for(int i = 0; i < contacts.size() && !found; i++) {
            if(contacts.get(i).getEmail().equals(email)) {
                foundContact = contacts.get(i);
                found = true;
            }
        }
        return foundContact;
    }

    public Contact remove(String email){
        int index = contacts.indexOf(search(email));
        return contacts.remove(index);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
