package org.icesi.animationv2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.icesi.animationv2.model.Avatar;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;

    private Avatar avatar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = canvas.getGraphicsContext2D();
        avatar = new Avatar(canvas, 0, 0, 75, 75);
        avatar.start();

        initEvents();
        // Hilo grafico de JavaFX
        Platform.runLater(() -> {
            // LLamar a un hilo
            new Thread(
                    () -> {
                        while (true) {
                            try {
                                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                                avatar.paint();
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }


                        }
                    }
            ).start();
        });
    }

    public void initEvents(){
        canvas.setOnKeyPressed(event -> {
            avatar.setOnKeyPressed(event);
        });

        canvas.setOnKeyReleased(event -> {
            avatar.setOnKeyReleased(event);
        });
    }

}