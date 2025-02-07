package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exceptions.PersonAllReadyExist;
import exceptions.PersonRuntimeException;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private ArrayList<Person> people;
    private File data;

    private Path dataFolder;
    private Path dataJson;


    public Controller() {

        Path dataProject = Paths.get(System.getProperty("user.dir"));
        System.out.println("Data Project: "+dataProject);
        dataFolder = dataProject.resolve(dataProject+"/src/main/data");
        dataJson = dataFolder.resolve("people.json");

        people = new ArrayList<>();
        data = new File("lista.json");
    }

    public void inicialize() throws IOException {
        if(!Files.exists(dataFolder)){
            Files.createDirectories(dataFolder);
            if(!Files.exists(dataJson)){
                Files.createFile(dataJson);
            }
        }
    }

    public void saveJson(){
        try {
            inicialize();
            Gson gson = new Gson();
            String jsonData = gson.toJson(people);
            Files.writeString(dataJson, jsonData);
        } catch (IOException e) {
            System.out.println("No se pudo crear la carpeta o archivo");
        }
    }

    public void loadJson(){
        try {
            String jsonData = Files.readString(dataJson);
            System.out.println("DATA :: "+jsonData);
            Gson gson = new Gson();

            Type peopleArray = new TypeToken<ArrayList<Person>>(){}.getType();

            people = gson.fromJson(jsonData, peopleArray);
        } catch (IOException e) {

        }
    }


    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void addPerson(String name, int age) throws PersonAllReadyExist{
        Person person = new Person(name, age);

        if(people.contains(person)){
            throw new PersonAllReadyExist("La persona ya ha sido creada");
        }
        else {
            people.add(person);
        }
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

    public String getJsonData() {
        Gson gson = new Gson();
        String json = gson.toJson(people);

        // if(true){
        //     throw new PersonRuntimeException("Person Run Time Exception Example");
        // }

        return json;
    }

}
