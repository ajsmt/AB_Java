package AB.GUI;

import javax.swing.*;
import java.awt.*;
import AB.TOY.*;
import java.util.List;

public class MyFrame extends JFrame {

    private List<Toy> toys;
    private List<Toy> sortedToys;
    private List<Toy> filteredToys;
    private JTextArea text;
    private JTextArea sortedText;
    private JTextArea filteredText;

    public MyFrame(String title, List<Toy> toys, List<Toy> sortedToys, List<Toy> filteredToys) {
        super(title);
        this.toys = toys;
        this.sortedToys = sortedToys;
        this.filteredToys = filteredToys;
        setResizable(false);
        setLayout(new GridLayout(1, 3));
        text = new JTextArea(7, 10);
        text.setEditable(false);
        text.setBorder(BorderFactory.createMatteBorder(
            5, 5, 5, 5, Color.blue));
        sortedText = new JTextArea(7, 10);
        sortedText.setEditable(false);
        sortedText.setBorder(BorderFactory.createMatteBorder(
            5, 5, 5, 5, Color.red));
        filteredText = new JTextArea(7, 10);
        filteredText.setEditable(false);
        filteredText.setBorder(BorderFactory.createMatteBorder(
            5, 5, 5, 5, Color.green));
        text.setText(ToyUtil.writeToString(toys));
        sortedText.setText(ToyUtil.writeToString(toys));
        filteredText.setText(ToyUtil.writeToString(toys));
        add(text);
        add(sortedText);
        add(filteredText);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
