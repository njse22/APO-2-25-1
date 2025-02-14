package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exceptions.PersonAllReadyExist;
import exceptions.PersonRuntimeException;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
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
    private Path dataCsv;

    public Controller() {

        Path dataProject = Paths.get(System.getProperty("user.dir"));
        System.out.println("Data Project: "+dataProject);
        dataFolder = dataProject.resolve(dataProject+"/src/main/data");
        dataJson = dataFolder.resolve("people.json");
        dataCsv = dataFolder.resolve("people.csv");

        people = new ArrayList<>();
        data = new File("lista.json");
    }

    public void inicialize() throws IOException {
        if(!Files.exists(dataFolder)){
            Files.createDirectories(dataFolder);
            if(!Files.exists(dataJson)){
                Files.createFile(dataJson);
            }
            if(!Files.exists(dataCsv)){
                Files.createFile(dataCsv);
            }
        }
    }

    public void saveCsv(){
        try {
            inicialize();
            // Formato -> CSV
            String csvContent = "";
            for (Person person: people){
                csvContent += person.getName() + "," + person.getAge()
                        + "," + person.getHeight() + "," + person.getWeight() + "\n";
            }

            // Guardar / Escribir
            Files.writeString(dataCsv, csvContent);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveJson(){
        try {
            // Iniciar los recursos
            inicialize();

            // Dar un formato de archivo
            Gson gson = new Gson();
            String jsonData = gson.toJson(people);

            // Guardar la información
            Files.writeString(dataJson, jsonData);
        } catch (IOException e) {
            System.out.println("No se pudo crear la carpeta o archivo");
        }
    }

    public void loadCsv(){
        try {
            List<String> csvData = Files.readAllLines(dataCsv, StandardCharsets.UTF_8);
            // System.out.println("Controller::loadCsv >>>" +csvData);

            for(String line: csvData){
                String[] params = line.split(",");
                System.out.println("Controller::loadCsv >>>");
                Person person = new Person(params[0], Integer.parseInt(params[1]),
                        Double.parseDouble(params[2]), Double.parseDouble(params[3]));

                people.add(person);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadJson(){
        try {

            // Cargamos / leemos la información
            String jsonData = Files.readString(dataJson);
            //System.out.println("DATA :: "+jsonData);

            // Lo cargamos a un Objeto de Java
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

    public void addPerson(String name, int age, double height, double weight) throws PersonAllReadyExist{
        Person person = new Person(name, age, height, weight);

        if(isInList(person)){
            throw new PersonAllReadyExist("La persona ya ha sido creada");
        }
        else {
            people.add(person);
        }
    }

    public boolean isInList(Person person){
        boolean found = false;
        for(int i = 0; i< people.size() && !found; i++){
            if(people.get(i).getName().equals(person.getName())){
                found = true;
            }
        }
        return found;
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
