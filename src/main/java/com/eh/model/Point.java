package com.eh.model;

import java.util.Comparator;

/**
 * Created by David on 2016/4/10.
 */
public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(){
    }

    public Point(int x, int y) {
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

    @Override
    public int compareTo(Point o) {
        return this.getX() - o.getX();
    }
}
