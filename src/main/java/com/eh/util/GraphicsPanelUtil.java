package com.eh.util;

import com.eh.container.GraphicsPanel;

/**
 * Created by David on 2016/4/10.
 */
public class GraphicsPanelUtil {
    public static GraphicsPanel graphicsPanel = new GraphicsPanel();

    public static GraphicsPanel getGraphicsPanel() {
        return graphicsPanel;
    }

    public static void repaintPanel() {
        graphicsPanel.repaint();
    }

    public static void clearAllPoints() {
        graphicsPanel.getClickPoints().clear();
        graphicsPanel.getViewPoints().clear();
    }
}
