import java.awt.HeadlessException;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
    public MyFrame(String title) throws HeadlessException {
        super(title);
        MyPanel panel = new MyPanel(new Student("Name", 18));
        this.add(panel);
    }
}
