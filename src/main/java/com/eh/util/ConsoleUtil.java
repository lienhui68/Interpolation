package com.eh.util;

import com.eh.container.ConsolePanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

/**
 * Created by David on 2016/4/10.
 */
public class ConsoleUtil {
    private static Logger logger = LoggerFactory.getLogger(ConsoleUtil.class);
    private static ConsolePanel consolePanel;

    static {
        consolePanel = new ConsolePanel();
    }

    public static ConsolePanel getConsolePanel() {
        return consolePanel;
    }

    public static void write(String str) {
        insertDocument(str, Color.WHITE);
    }

    public static void warn(String str) {
        insertDocument(str, Color.RED);
    }

    private static void insertDocument(String text, Color textColor)
    {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, textColor);
        StyleConstants.setFontSize(set, 17);
        Document doc = consolePanel.getTextPane().getStyledDocument();
        try {
            doc.insertString(doc.getLength(), text + "\n", set);
        } catch (BadLocationException e) {
            logger.info("Error occurred in inserting document to text pane");
        }
    }
}
