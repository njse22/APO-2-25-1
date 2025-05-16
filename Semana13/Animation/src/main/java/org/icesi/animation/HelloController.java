package org.icesi.animation;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.icesi.animation.actions.Action1;
import org.icesi.animation.model.Element;
import org.icesi.animation.model.Element2;
import org.icesi.animation.model.Element3;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;

    private Element e1;
    private Element2 e2;
    private Element3 e3;

    private boolean isRunning = true;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        e1 = new Element(canvas, Color.BLUE, 100, 250, 0, 50, 50,
                () -> {
                    System.out.println("Hello World");
                });
        e2 = new Element2(canvas, Color.RED, 250, 0, 0, 50, 50);

        Action1 a1 = new Action1();

        e3 = new Element3(canvas, Color.GREEN, 2000, 0, 0, 50, 50, a1 );
        a1.setElement(e3);

        e1.start();
        new Thread(e2).start();
        e3.start();

        gc = canvas.getGraphicsContext2D();

        Platform.runLater(() -> {

            new Thread( () -> {
                int y = 0;
                while (isRunning){

                    try {
                        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                        e1.paint();
                        e2.paint();
                        e3.paint();

                        double distance = Math.sqrt(
                                Math.pow(e1.getX() - e2.getX(), 2) +
                                Math.pow(e1.getY() - e2.getY(), 2)
                        );

                        System.out.println("Distance: " + distance);

                        if (distance <= 60){
                            e1.setAlive(false);
                            gc.setFill(Color.CYAN);
                            gc.fillRect(e2.getX()+50, e2.getY()+50, 25, 25);

                        }


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