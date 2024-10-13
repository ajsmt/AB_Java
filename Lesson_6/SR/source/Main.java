import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("input.txt"));
        scan.useLocale(Locale.US);
        scan.useDelimiter("[,\\s;\\n]+");
        double sum = 0.0;
        while (scan.hasNext()) {
            if (scan.hasNextDouble()) {
                double number = scan.nextDouble();
                sum += number;
            } else {
                scan.next();
            }
        }
        scan.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        bw.write(String.format("Sum of numbers: %.8f", sum));
        bw.close();
    }
}