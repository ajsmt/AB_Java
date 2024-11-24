package AB.Gui;

import AB.Set.MySet;

import javax.swing.*;
import java.awt.*;

public class MySetOperationsPanel<T> extends JPanel {
    private JButton getUnionButton;
    private JButton getIntersectionButton;
    private JButton getDiffrenceButton;

    public MySetOperationsPanel(MySet<T> A, MySet<T> B, MySet<T> C, MySetPanel<T> panel) {
        setLayout(new GridLayout(3, 1));

        getUnionButton = new JButton("∪");
        getUnionButton.addActionListener(e -> {
            C.clear();
            C.addAll(A.getUnion(B));
            panel.updateList();
        });
        add(getUnionButton);

        getDiffrenceButton = new JButton("−");
        getDiffrenceButton.addActionListener(e -> {
            C.clear();
            C.addAll(A.getDiffrence(B));
            panel.updateList();
        });
        add(getDiffrenceButton);

        getIntersectionButton = new JButton("∩");
        getIntersectionButton.addActionListener(e -> {
            C.clear();
            C.addAll(A.getIntersection(B));
            panel.updateList();
        });
        add(getIntersectionButton);
    }
}