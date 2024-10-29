package AB.Gift;
import java.io.File;
import java.util.Scanner;

import AB.Sweets.ChocolateBar;
import AB.Sweets.Lollipop;

public class GiftReader {
    public static void readFromFile(Gift gift, File file) throws Exception {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split(";");
            if (tokens[0].equals("c")) {
                ChocolateBar bar = ChocolateBar.parseCandy(tokens[1]);
                gift.add(bar);
            }
            if (tokens[0].equals("l")) {
                Lollipop pop = Lollipop.parseCandy(tokens[1]);
                gift.add(pop);
            }
        }
        scanner.close();
    }
}
