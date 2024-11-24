package AB.Gui;

import AB.Set.MySet;

import javax.swing.*;
import java.awt.*;

public class MySetControlPanel<T> extends JPanel {
    private JButton clearButton;
    private JButton deleteButton;
    private JButton addButton;
    private JSpinner spinner;


    public MySetControlPanel(MySet<T> mySet, MySetPanel<T> panel) {
        setLayout(new GridLayout(4, 1));
        spinner = new JSpinner();
        spinner.setPreferredSize(new Dimension(80, 30));

        clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
            mySet.clear();
            panel.updateList();
        });

        addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            @SuppressWarnings("unchecked")
            T x = (T) spinner.getValue();
            mySet.add(x);
            panel.updateList();
        });

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            @SuppressWarnings("unchecked")
            T x = (T) spinner.getValue();
            mySet.remove(x);
            panel.updateList();
        });

        add(addButton);
        add(spinner);
        add(deleteButton);
        add(clearButton);

    }
}