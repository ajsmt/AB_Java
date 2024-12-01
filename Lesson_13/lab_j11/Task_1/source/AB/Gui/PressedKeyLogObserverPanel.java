package AB.Gui;

import javax.swing.*;
import AB.Data.*;
import java.awt.*;

public class PressedKeyLogObserverPanel extends JTextArea implements Observer{
    private long counter = 0;

    public PressedKeyLogObserverPanel() {
        setEditable(false);
        setLineWrap(true);
        setColumns(50);
        setRows(10);
        setFont(new Font("Arial", Font.BOLD, 30));
        setFocusable(false);
    }

    @Override
    public void update(char key) {
        append(String.format("Pressed [%d] : %c\n", counter, key));
        counter++;
    }
}
