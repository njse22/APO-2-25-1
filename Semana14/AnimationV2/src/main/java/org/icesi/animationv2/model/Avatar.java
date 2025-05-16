package org.icesi.animationv2.model;

import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Avatar extends Thread {

    private Canvas canvas;
    private GraphicsContext gc;

    private int frame;
    // 0 = idle | 1 = run
    private int state;

    private ArrayList<Image> idles;
    private ArrayList<Image> run;

    private double x;
    private double y;
    private double w;
    private double h;

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private boolean a;
    private boolean s;

    public Avatar(Canvas canvas, double x, double y, double w, double h) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        idles = new ArrayList<>();
        run = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Image image = new  Image(getClass().getResourceAsStream("/animation/hero/idle/adventurer-idle-2-0"+i+".png"));
            idles.add(image);
        }

        for (int i = 0; i < 5; i++) {
            Image image = new  Image(getClass().getResourceAsStream("/animation/hero/run/adventurer-run-0"+i+".png"));
            run.add(image);
        }
    }

    public void paint() {
        onMove();

        if(state == 0){
            gc.drawImage(idles.get(frame%3),x, y, h, w);
            frame++;
        }

        if(state == 1){
            gc.drawImage(run.get(frame%(run.size()-1)),x, y, h, w);
            frame++;
        }
    }

    @Override
    public void run(){
        while (true){
            try {
                // System.out.println("AVATAR:: RUN >> x " + x);
                // System.out.println("AVATAR:: RUN >> y " + y);

                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onMove(){
        if(up){
            y -= 10;
        }
        if (down){
            y += 10;
        }
        if (left){
            x -= 10;
        }
        if (right){
            x += 10;
        }

        if (s && a){
            System.out.println("HERE");
        }
    }

    public void setOnKeyPressed(KeyEvent e){
        System.out.println(e.getCode());

        switch (e.getCode()) {
            case UP -> {
                state = 1;
                up = true;
            }
            case DOWN -> {
                state = 1;
                down = true;
            }
            case LEFT -> {
                state = 1;
                left = true;
            }
            case RIGHT -> {
                state = 1;
                right = true;
            }

            case A -> a = true;
            case S -> s = true;
        }
    }

    public void setOnKeyReleased(KeyEvent e){
        switch (e.getCode()) {
            case UP -> {
                up = false;
                state = 0;
            }
            case DOWN -> {
                down = false;
                state = 0;
            }
            case LEFT -> {
                left = false;
                state = 0;
            }
            case RIGHT -> {
                right = false;
                state = 0;
            }
            case A -> a = false;
            case S -> s = false;
        }
    }


}
