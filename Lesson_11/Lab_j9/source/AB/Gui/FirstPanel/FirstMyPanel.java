package AB.Gui.FirstPanel;

import java.util.List;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class FirstMyPanel extends JPanel {
    private JList<Object> leftList;
    private JList<Object> rightList;
    private JButton moveToRightButton;
    private JButton moveToLeftButton;
    private Font font;

    public FirstMyPanel(int WIDTH, int HEIGHT) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        font = new Font("Arial", Font.BOLD, 20);

        leftList = new JList<>();
        leftList.setFont(font);
        leftList.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT));
        rightList = new JList<>();
        rightList.setFont(font);
        rightList.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT));

        loadExampleData();

        add(new JScrollPane(leftList), BorderLayout.WEST);
        add(new JScrollPane(rightList), BorderLayout.EAST);

        moveToRightButton = new JButton("==>>");
        moveToRightButton.setFont(font);
        moveToRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveToRight();
            }
        });
        moveToRightButton.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT / 4));
        moveToLeftButton = new JButton("<<==");
        moveToLeftButton.setFont(font);
        moveToLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveToLeft();
            }
        });
        moveToLeftButton.setPreferredSize(new Dimension(WIDTH / 3, HEIGHT / 4));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(moveToRightButton, BorderLayout.NORTH);
        buttonPanel.add(moveToLeftButton, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void loadExampleData() {
        DefaultListModel<Object> input = new DefaultListModel<>();
        input.addElement(82);
        input.addElement("Louis Swanson");
        input.addElement("Emma Townsend");
        input.addElement("Lenora Bell");
        leftList.setModel(input);
        input = new DefaultListModel<>();
        input.addElement(35.3);
        input.addElement("Viola Owens");
        input.addElement("Mason Campbell");
        input.addElement(13);
        input.addElement("Julia Reeves");
        input.addElement(true);
        rightList.setModel(input);
    }

    public void moveToRight() {
        List<Object> selectedValues = leftList.getSelectedValuesList();
        DefaultListModel<Object> leftModel = (DefaultListModel<Object>) leftList.getModel();
        DefaultListModel<Object> rightModel = (DefaultListModel<Object>) rightList.getModel();

        for (Object value : selectedValues) {
            leftModel.removeElement(value);
            rightModel.addElement(value);
        }

        leftList.setModel(leftModel);
        rightList.setModel(rightModel);
    }

    public void moveToLeft() {
        List<Object> selectedValues = rightList.getSelectedValuesList();
        DefaultListModel<Object> leftModel = (DefaultListModel<Object>) leftList.getModel();
        DefaultListModel<Object> rightModel = (DefaultListModel<Object>) rightList.getModel();

        for (Object value : selectedValues) {
            rightModel.removeElement(value);
            leftModel.addElement(value);
        }
        
        leftList.setModel(leftModel);
        rightList.setModel(rightModel);
    }
}
