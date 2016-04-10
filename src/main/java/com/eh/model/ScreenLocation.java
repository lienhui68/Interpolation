package com.eh.model;

/**
 * Created by David on 2016/4/10.
 */
public class ScreenLocation {
    private int x;
    private int y;

    public ScreenLocation() {
    }

    public ScreenLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
