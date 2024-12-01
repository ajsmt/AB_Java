package AB.Gui;

import javax.swing.*;

import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(String title, int WIDTH, int HEIGHT) {
        super(title);

        setResizable(false);
        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(WIDTH + 100, HEIGHT + 100));

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
