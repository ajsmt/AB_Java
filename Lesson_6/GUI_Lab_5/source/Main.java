import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new MyFrame("Series calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 200, 400, 330);
        frame.setVisible(true);
    }
}