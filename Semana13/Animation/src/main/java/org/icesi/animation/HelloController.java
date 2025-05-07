package org.icesi.animation;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;

    private boolean isRunning = true;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);


        Platform.runLater(() -> {

            new Thread( () -> {
                int y = 0;
                while (isRunning){

                    try {
                        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        gc.fillRect(0, y, 50, 50);
                        y++;
                        System.out.println("HelloController::Hilo >>> Valor de y: " + y);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } ).start();

        });
    }


    public void setRunning(boolean running) {
        isRunning = running;
    }
}