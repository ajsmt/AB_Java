import java.util.ArrayList;
import java.util.Scanner;

class MainArrayList {
    public static void main(String[] args) {
        System.out.println("ArrayList : ");
        IsMagicSquareArrayList();
    }

    public static void IsMagicSquareArrayList() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int count = 0;
        ArrayList<ArrayList<Integer>> square = new ArrayList<>();
        while (line != "") {
            if (count == 0) {
                String[] str = line.split(" ");
                ArrayList<Integer> array = new ArrayList<Integer>();
                for (int i = 0; i < str.length; i++)
                    array.add(Integer.parseInt(str[i]));
                square.add(array);
                count++;
                line = scanner.nextLine();
                continue;
            }
            if (count >= square.get(0).size()) {
                System.out.println("Not a magic square");
                scanner.close();
                return;
            }
            String[] str = line.split(" ");
            if (square.get(0).size() != str.length) {
                System.out.println("Not a magic square");
                scanner.close();
                return;
            }
            ArrayList<Integer> array = new ArrayList<Integer>();
            for (int i = 0; i < str.length; i++)
                array.add(Integer.parseInt(str[i]));
            square.add(array);
            count++;
            line = scanner.nextLine();
        }
        scanner.close();
        int sum = 0;
        for (int i = 0; i < square.size(); i++)
            sum += square.get(i).get(i);
        int secondSum = 0;
        for (int i = 0; i < square.size(); i++)
            secondSum += square.get(i).get(square.size() - 1 - i);
        if (sum != secondSum) {
            System.out.println("Not a magic square");
            return;
        }
        for (int i = 0; i < square.size(); i++) {
            int tempSum = 0;
            for (int j = 0; j < square.size(); j++)
                tempSum += square.get(i).get(j);
            if (sum != tempSum) {
                System.out.println("Not a magic square");
                return;
            }
        }
        for (int i = 0; i < square.size(); i++) {
            int tempSum = 0;
            for (int j = 0; j < square.size(); j++)
                tempSum += square.get(j).get(i);
            if (sum != tempSum) {
                System.out.println("Not a magic square");
                return;
            }
        }
        System.out.println("Yes a magic square");
    }
}