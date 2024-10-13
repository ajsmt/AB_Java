import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {
    private Student student;

    public MyPanel(Student student) {
        this.student = student;

        setLayout(new GridLayout(1, 2));

        JTextField text = new JTextField(student.toString());
        text.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 20));
        text.setHorizontalAlignment(JTextField.CENTER);
        this.add(text);

        JButton button = new JButton("Add 1 year");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                student.setAge(student.getAge() + 1);
                text.setText(student.toString());
            }
        });
        this.add(button);
    }

}
