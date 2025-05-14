package org.icesi.animation.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Element3 extends Thread {

    private double x;
    private double y;
    private double width;
    private double height;

    private Canvas canvas;
    private GraphicsContext gc;

    private int timer;
    private boolean isAlive;

    private Color color;

    public Element3(Canvas canvas, Color color, int timer,
                   double x, double y, double width, double height, Runnable runnable) {
        super(runnable);
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.color = color;
        this.timer = timer;
        this.isAlive = true;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(){
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
