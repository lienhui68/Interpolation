package com.eh.container;

import com.beust.jcommander.internal.Lists;
import com.eh.constant.Constants;
import com.eh.model.Point;
import com.eh.model.ScreenLocation;
import com.eh.util.ConsoleUtil;
import com.eh.util.DrawUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * Created by David on 2016/4/10.
 */
public class GraphicsPanel extends JPanel {
    /*** Graphics Variable */

    /***
     * Business Variable
     */
    private boolean drawable;
    private List<Point> clickPoints = Lists.newArrayList();
    private List<Point> viewPoints = Lists.newArrayList();

    public GraphicsPanel() {
        initGraphicsPanel();
        initEventListeners();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        initCoordinateSystem(g2d);
        drawClickPoints(g2d);
        drawViewPoints(g2d);
    }

    private void initGraphicsPanel() {
        this.setPreferredSize(new Dimension(Constants.App_Width, (int) (Constants.App_Height * Constants.Graphics_Height_Ratio)));
        this.setBackground(Color.WHITE);
    }

    public boolean isDrawable() {
        return drawable;
    }

    public void setDrawable(boolean drawable) {
        this.drawable = drawable;
    }

    private void initCoordinateSystem(Graphics2D g) {
        g.drawLine(80, 260, 720, 260);
        g.drawLine(400, 20, 400, 500);

        int[] h_pointX = new int[] { 710, 720, 710, 712 };
        int[] h_pointY = new int[] { 255, 260, 265, 260 };
        g.fillPolygon(h_pointX, h_pointY, 4);

        int[] v_pointX = new int[] { 400, 395, 400, 405 };
        int[] v_pointY = new int[] { 20, 30, 28, 30 };
        g.fillPolygon(v_pointX, v_pointY, 4);

        g.setFont(new Font("Courier New", Font.BOLD, 15));
        g.drawString("x", DrawUtil.MAX_X - 10, DrawUtil.CEN_Y + 15);
        g.drawString("y", DrawUtil.CEN_X + 8, DrawUtil.MIN_Y + 10);
        g.drawString("O", DrawUtil.CEN_X + 5, DrawUtil.CEN_Y + 15);

        DrawUtil.drawCoordinateSystemSignX(g);
        DrawUtil.drawCoordinateSystemSignY(g);
    }

    private void initEventListeners() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point p = DrawUtil.convertScreenLocation2Point(new ScreenLocation(e.getX(), e.getY()));
                if (!isLegal(p)) {
                    ConsoleUtil.warn(String
                            .format("You had clicked the location [%d, %d], please click the screen in the legal scope: X[%d, %d], Y[%d, %d].",
                                    p.getX(), p.getY(), -300, 300, -200, 200));
                } else {
                    ConsoleUtil.write(String.format("Pressed [%d, %d]...", p.getX(), p.getY()));
                }
                clickPoints.add(p);
                viewPoints.add(p);
                JPanel panel = (JPanel) e.getSource();
                panel.repaint();
            }
        });
    }

    private boolean isLegal(Point point) {
        return point.getX() >= -300 && point.getX() <= 300 && point.getY() >= -200 && point.getY() <= 200;
    }

    private void drawClickPoints(Graphics2D g) {
        DrawUtil.drawClickPoints(g, clickPoints);
    }

    private void drawViewPoints(Graphics2D g) {
        DrawUtil.drawClickPoints(g, viewPoints);
    }

    public List<Point> getViewPoints() {
        return viewPoints;
    }

    public List<Point> getClickPoints() {
        return clickPoints;
    }

    public void setViewPoints(List<Point> viewPoints) {
        this.viewPoints = viewPoints;
    }
}
