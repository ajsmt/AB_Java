package AB.Gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class ControlsPanel extends JPanel {
    private JButton undoButton;
    private JButton redButton;
    private JButton blackButton;
    private JButton blueButton;
    private JButton eraserButton;
    private JSpinner brushSizeSpinner;
    private Font font;

    public ControlsPanel(DrawingPanel drawingPanel) {

        font = new Font("Arial", Font.BOLD, 18);

        setLayout(new GridLayout(1, 5));

        undoButton = new JButton("Undo");
        undoButton.setFont(font);
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.undo();
            }
        });

        redButton = new JButton("Red");
        redButton.setFont(font);
        redButton.setForeground(Color.red);
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setColor(Color.RED);
            }
        });

        blackButton = new JButton("Black");
        blackButton.setFont(font);
        blackButton.setForeground(Color.black);
        blackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setColor(Color.BLACK);
            }
        });

        blueButton = new JButton("Blue");
        blueButton.setFont(font);
        blueButton.setForeground(Color.blue);
        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setColor(Color.BLUE);
            }
        });

        eraserButton = new JButton("Eraser");
        eraserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.setColor(Color.WHITE);
            }
        });

        brushSizeSpinner = new JSpinner(new SpinnerNumberModel(5, 1, 100, 1));
        brushSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                drawingPanel.setBrushSize((int) brushSizeSpinner.getValue());
            }
        });

        add(undoButton);
        add(redButton);
        add(blackButton);
        add(blueButton);
        add(eraserButton);
        JLabel label = new JLabel("Brush size:");
        label.setFont(font);
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label);
        add(brushSizeSpinner);
    }
}
