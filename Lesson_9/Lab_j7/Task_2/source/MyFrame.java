import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    private final String QUESTION = "Are you happy with the size of the scholarship?";
    private final Integer WIDTH = 400;
    private final Integer HEIGHT = 300;
    private JTextField questionField;
    private JButton yesButton;
    private JButton noButton;

    public MyFrame(String title) {
        super(title);
        setResizable(false);
        setBounds(100, 100, WIDTH, HEIGHT);
        setLayout(null);

        questionField = new JTextField(QUESTION);
        questionField.setBounds(10, 10, 380, 40);
        questionField.setEditable(false);
        Font myFont = new Font("Arial", Font.BOLD, 17);
        questionField.setFont(myFont);
        add(questionField);
        
        noButton = new JButton("No");
        noButton.setBounds(210, 60, 70, 60);
        noButton.setFont(myFont);
        add(noButton);

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MyFrame.this, "It could have been less", ":(",
                            JOptionPane.NO_OPTION);
            }
        });

        yesButton = new JButton("Yes");
        yesButton.setBounds(100, 60, 70, 60);
        yesButton.setFont(myFont);
        add(yesButton);

        yesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int newX = (int) (Math.random() * (WIDTH - yesButton.getWidth()));
                int newY = (int) (Math.random() * (HEIGHT - yesButton.getHeight()));
                yesButton.setBounds(newX, newY, 70, 60);
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}