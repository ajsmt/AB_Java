package AB.Gui.SecondPanel;

import java.awt.*;

import javax.swing.*;

public class MyButton extends JButton{
    private String text;
    private Font font;

    MyButton(String text) {
        this.text = text;
        setDefaultText();
        font = new Font("Arial", Font.BOLD, 20);
        setFont(font);
        setBackground(Color.WHITE);
        UIManager.put("Button.select", Color.YELLOW);
    }

    void setDefaultText(){
        setText(text);
    }
}
