package org.icesi.javafx.model;

public class Student {

    private String name;
    private String code;
    private int years;

    public Student(String name, String code, int years) {
        this.name = name;
        this.code = code;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
