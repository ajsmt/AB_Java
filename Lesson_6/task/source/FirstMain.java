import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;

public class FirstMain {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("1.txt"));
            System.out.println("locale = " + Locale.getDefault());
            System.out.println("locale = " + scan.locale());
            scan.useLocale(Locale.US);
            System.out.println("locale = " + scan.locale());

            int n = scan.nextInt();

            scan.useDelimiter("[,\\s]+");
            System.out.println("delimeter = " + scan.delimiter());

            double[][] matr = new double[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matr[i][j] = scan.nextDouble();
                }
            }
            scan.close();
            System.out.println(Arrays.deepToString(matr));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}