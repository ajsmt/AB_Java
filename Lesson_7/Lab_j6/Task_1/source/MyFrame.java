import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class MyFrame extends JFrame {

    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton openButton;
    private JButton editButton;
    private JButton saveButton;
    private JButton clearButton;
    private JButton addButton;
    private Set<Student> students;
    private Set<String> courses;

    public MyFrame(String title) {
        super(title);

        students = new HashSet<>();
        courses = new HashSet<>();

        setResizable(false);
        setLayout(new BorderLayout());
        inputArea = new JTextArea();
        outputArea = new JTextArea();
        inputArea.setPreferredSize(new Dimension(230, 300));
        outputArea.setPreferredSize(new Dimension(230, 300));
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        add(new JScrollPane(inputArea), BorderLayout.WEST);
        add(new JScrollPane(outputArea), BorderLayout.EAST);

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
                        String line;
                        while ((line = br.readLine()) != null) {
                            Student student = Student.studentPars(line);
                            students.add(student);
                        }
                        br.close();
                        writeinputArea();
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
                if (students.isEmpty()) {
                    return;
                }
                for(Student st : students) {
                    courses.add(st.getCourse());
                }
                writeoutputArea();
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
                        StringBuffer sb = new StringBuffer();
                        for(String  course : courses){
                            sb.append(course + '\n');
                        }
                        bw.write(sb.toString());
                        bw.close();
                        JOptionPane.showMessageDialog(MyFrame.this, "File saved!", "Done",
                                JOptionPane.INFORMATION_MESSAGE);
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
                courses = new HashSet<>();
                writeoutputArea();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourseDialog dialog = new addCourseDialog(courses);
                dialog.setVisible(true);
                writeoutputArea();
            }
        });

        add(buttons, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void writeinputArea(){
        inputArea.setText("");
        for(Student st : students) {
            inputArea.append(st.toString() + '\n');
        }
    }

    private void writeoutputArea(){
        outputArea.setText("");
        for(String course : courses) {
            outputArea.append(course + '\n');
        }
    }
}
