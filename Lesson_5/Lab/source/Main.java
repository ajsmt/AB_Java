import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        cLIExample();
        gUIExample();
    }

    public static void cLIExample() {
        Linear linear = new Linear(1, 3);
        System.out.println("Linear : " + linear.toString());
        System.out.println("Sum of 15 : " + linear.getSum(15));
        linear.writeToFile("linear.txt");
        System.out.println("-------------");
        Exponential exponential = new Exponential(15, 0.3);
        System.out.println("Exponential : " + exponential.toString());
        System.out.println("Sum of 15 : " + exponential.getSum(15));
        exponential.writeToFile("exponential.txt");
    }

    public static void gUIExample() {
        JFrame frame = new JFrame("Series");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(null);

        // Series
        JLabel seriesVariation = new JLabel("Select series variation:");
        seriesVariation.setBounds(10, 10, 150, 15);
        JRadioButton radioButton1 = new JRadioButton("Linear");
        radioButton1.setBounds(10, 30, 70, 15);
        JRadioButton radioButton2 = new JRadioButton("Exponential");
        radioButton2.setBounds(100, 30, 100, 15);
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        frame.add(radioButton1);
        frame.add(radioButton2);
        frame.add(seriesVariation);

        // Inputs
        JLabel firstElementLabel = new JLabel("Enter a first element:");
        firstElementLabel.setBounds(10, 50, 150, 15);
        JTextField firstElementInput = new JTextField();
        firstElementInput.setBounds(180, 50, 100, 15);
        frame.add(firstElementLabel);
        frame.add(firstElementInput);
        JLabel differenceLabel = new JLabel("Enter a difference:");
        differenceLabel.setBounds(10, 65, 150, 15);
        JTextField differenceInput = new JTextField();
        differenceInput.setBounds(180, 65, 100, 15);
        frame.add(differenceLabel);
        frame.add(differenceInput);
        JLabel quantityOfElementsLabel = new JLabel("Enter a number of elements:");
        quantityOfElementsLabel.setBounds(10, 80, 170, 15);
        JTextField quantityOfElementsInput = new JTextField();
        quantityOfElementsInput.setBounds(180, 80, 100, 15);
        frame.add(quantityOfElementsLabel);
        frame.add(quantityOfElementsInput);

        JLabel seriesOutput = new JLabel("");
        seriesOutput.setBounds(10, 120, 170, 15);
        frame.add(seriesOutput);
        JLabel seriesSumOutput = new JLabel("");
        seriesSumOutput.setBounds(10, 140, 170, 15);
        frame.add(seriesSumOutput);
        JButton outputButton = new JButton("Build series");
        outputButton.setBounds(10, 100, 270, 15);
        outputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!radioButton1.isSelected() && !radioButton2.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Select series variation", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double firstElement = 0;
                double difference = 0;
                int quantityOfElements = 0;
                try {
                    firstElement = Double.parseDouble(firstElementInput.getText().replaceAll(",", "."));
                    difference = Double.parseDouble(differenceInput.getText().replaceAll(",", "."));
                    quantityOfElements = Integer.parseInt(quantityOfElementsInput.getText());
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(frame, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Series series;
                if (radioButton1.isSelected()) {
                    series = new Linear(firstElement, difference);
                } else {
                    series = new Exponential(firstElement, difference);
                }
                seriesOutput.setText("Series: " + series.toString(quantityOfElements));
                seriesSumOutput.setText("Sum: " + series.getSum(quantityOfElements));
            }
        });
        frame.add(outputButton);

        JLabel fileNameLabel = new JLabel("File Name:");
        fileNameLabel.setBounds(10, 160, 60, 15);
        JTextField fileNameInput = new JTextField();
        fileNameInput.setBounds(80, 160, 100, 15);
        frame.add(fileNameLabel);
        frame.add(fileNameInput);
        JButton writeButton = new JButton("Write to file");
        writeButton.setBounds(10, 180, 270, 15);
        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!radioButton1.isSelected() && !radioButton2.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Select series variation", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                double firstElement = 0;
                double difference = 0;
                int quantityOfElements = 0;
                try {
                    firstElement = Double.parseDouble(firstElementInput.getText().replaceAll(",", "."));
                    difference = Double.parseDouble(differenceInput.getText().replaceAll(",", "."));
                    quantityOfElements = Integer.parseInt(quantityOfElementsInput.getText());
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(frame, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Series series;
                if (radioButton1.isSelected()) {
                    series = new Linear(firstElement, difference);
                } else {
                    series = new Exponential(firstElement, difference);
                }
                if (fileNameInput.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "No file name!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    series.writeToFile(fileNameInput.getText(), quantityOfElements);
                    JOptionPane.showMessageDialog(frame, "Series has been written to file!");
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(frame, "Error writing to file: " + err.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(writeButton);

        frame.setVisible(true);
    }
}