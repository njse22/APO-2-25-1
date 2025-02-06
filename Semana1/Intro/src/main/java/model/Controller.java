package model;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private ArrayList<Person> people;
    private File data;

    public Controller() {
        people = new ArrayList<>();
        data = new File("lista.json");
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void addPerson(String name, int age){
        Person person = new Person(name, age);
        people.add(person);
    }

    public String fileProperties(){
        String mjs = data.getAbsolutePath();

        try {
            data.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return mjs;
    }

    public String getJsonData(){
        Gson gson = new Gson();
        String json = gson.toJson(people);

        return json;
    }

}
