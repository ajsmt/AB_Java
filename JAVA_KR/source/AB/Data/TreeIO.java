package AB.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TreeIO {
    public static List<Tree> readForestFromFile(String fileName) throws IOException {
        List<Tree> trees = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Tree tree = ForestTree.parseForestTree(line);
                trees.add(tree);
            }
        }
        catch (IOException e) {
            throw new IOException("Error reading file: " + fileName, e);
        }
        return trees;
    }

    public static List<Tree> readFruitFromFile(String fileName) throws IOException {
        List<Tree> trees = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Tree tree = FruitTree.parseFruitTree(line);
                trees.add(tree);
            }
        }
        catch (IOException e) {
            throw new IOException("Error reading file: " + fileName, e);
        }
        return trees;
    }

    public static String writeToString(List<Tree> trees){
        StringBuffer buffer = new StringBuffer();
        trees.forEach(elem -> buffer.append(elem).append('\n'));
        return buffer.toString();
    }

    public static void writeToFile(List<Tree> trees, String filename){
        try(PrintWriter writer = new PrintWriter(new File(filename))){
            writer.print(writeToString(trees));
            writer.close();
        }
        catch(IOException e){
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }
    }

}
