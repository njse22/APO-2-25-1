package org.icesi.javafx.control;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.icesi.javafx.model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class ListStudentsController implements Initializable {


    @FXML
    private TableView<Student> studentsTableView;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> codeColumn;

    @FXML
    private TableColumn<Student, Integer> ageColumn;

    private StudentsController controller;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = StudentsController.getInstance();

        // TableView Se suscriba a un objeto observable
        studentsTableView.setItems(controller.getStudents());

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Student, String>("name"));

        codeColumn.setCellValueFactory(
                new PropertyValueFactory<Student, String>("code"));

        ageColumn.setCellValueFactory(
                new PropertyValueFactory<Student, Integer>("years"));

    }
}
