import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private Series series;

    public MyFrame(String title) throws HeadlessException {
        super(title);
        this.series = null;
        setLayout(new GridLayout(8, 1));

        SeriesRadioButtons radioButtons = new SeriesRadioButtons();
        this.add(radioButtons);

        LabeledEdit firstElement = new LabeledEdit("Enter first element: ", "125");
        this.add(firstElement);

        LabeledEdit difference = new LabeledEdit("Enter difference: ", "0.5");
        this.add(difference);

        LabeledEdit numberOfElements = new LabeledEdit("Enter number of elements: ", "3");
        this.add(numberOfElements);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton buildSeries = new JButton("Build series");

        JPanel textPanel = new JPanel(new FlowLayout());
        JTextArea seriesText = new JTextArea(5, 20);
        seriesText.setPreferredSize(new Dimension(380, 300));
        seriesText.setLineWrap(true);
        seriesText.setWrapStyleWord(true);

        buildSeries.setPreferredSize(new Dimension(150, 20));

        buildSeries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double firstElem = 0;
                double diffeer = 0;
                int quantityOfElements = 0;
                try {
                    firstElem = Double.parseDouble(firstElement.getText().replaceAll(",", "."));
                    diffeer = Double.parseDouble(difference.getText().replaceAll(",", "."));
                    quantityOfElements = Integer.parseInt(numberOfElements.getText());
                    if (radioButtons.getSelectedOption().equals("Linear")) {
                        series = new Linear(firstElem, diffeer);
                    } else {
                        series = new Exponential(firstElem, diffeer);
                    }
                    seriesText.setText(series.toString(quantityOfElements));
                } catch (NumberFormatException ex) {
                    seriesText.setText("Invalid input. Please enter numbers.");
                    JOptionPane.showMessageDialog(MyFrame.this, "Invalid input. Please enter numbers.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(buildSeries);
        textPanel.add(seriesText);
        this.add(buttonPanel);
        this.add(textPanel);

        LabeledEdit fileName = new LabeledEdit("File Name: ", "output.txt");
        this.add(fileName);

        JPanel buttonPanel2 = new JPanel(new FlowLayout());
        JButton writeSeries = new JButton("Write to file");
        writeSeries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double firstElem = 0;
                double diffeer = 0;
                int quantityOfElements = 0;
                String file = null;
                try {
                    firstElem = Double.parseDouble(firstElement.getText().replaceAll(",", "."));
                    diffeer = Double.parseDouble(difference.getText().replaceAll(",", "."));
                    quantityOfElements = Integer.parseInt(numberOfElements.getText());
                    file = fileName.getText();
                    if (radioButtons.getSelectedOption().equals("Linear")) {
                        series = new Linear(firstElem, diffeer);
                    } else {
                        series = new Exponential(firstElem, diffeer);
                    }
                    series.writeToFile(file, quantityOfElements);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Invalid input. Please enter numbers.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MyFrame.this, ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel2.add(writeSeries);
        this.add(buttonPanel2);
    }
}
