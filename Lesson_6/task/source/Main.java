import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new MyFrame("Series");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 200, 800, 400);
        frame.setVisible(true);
    }
}