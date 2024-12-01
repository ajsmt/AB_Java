package AB.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class addCourseDialog extends JDialog {

    private JTextField courseField;
    private JButton addButton;

    public addCourseDialog(Set<String> courses) {
        super();
        setTitle("Add Course");
        setLayout(new BorderLayout());
        setModal(true);
        setSize(220, 100);

        courseField = new JTextField();
        addButton = new JButton("Add");

        JPanel Panel = new JPanel();
        Panel.setLayout(new BorderLayout());
        Panel.add(new JLabel("Course:"), BorderLayout.WEST);
        Panel.add(courseField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        add(Panel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String course = courseField.getText().trim();
                if (!course.isEmpty()) {
                    courses.add(course);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(addCourseDialog.this, "Please enter a course", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}