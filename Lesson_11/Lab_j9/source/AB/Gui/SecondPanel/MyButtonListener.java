package AB.Gui.SecondPanel;

import java.awt.event.*;
import java.awt.*;

public class MyButtonListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();
        button.setText("Clicked!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();
        button.setDefaultText();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();
        button.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        MyButton button = (MyButton) e.getSource();
        button.setDefaultText();
        button.setBackground(Color.WHITE);
    }
}