package com.eh.container;

import com.eh.constant.Constants;
import com.eh.util.ConsoleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

/**
 * Created by David on 2016/4/10.
 */
public class ConsolePanel extends JPanel {
    private static Logger logger = LoggerFactory.getLogger(ConsoleUtil.class);
    private static int Panel_Height;

    private JTextPane textPane;

    public ConsolePanel() {
        init();
    }

    private void init() {
        initConsolePanel();
        initTextPane();
    }

    private void initConsolePanel() {
        Panel_Height = (int) (Constants.App_Height * Constants.Console_Height_Ratio);
        this.setPreferredSize(new Dimension(Constants.App_Width, Panel_Height));
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(65, 76, 94));
    }

    private void initTextPane() {
        JLabel consoleLabel = new JLabel("Console Output");
        consoleLabel.setForeground(Color.WHITE);
        this.add(consoleLabel, BorderLayout.NORTH);
        textPane = new JTextPane();
        textPane.setBackground(new Color(43, 43, 43));
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, Color.WHITE);
        StyleConstants.setFontSize(set, 17);
        Document doc = textPane.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), "Welcome to Use Interpolation Demo App...\n", set);
        } catch (BadLocationException e) {
            logger.info("Error occurred in inserting document to text pane");
        }
        textPane.setEditable(false);
        this.add(new JScrollPane(textPane), BorderLayout.CENTER);
    }

    public JTextPane getTextPane() {
        return textPane;
    }
}
