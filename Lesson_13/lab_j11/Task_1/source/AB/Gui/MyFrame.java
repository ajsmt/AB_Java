package AB.Gui;

import javax.swing.*;

import AB.Data.KeyboardSubject;

import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame {
    public MyFrame(String title, int WIDTH, int HEIGHT) {
        super(title);

        setResizable(false);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH + 100, HEIGHT + 100));

        KeyboardSubject subject = new KeyboardSubject();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                subject.setCurrentKey(e.getKeyChar());
            }
        });

        setFocusable(true);
        setFocusableWindowState(true);

        PressedKeyDisplayObserverLabel labelObserver = new PressedKeyDisplayObserverLabel();
        subject.attach(labelObserver);
        JPanel displayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        displayPanel.add(labelObserver);
        add(displayPanel);

        PressedKeyLogObserverPanel keyLogger = new PressedKeyLogObserverPanel();
        subject.attach(keyLogger);
        JScrollPane scrollPane = new JScrollPane(keyLogger);
        scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(scrollPane);
        
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
