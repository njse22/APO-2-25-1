package org.icesi.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label labelWelcome;

    @FXML
    protected void onHelloButtonClick(){
        labelWelcome.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onSetProperty(){
        labelWelcome.setText("Nuevo texto");
    }
}