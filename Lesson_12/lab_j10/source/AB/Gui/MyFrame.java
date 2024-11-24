package AB.Gui;

import javax.swing.*;

import AB.Set.MySet;

import java.awt.*;

public class MyFrame extends JFrame {
    private MySet<Integer> A;
    private MySetPanel<Integer> panelA;
    private MySetControlPanel<Integer> controlPanelA;

    private MySet<Integer> B;
    private MySetPanel<Integer> panelB;
    private MySetControlPanel<Integer> controlPanelB;

    private MySet<Integer> C;
    private MySetPanel<Integer> panelC;
    private MySetOperationsPanel<Integer> controlPanelC;

    public MyFrame(String title, int WIDTH, int HEIGHT) {
        super(title);

        setResizable(false);
        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(WIDTH + 100, HEIGHT + 100));

        A = new MySet<>();
        panelA = new MySetPanel<>(A);
        controlPanelA = new MySetControlPanel<>(A, panelA);
        JPanel firstPanel = new JPanel(new GridLayout(2, 1));
        firstPanel.add(panelA);
        firstPanel.add(controlPanelA);
        firstPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        add(firstPanel);

        B = new MySet<>();
        panelB = new MySetPanel<>(B);
        controlPanelB = new MySetControlPanel<>(B, panelB);
        JPanel secondPanel = new JPanel(new GridLayout(2, 1));
        secondPanel.add(panelB);
        secondPanel.add(controlPanelB);
        secondPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(secondPanel);

        C = new MySet<>();
        panelC = new MySetPanel<>(C);
        controlPanelC = new MySetOperationsPanel<>(A, B, C, panelC);
        JPanel thirdPanel = new JPanel(new GridLayout(2, 1));
        thirdPanel.add(panelC);
        thirdPanel.add(controlPanelC);
        thirdPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(thirdPanel);

        setExampleValues();

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setExampleValues() {
        A.add(1);
        A.add(2);
        A.add(3);
        B.add(3);
        B.add(4);
        B.add(5);
        B.add(9);

        panelA.updateList();
        panelB.updateList();
    }
}
