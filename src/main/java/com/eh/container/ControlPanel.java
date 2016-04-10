package com.eh.container;

import com.eh.constant.Constants;
import com.eh.enums.InterpolationKind;
import com.eh.util.ConsoleUtil;
import com.eh.util.GraphicsPanelUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by David on 2016/4/10.
 */
public class ControlPanel extends JPanel {
    private static int Panel_Height;
    public static InterpolationKind interpolationKind = InterpolationKind.Lagrange;

    private JButton lagrangeButton;
    private JButton newtonButton;
    private JButton splineButton;
    private JButton clearButton;

    public ControlPanel() {
        init();
    }

    private void init() {
        initControlPanel();
        initButtons();
        initEventListeners();
    }

    private void initControlPanel() {
        Panel_Height = (int) (Constants.App_Height * Constants.Control_Height_Ratio);
        this.setPreferredSize(new Dimension(Constants.App_Width, Panel_Height));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 40, 20);
        this.setBackground(new Color(57, 60, 62));
        this.setLayout(flowLayout);
    }

    private void initButtons() {
        /*** Display Lagrange Interpolation */
        lagrangeButton = new JButton("Lagrange");
        lagrangeButton.setFocusPainted(false);
        lagrangeButton.setPreferredSize(new Dimension(Constants.Button_Width, Constants.Button_Height));
        lagrangeButton.setForeground(Constants.Color_Lagrange);
        this.add(lagrangeButton);

        /*** Display Newton Interpolation */
        newtonButton = new JButton("Newton");
        newtonButton.setFocusPainted(false);
        newtonButton.setPreferredSize(new Dimension(Constants.Button_Width, Constants.Button_Height));
        newtonButton.setForeground(Constants.Color_Newton);
        this.add(newtonButton);

        /*** Display Spline Interpolation */
        splineButton = new JButton("Spline");
        splineButton.setFocusPainted(false);
        splineButton.setPreferredSize(new Dimension(Constants.Button_Width, Constants.Button_Height));
        splineButton.setForeground(Constants.Color_Spline);
        this.add(splineButton);

        /*** Clear the Graphics Panel */
        clearButton = new JButton("Clear");
        clearButton.setFocusPainted(false);
        clearButton.setPreferredSize(new Dimension(Constants.Button_Width, Constants.Button_Height));
        this.add(clearButton);
    }

    private void initEventListeners() {
        lagrangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpolationKind = InterpolationKind.Lagrange;
                ConsoleUtil.write(String.format("Interpolation Arithmetic switched to %s", InterpolationKind.Lagrange.toString()));
                GraphicsPanelUtil.repaintPanel();
            }
        });

        newtonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpolationKind = InterpolationKind.Newton;
                ConsoleUtil.write(String.format("Interpolation Arithmetic switched to %s", InterpolationKind.Newton.toString()));
                GraphicsPanelUtil.repaintPanel();
            }
        });

        splineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpolationKind = InterpolationKind.Spline;
                ConsoleUtil.write(String.format("Interpolation Arithmetic switched to %s", InterpolationKind.Spline.toString()));
                GraphicsPanelUtil.repaintPanel();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GraphicsPanelUtil.clearAllPoints();
                GraphicsPanelUtil.repaintPanel();
            }
        });
    }
}
