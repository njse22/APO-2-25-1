package org.icesi.javafx.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.icesi.javafx.model.Student;

import java.util.ArrayList;

public class StudentsController {

    // Referencia a si mismo
    private static StudentsController instance;

    private ObservableList<Student> students;

    // Constructor privado
    private StudentsController() {
        students = FXCollections.observableArrayList();
    }

    public static StudentsController getInstance(){
        if(instance == null){
            instance = new StudentsController();
        }
        return instance;
    }

    public void addStudent(String name, String code, int years){
        Student student = new Student(name, code, years);
        students.add(student);

    }

    public ObservableList<Student> getStudents() {
        return students;
    }

    public void setStudents(ObservableList<Student> students) {
        this.students = students;
    }

    public String printStudents(){
        String msg = "";
        for (Student student: students){
            msg += student.getName() + "," + student.getCode() + ", " + student.getYears() + "\n";
        }
        return msg;
    }

}
