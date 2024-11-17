package AB.Gui;

import javax.swing.*;

import AB.Gui.FirstPanel.FirstMyPanel;
import AB.Gui.SecondPanel.SecondMyPanel;
import AB.Gui.ThirdPanel.ThirdMyPanel;

import java.awt.*;

public class MyFrame extends JFrame {
    private FirstMyPanel firstMyPanel;
    private SecondMyPanel secondMyPanel;
    private ThirdMyPanel thirdMyPanel;

    public MyFrame(String title, int WIDTH, int HEIGHT, int n, int m) {
        super(title);

        setResizable(false);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH + 100, HEIGHT + 100));

        firstMyPanel = new FirstMyPanel(WIDTH, HEIGHT);
        secondMyPanel = new SecondMyPanel(WIDTH, HEIGHT, n, m);
        thirdMyPanel = new ThirdMyPanel(WIDTH, HEIGHT);

        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel tab1Panel = new JPanel(new BorderLayout());
        tab1Panel.add(firstMyPanel, BorderLayout.CENTER);
        tab1Panel.setPreferredSize(new Dimension(WIDTH + 50, HEIGHT + 50));
        
        JPanel tab2Panel = new JPanel(new BorderLayout());
        tab2Panel.add(secondMyPanel, BorderLayout.CENTER);
        tab2Panel.setPreferredSize(new Dimension(WIDTH + 50, HEIGHT + 50));
        
        JPanel tab3Panel = new JPanel(new BorderLayout());
        tab3Panel.add(thirdMyPanel, BorderLayout.CENTER);
        tab3Panel.setPreferredSize(new Dimension(WIDTH + 50, HEIGHT + 50));
        
        tabbedPane.addTab("Task 1", tab1Panel);
        tabbedPane.addTab("Task 2", tab2Panel);
        tabbedPane.addTab("Task 3", tab3Panel);
        
        add(tabbedPane, BorderLayout.CENTER);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
