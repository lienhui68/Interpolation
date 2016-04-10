package com.eh.container;

import com.eh.constant.Constants;
import com.eh.util.ConsoleUtil;
import com.eh.util.GraphicsPanelUtil;
import com.eh.util.PropertyUtil;
import com.eh.util.TextUtil;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

/**
 * Created by David on 2016/4/10.
 */
public class MainFrame extends JFrame {
    /***
     * Inner Containers
     */
    private GraphicsPanel graphicsPanel;
    private ControlPanel controlPanel;
    private ConsolePanel consolePanel;

    /***
     * Menu Bar
     */
    private JMenuBar menuBar;
    /***
     * File Menu Components
     */
    private JMenu fileMenu;
    private JMenuItem menuOpen;
    private JMenuItem menuSave;
    private JMenuItem menuSaveAs;
    private JMenuItem menuClose;

    /***
     * Control Menu Components
     */
    private JMenu controlMenu;
    private JMenuItem menuControl; // execute or pause

    /***
     * About Menu Components
     */
    private JMenu helpMenu;
    private JMenuItem menuAbout;

    public MainFrame() {
        super(PropertyUtil.getProperty("app.name"));
        init();
    }

    private void init() {
        initGlobalFont();
        initFrame();
        initMenus();
        initMenuEventListeners();
        setShortKeyForMenus();
        addOtherContainer();
    }

    private void initFrame() {

        this.setBounds(Constants.App_Begin_X, Constants.App_Begin_Y, Constants.App_Width, Constants.App_Height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initMenus() {
        // set file menus
        fileMenu = new JMenu("File");
        fileMenu.setForeground(Color.WHITE);
        menuOpen = new JMenuItem("Open");
        menuSave = new JMenuItem("Save");
        menuSaveAs = new JMenuItem("Save as");
        menuClose = new JMenuItem("Close");

        fileMenu.add(menuOpen);
        fileMenu.addSeparator();
        fileMenu.add(menuSave);
        fileMenu.add(menuSaveAs);
        fileMenu.addSeparator();
        fileMenu.add(menuClose);

        // set control menus
        controlMenu = new JMenu("Control");
        controlMenu.setForeground(Color.WHITE);
        menuControl = new JMenuItem("execute"); // status switch by execute and pause
        controlMenu.add(menuControl);

        // set about menus
        helpMenu = new JMenu("Help");
        helpMenu.setForeground(Color.WHITE);
        menuAbout = new JMenuItem("About");
        helpMenu.add(menuAbout);

        // set menu bar
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(57, 60, 62));
        menuBar.add(fileMenu);
        menuBar.add(controlMenu);
        menuBar.add(helpMenu);

        menuBar.setPreferredSize(new Dimension(Constants.App_Width, Constants.MenuBar_Height));
        setJMenuBar(menuBar);
    }

    private void setShortKeyForMenus() {
        menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        menuClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        menuControl.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
    }

    private void initMenuEventListeners() {
        initMenuOpenEventListener();
        initMenuSaveEventListener();
        initMenuSaveAsEventListener();
        initMenuCloseEventListener();
        initMenuControlEventListener();
        initMenuAboutEventListener();
    }

    private void initMenuOpenEventListener() {

    }

    private void initMenuSaveEventListener() {

    }

    private void initMenuSaveAsEventListener() {

    }

    private void initMenuCloseEventListener() {

    }

    private void initMenuControlEventListener() {
        menuControl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphicsPanel.setDrawable(!graphicsPanel.isDrawable());
                ConsoleUtil.write(String
                        .format("%s demonstrate interpolation arithmetic...", graphicsPanel.isDrawable() ? "Start" : "Suspend"));
            }
        });
    }

    private void initMenuAboutEventListener() {
        menuAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InfoDialog().setVisible(true);
            }
        });
    }

    private class InfoDialog extends JDialog {

        public InfoDialog() {
            JLabel infoLabel = new JLabel(TextUtil.txt2String(Constants.App_Info_Url));
            infoLabel.setVerticalAlignment(JLabel.TOP);
            infoLabel.setPreferredSize(new Dimension(420, 250));
            infoLabel.setOpaque(true);
            infoLabel.setBackground(new Color(43, 43, 43));
            infoLabel.setForeground(Color.WHITE);
            setTitle("App About");
            setResizable(false);
            setBounds(Constants.App_Begin_X + 180, Constants.App_Begin_Y + 150, 420, 250);
            add(infoLabel);
        }
    }

    private void addOtherContainer() {
        addGraphicsPanel();
        addControlPanel();
        addConsolePanel();
    }

    private void addGraphicsPanel() {
        graphicsPanel = GraphicsPanelUtil.getGraphicsPanel();
        this.add(graphicsPanel, BorderLayout.NORTH);
    }

    private void addControlPanel() {
        controlPanel = new ControlPanel();
        this.add(controlPanel, BorderLayout.CENTER);
    }

    private void addConsolePanel() {
        consolePanel = ConsoleUtil.getConsolePanel();
        this.add(consolePanel, BorderLayout.SOUTH);
    }

    private static void initGlobalFont() {
        FontUIResource fontUIResource = new FontUIResource(Constants.App_Font);
        for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontUIResource);
            }
        }
    }

}
