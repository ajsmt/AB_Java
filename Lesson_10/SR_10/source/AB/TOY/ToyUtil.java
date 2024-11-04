package AB.TOY;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ToyUtil {
    public static List<Toy> readFromFile(String filename){
        List<Toy> result = new ArrayList<Toy>();
        try(Scanner scanner = new Scanner(new File(filename))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                Toy toy = Toy.parseToy(line);
                result.add(toy);
            }
        }
        catch(Exception e){
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
        return result;
    }

    public static String writeToString(List<Toy> toys){
        StringBuffer buffer = new StringBuffer();
        toys.forEach(elem -> buffer.append(elem).append('\n'));
        return buffer.toString();
    }

    public static void writeToFile(List<Toy> toys, String filename){
        try(PrintWriter writer = new PrintWriter(new File(filename))){
            writer.print(writeToString(toys));
            writer.close();
        }
        catch(IOException e){
            System.err.println("Error writing to file: " + e.getMessage());
            return;
        }
    }

    public static List<Toy> takeSortedList(List<Toy> toys, Comparator<Toy> comp){
        return toys.stream().sorted(comp).toList();
    }

    public static List<Toy> takeFilteredList(List<Toy> toys, Predicate<Toy> comp){
        return toys.stream().filter(comp).toList();
    }

    public static List<Toy> takeMinMaxByName(List<Toy> toys) throws EmptyListException{
        if (toys == null){
            throw new EmptyListException("Error: empty list");
        }
        List<Toy> minMax = new ArrayList<>();
        minMax.add(toys.stream().min(Comparator.comparing(Toy::getName)).get());
        minMax.add(toys.stream().max(Comparator.comparing(Toy::getName)).get());
        return minMax;
    }
}
