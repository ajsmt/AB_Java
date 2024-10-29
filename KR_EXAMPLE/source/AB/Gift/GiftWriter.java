package AB.Gift;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class GiftWriter {
    public static void writeToFile(Gift gift, File file) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(gift.toString());
        }
    }
}
