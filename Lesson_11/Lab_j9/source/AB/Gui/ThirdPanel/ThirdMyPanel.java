package AB.Gui.ThirdPanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ThirdMyPanel extends JPanel {
    private JTextField textField;
    private List<JRadioButton> radioButtons;

    private Icon selectedIcon = new ImageIcon("resources\\images\\selectedIcon.png");
    private Icon unselectedIcon = new ImageIcon("resources\\images\\unselectedIcon.png");
    private Icon hoveredIcon = new ImageIcon("resources\\images\\hoveredIcon.png");
    private Icon hoveredSelectedIcon = new ImageIcon("resources\\images\\hoveredSelectedIcon.png");

    private Font font = new Font("Arial", Font.BOLD, 25);

    public ThirdMyPanel(int WIDTH, int HEIGHT) {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        textField = new JTextField("Selected : ");
        textField.setFont(font);
        textField.setEditable(false);

        loadDataFromFile("resources\\data\\radioButtonOptions.txt");

        ButtonGroup group = new ButtonGroup();
        JPanel panel = new JPanel(new GridLayout(1, radioButtons.size()));
        for (JRadioButton radioButton : radioButtons) {
            group.add(radioButton);
            panel.add(radioButton);
        }

        add(panel, BorderLayout.NORTH);

        add(textField, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadDataFromFile(String fileName) {
        radioButtons = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine())
                radioButtons.add(createRadioButton(scanner.nextLine()));
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
            System.err.println("Using default options instead");
            radioButtons.add(createRadioButton("Cat"));
            radioButtons.add(createRadioButton("Dog"));
            radioButtons.add(createRadioButton("Parrot"));
        }
    }

    private JRadioButton createRadioButton(String name) {
        JRadioButton button = new JRadioButton(name);
        button.setFont(font);
        button.setIcon(unselectedIcon);
        setUpdateAction(button);
        setHoverIcon(button);
        return button;
    }

    private void setHoverIcon(JRadioButton radioButton) {
        radioButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                radioButton.setIcon(radioButton.isSelected() ? hoveredSelectedIcon : hoveredIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                radioButton.setIcon(radioButton.isSelected() ? selectedIcon : unselectedIcon);
            }
        });
    }

    private void setUpdateAction(JRadioButton radioButton) {
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
                textField.setText("Selected: " + selectedRadioButton.getText());
                updateIcons();
            }
        });
    }

    private void updateIcons() {
        for (JRadioButton radioButton : radioButtons) {
            radioButton.setIcon(radioButton.isSelected() ? selectedIcon : unselectedIcon);
        }
    }
}
