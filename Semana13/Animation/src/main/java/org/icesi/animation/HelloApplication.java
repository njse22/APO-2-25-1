package org.icesi.animation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        HelloController controller = fxmlLoader.getController();

        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.setOnCloseRequest( event -> {
            controller.setRunning(false);
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}