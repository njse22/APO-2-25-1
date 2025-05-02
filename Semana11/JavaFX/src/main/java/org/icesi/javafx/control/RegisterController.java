package org.icesi.javafx.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.icesi.javafx.HelloApplication;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField nameTextFiled;

    @FXML
    private TextField codeTextFiled;

    @FXML
    private TextField yearsTextFiled;

    @FXML
    private Label listStudentsLabel;


    private StudentsController controller;


    public void onRegisterEstudent(ActionEvent actionEvent) {
        String name = nameTextFiled.getText();
        String code = codeTextFiled.getText();
        int years = 0;

        try {
            years = Integer.parseInt(yearsTextFiled.getText());
            controller.addStudent(name, code, years);
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR DE ENTRADA");
            alert.setContentText("La edad debe ser un valor entero o numerico");
            alert.showAndWait();
        }

        HelloApplication.onWindowOpen("list-students-view.fxml");

        // String msg = "Lista de usuarios \n" + controller.printStudents();
        // listStudentsLabel.setText(msg);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = StudentsController.getInstance();

    }
}