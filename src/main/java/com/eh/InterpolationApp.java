package com.eh;

import com.eh.container.MainFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by David Li on 2016/4/9.
 */
public class InterpolationApp {
    private static Logger logger = LoggerFactory.getLogger(InterpolationApp.class);

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                logger.info("--------------begin the demo of interpolation----------");
                new MainFrame().setVisible(true);
                logger.info("--------------end the demo of interpolation----------");
            }
        });
    }
}
