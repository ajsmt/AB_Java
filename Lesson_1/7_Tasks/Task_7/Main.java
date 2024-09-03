// Напишите программу, вводящую два числа в пределах от 0 до 65535, сохраня
// ющую их в переменных типа short и вычисляющую их сумму, разность, про
// изведение, частное и остаток без знака, не преобразуя эти величины в тип int.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("Input first short number: ");
        short a = input.nextShort();
        System.out.print("Input second short number: ");
        short b = input.nextShort();
        input.close();

        System.out.println("Sum : " + (a + b));
        System.out.println("Sub : " + (a - b));
        System.out.println("Mul : " + (a * b));
        System.out.println("Chastnoe : " + (a / b));
        System.out.println("Ostatok : " + (a % b));
        
    }
}