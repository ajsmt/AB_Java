import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import AB.TOY.*;
import AB.GUI.MyFrame;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        
        List<Toy> toys = new ArrayList<Toy>();
        toys = ToyUtil.readFromFile("in.txt");
        System.out.println("List read from file:");
        System.out.println(ToyUtil.writeToString(toys));
        ToyUtil.writeToFile(toys, "output.txt");
        List<Toy> A = ToyUtil.takeSortedList(toys, Comparator.comparing(Toy::getName));
        System.out.println("List sorted by name:");
        System.out.println(ToyUtil.writeToString(A));
        List<Toy> B = ToyUtil.takeSortedList(toys, Comparator.comparing(Toy::getMinAge, Comparator.reverseOrder())
                                                    .thenComparing(Toy::getMaxAge));
        System.out.println("List sorted by minAge (descending) and maxAge (ascending):");
        System.out.println(ToyUtil.writeToString(B));
        int a = 2;
        int b = 11; 
        List<Toy> C = ToyUtil.takeFilteredList(toys, elem -> elem.getMinAge() >= a && elem.getMaxAge() <= b);
        System.out.printf("List filtered by minAge >= %d and maxAge <= %d:\n", a ,b);
        System.out.println(ToyUtil.writeToString(C));
        List<Toy> D = ToyUtil.takeMinMaxByName(toys);
        System.out.println("Toys with the minimum and maximum names:");
        System.out.println(ToyUtil.writeToString(D));

        JFrame frame = new MyFrame("Toys", toys, A, C);
        frame.setBounds(100, 100, 400, 100);
    }
}
