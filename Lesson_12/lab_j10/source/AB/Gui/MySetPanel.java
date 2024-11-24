package AB.Gui;

import AB.Set.MySet;

import javax.swing.*;
import java.awt.*;

public class MySetPanel<T> extends JPanel {
    private MySet<T> mySet;
    private JList<T> list;
    private JLabel isEmptyLabel;
    private JLabel sizeLabel;

    public MySetPanel(MySet<T> mySet) {
        this.mySet = mySet;
        this.list = mySet.getJList();
        
        setLayout(new BorderLayout());
        add(new JScrollPane(list), BorderLayout.CENTER);
        
        isEmptyLabel = new JLabel();
        sizeLabel = new JLabel();
        
        JPanel labels = new JPanel(new GridLayout(2, 1));
        labels.add(isEmptyLabel);
        labels.add(sizeLabel);

        add(labels, BorderLayout.SOUTH);

        updateList();
    }
    public void updateList() {
        list.setModel(mySet.getJList().getModel());
        isEmptyLabel.setText("Is empty: " + mySet.isEmpty());
        sizeLabel.setText("Size: " + mySet.size());
    }
}