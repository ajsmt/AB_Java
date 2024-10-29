package AB.GUI;

import AB.Gift.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyFrame extends JFrame {
    private Gift inputGift;
    private Gift outputGift;
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton openButton;
    private JButton clearInput;
    private JButton clearOutput;
    private JButton sortGift;
    private JButton writeButton;
    private JButton findButton;
    private JButton addButton;

    public MyFrame(String title) {
        super(title);

        inputGift = new Gift();
        outputGift = new Gift();

        setResizable(false);
        setLayout(new BorderLayout());

        inputArea = new JTextArea();
        outputArea = new JTextArea();
        inputArea.setPreferredSize(new Dimension(350, 300));
        outputArea.setPreferredSize(new Dimension(350, 300));
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        add(new JScrollPane(inputArea), BorderLayout.WEST);
        add(new JScrollPane(outputArea), BorderLayout.EAST);

        openButton = new JButton("Open File");
        clearInput = new JButton("Clear Input");
        clearOutput = new JButton("Clear Output");
        sortGift = new JButton("Sort Gift");
        writeButton = new JButton("Write to File");
        findButton = new JButton("Find Candies");
        addButton = new JButton("Add Candy");
        JPanel buttons = new JPanel();
        buttons.add(openButton);
        buttons.add(clearInput);
        buttons.add(sortGift);
        buttons.add(findButton);
        buttons.add(addButton);
        buttons.add(clearOutput);
        buttons.add(writeButton);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
                updateInputArea();
            }
        });

        clearInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    inputGift.clearGift();
                    updateInputArea();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    outputGift.clearGift();
                    updateOutputArea();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sortGift.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SortGiftDialog dialog = new SortGiftDialog(MyFrame.this, inputGift, outputGift);
                    updateOutputArea();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        writeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeToFile();
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FindCandiesDialog dialog = new FindCandiesDialog(MyFrame.this, inputGift, outputGift);
                    updateOutputArea();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AddCandyDialog dialog = new AddCandyDialog(MyFrame.this, outputGift);
                    updateOutputArea();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MyFrame.this, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(buttons, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = chooser.showOpenDialog(MyFrame.this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                inputGift.clearGift();
                GiftReader.readFromFile(inputGift, file);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MyFrame.this, "Error: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void writeToFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = chooser.showSaveDialog(MyFrame.this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                GiftWriter.writeToFile(outputGift, file);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(MyFrame.this, "Error: " + e.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void updateInputArea() {
        inputArea.setText(inputGift.toString());
    }

    private void updateOutputArea() {
        outputArea.setText(outputGift.toString());
    }
}
