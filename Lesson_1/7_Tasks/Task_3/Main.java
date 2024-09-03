// Напишите программу, вводящую три целочисленных значения и выводящую
// самое большое из них, используя только условную операцию. Сделайте то же
// самое с помощью метода Math.mах() .

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        System.out.print("Input first number : ");
        a = input.nextInt();
        int b;
        System.out.print("Input second number : ");
        b = input.nextInt();
        int c;
        System.out.print("Input third number : ");
        c = input.nextInt();
        input.close();
        System.out.println("Solution with if statements : ");
        if (a > b && a > c) {
            System.out.println("Answer : " + a);
        } else if (b > a && b > c) {
            System.out.println("Answer : " + b);
        } else {
            System.out.println("Answer : " + c);
        }
        System.out.println("Solution with max() function : ");
        System.out.println("Answer : " + Math.max(Math.max(a, b), c));
    }
}