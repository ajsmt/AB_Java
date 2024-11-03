import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame {
    private final Integer WIDTH = 400;
    private final Integer HEIGHT = 400;
    private JTextField coordinatedField;
    private JButton button;
    private boolean dragging = false;
    private Point draggingStart;

    public MyFrame(String title) {
        super(title);
        setResizable(false);
        setBounds(100, 100, WIDTH, HEIGHT);
        setLayout(null);

        coordinatedField = new JTextField(30);
        coordinatedField.setEditable(false);
        coordinatedField.setBounds(10, HEIGHT - 60, WIDTH - 25, 20);
        add(coordinatedField);

        button = new JButton("Button");
        button.setBounds(WIDTH / 2 - 75, HEIGHT / 2 - 15 - 60, 150, 30);
        add(button);

        button.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                showMousePosition(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                showMousePosition(e);
                if (dragging) {
                    dragButton(e);
                }
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                showMousePosition(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                showMousePosition(e);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!e.isControlDown()) {
                    setButtonPostion(e);
                }
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isControlDown()) {
                    dragging = true;
                    draggingStart = new Point(e.getXOnScreen(), e.getYOnScreen());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if (!button.getText().equals("")) {
                        button.setText(button.getText().substring(0, button.getText().length() - 1));
                    }
                } else if (e.getKeyChar() == ' ' || Character.isLetterOrDigit(e.getKeyChar())) {
                    button.setText(button.getText() + e.getKeyChar());
                }
            }
        });

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showMousePosition(MouseEvent e) {
        coordinatedField.setText("Mouse coordinates: x=" + e.getX() + ", y=" + e.getY());
    }

    private void setButtonPostion(MouseEvent e) {
        button.setLocation(e.getX() - button.getWidth() / 2, e.getY() - 12 * button.getHeight() / 9);
    }

    private void dragButton(MouseEvent e) {
        int x = e.getXOnScreen() - draggingStart.x;
        int y = e.getYOnScreen() - draggingStart.y;
        button.setLocation(button.getX() + x, button.getY() + y);
        draggingStart = new Point(e.getXOnScreen(), e.getYOnScreen());
    }
}
