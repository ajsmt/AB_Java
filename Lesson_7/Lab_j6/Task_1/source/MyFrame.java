import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class MyFrame extends JFrame {

    private JTextArea InputArea;
    private JTextArea OutputArea;
    private JButton openButton;
    private JButton editButton;
    private JButton saveButton;
    private JButton clearButton;
    private JButton addButton;

    public MyFrame(String title) {
        super(title);
        setResizable(false);
        setLayout(new BorderLayout());
        InputArea = new JTextArea();
        OutputArea = new JTextArea();
        InputArea.setPreferredSize(new Dimension(230, 300));
        OutputArea.setPreferredSize(new Dimension(230, 300));
        InputArea.setLineWrap(true);
        InputArea.setWrapStyleWord(true);
        OutputArea.setLineWrap(true);
        OutputArea.setWrapStyleWord(true);
        add(new JScrollPane(InputArea), BorderLayout.WEST);
        add(new JScrollPane(OutputArea), BorderLayout.EAST);

        openButton = new JButton("Open File");
        editButton = new JButton("Edit");
        saveButton = new JButton("Save to File");
        clearButton = new JButton("Clear");
        addButton = new JButton("Add Course");

        JPanel buttons = new JPanel();
        buttons.add(openButton);
        buttons.add(editButton);
        buttons.add(clearButton);
        buttons.add(addButton);
        buttons.add(saveButton);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int result = chooser.showOpenDialog(MyFrame.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(file));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line).append("\n");
                        }
                        InputArea.setText(sb.toString());
                        br.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(MyFrame.this, "Error: " + ex.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = InputArea.getText();
                if(inputText.equals("")){
                    return;
                }
                String[] lines = inputText.split("\n");
                Set<String> courses = new HashSet<String>();
                for (String line : lines) {
                    String[] values = line.split(",");
                    courses.add(values[2].trim() + '\n');
                }
                OutputArea.append(String.join("", courses));
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
                int result = chooser.showOpenDialog(MyFrame.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                        bw.write(OutputArea.getText());
                        bw.close();
                        JOptionPane.showMessageDialog(MyFrame.this, "File saved!", "Done", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(MyFrame.this, "Error: " + ex.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OutputArea.setText("");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourseDialog dialog = new addCourseDialog(OutputArea);
                dialog.setVisible(true);
            }
        });

        add(buttons, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
