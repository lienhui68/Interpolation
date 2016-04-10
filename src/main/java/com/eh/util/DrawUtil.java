package com.eh.util;

import com.eh.constant.Constants;
import com.eh.container.ControlPanel;
import com.eh.model.Point;
import com.eh.model.ScreenLocation;

import java.awt.*;
import java.util.List;

/**
 * Created by David on 2016/4/10.
 */
public class DrawUtil {
    public static int MIN_X = 80;
    public static int MAX_X = 720;
    public static int MIN_Y = 20;
    public static int MAX_Y = 400;
    public static int CEN_X = 400;
    public static int CEN_Y = 260;

    public static Point convertScreenLocation2Point(ScreenLocation screenLocation) {
        return new Point(screenLocation.getX() - CEN_X, CEN_Y - screenLocation.getY());
    }

    public static void drawCoordinateSystemSignX(Graphics2D g) {
        for (int x = -300; x <= 300; x += 100) {
            if (x == 0)
                continue;
            Point p = new Point(x, 0);
            ScreenLocation screenLocation = convertPoint2ScreenLocation(p);
            g.drawLine(screenLocation.getX(), screenLocation.getY(), screenLocation.getX(), screenLocation.getY() - 5);
            g.drawString(String.valueOf(x), screenLocation.getX() - 18, screenLocation.getY() + 15);
        }

    }

    public static void drawCoordinateSystemSignY(Graphics2D g) {
        for (int y = -200; y <= 200; y += 100) {
            if (y == 0)
                continue;
            Point p = new Point(0, y);
            ScreenLocation screenLocation = convertPoint2ScreenLocation(p);
            g.drawLine(screenLocation.getX(), screenLocation.getY(), screenLocation.getX() + 5, screenLocation.getY());
            g.drawString(String.valueOf(y), screenLocation.getX() + 10, screenLocation.getY() + 4);
        }
    }

    public static void drawClickPoints(Graphics2D g, List<Point> points) {
        for (Point p : points) {
            g.setColor(Color.BLACK);
            ScreenLocation screenLocation = convertPoint2ScreenLocation(p);
            g.fillOval(screenLocation.getX()-3, screenLocation.getY() -3, 6, 6);
        }
    }

    public static void drawViewPoints(Graphics2D g, List<Point> points) {
        switch (ControlPanel.interpolationKind) {
            case Lagrange:
                g.setColor(Constants.Color_Lagrange);
                break;
            case Newton:
                g.setColor(Constants.Color_Newton);
                break;
            case Spline:
                g.setColor(Constants.Color_Spline);
                break;
        }
        for (Point p : points) {
            ScreenLocation screenLocation = convertPoint2ScreenLocation(p);
            g.drawLine(screenLocation.getX(), screenLocation.getY(), screenLocation.getX(), screenLocation.getY());
        }
    }

    private static ScreenLocation convertPoint2ScreenLocation(Point point) {
        return new ScreenLocation(point.getX() + CEN_X, CEN_Y - point.getY());
    }
}
