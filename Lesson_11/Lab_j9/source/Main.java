import java.util.Scanner;

import javax.swing.JFrame;

import AB.Gui.MyFrame;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input grid size : \n\t n: ");
        int n = scanner.nextInt();
        System.out.print("\t m: ");
        int m = scanner.nextInt();
        scanner.close();

        JFrame frame = new MyFrame("Lab_j9", 500, 300, n, m);
        frame.setLocation(100, 100);
    }
}