package AB.Gui;

import javax.swing.*;
import AB.Data.*;
import java.awt.*;

public class PressedKeyDisplayObserverLabel extends JLabel implements Observer{
    public PressedKeyDisplayObserverLabel() {
        setText("Pressed key : ");
        setFont(new Font("Arial", Font.BOLD, 30));
        setFocusable(false);
    }

    @Override
    public void update(char key) {
        setText(String.format("Pressed key : %c", key));
    }
}
