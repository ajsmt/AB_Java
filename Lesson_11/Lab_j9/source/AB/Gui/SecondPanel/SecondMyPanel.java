package AB.Gui.SecondPanel;

import javax.swing.*;

import java.awt.*;

public class SecondMyPanel extends JPanel {
    public SecondMyPanel(int WIDTH, int HEIGHT, int n, int m) {
        setLayout(new GridLayout(n, m));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        MyButtonListener listener = new MyButtonListener();

        for (int i = 0; i < n * m; i++) {
            MyButton button = new MyButton(String.format("%d", i + 1));
            button.addMouseListener(listener);  
            add(button);
        }

        setVisible(true);
    }
}
