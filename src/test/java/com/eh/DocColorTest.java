package com.eh;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

/**
 * Created by David on 2016/4/10.
 */
public class DocColorTest extends JFrame {
    JTextPane textPane = new JTextPane();
    JPanel contPane = new JPanel();

    public DocColorTest() {
        super("DocColorTest");
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((d.width - 300) / 2, (d.height - 200) / 2, 300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contPane.setLayout(new BorderLayout());
        contPane.add(new JScrollPane(textPane), "Center");

        insertDocument("Blue text", Color.BLUE);
        insertDocument("Red text", Color.RED);

        setContentPane(contPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DocColorTest();
    }

    public void insertDocument(String text, Color textColor)//根据传入的颜色及文字，将文字插入文本域
    {
        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, textColor);//设置文字颜色
        StyleConstants.setFontSize(set, 12);//设置字体大小
        Document doc = textPane.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), text, set);//插入文字
        } catch (BadLocationException e) {
        }
    }
}