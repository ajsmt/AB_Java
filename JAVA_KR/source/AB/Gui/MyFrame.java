package AB.Gui;

import javax.swing.*;

import java.awt.*;

public class MyFrame extends JFrame{


    public MyFrame(String title) {
        super(title);
        setResizable(false);
        setLayout(new BorderLayout());
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
