package model;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String cc;

    public Person(String name, int age, String cc) {
        this.name = name;
        this.age = age;
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Person{" +
                " age=" + age +
                " cc=" + cc +
                '}';
    }

    @Override
    public int compareTo(Person person){
        int compare = this.age - person.age;
        // System.out.println("Person::compareTo::age "+ compare);

        // if(compare == 0){
        //     compare = this.name.compareTo(person.name);
        //     System.out.println("Person::compareTo::name "+ compare);
        // }
        return compare;
    }

}
