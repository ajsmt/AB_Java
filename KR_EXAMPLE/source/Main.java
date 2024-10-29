import java.io.File;
import java.util.Comparator;
import java.util.List;

import AB.Gift.*;
import AB.Sweets.*;
import AB.GUI.*;

import javax.swing.JFrame;

public class Main{
    public static void main(String[] args) throws Exception{
        gui();
    }

    private static void cli() throws Exception{
        Gift gift = new Gift();
        GiftReader.readFromFile(gift, new File("output.txt"));
        GiftWriter.writeToFile(gift, new File("output.txt"));
        System.out.println("Gift :");
        System.out.println(gift.toString());
        System.out.println("Gift weight :");
        System.out.println(gift.getWeight() + " grams\n");
        System.out.println("Gift sorted by sugar amount :");
        Comparator<Candy> comp = (Candy c1, Candy c2) -> Double.compare(c1.getSugarAmount(), c2.getSugarAmount());
        gift.sortCandies(comp);
        System.out.println(gift.toString());
        System.out.println("Candies that have sugar amount between 45 and 50 grams :");
        List<Candy> candies = gift.findCandiesBySugar(45, 50);
        for(Candy c : candies){
            System.out.println(c.toString());
        }
    }

    private static void gui(){
        JFrame frame = new MyFrame("Candy Gift");
        frame.setLocation(100, 100);
    }

}