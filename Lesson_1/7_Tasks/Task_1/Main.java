// Напишите программу, вводящую целочисленное значение и выводящую его
// в двоичной, восьмеричной и шестнадцатеричной форме. Организуйте вывод
// обратного значения в виде шестнадцатеричного числа с плавающей точкой.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input int value : ");
        int number = input.nextInt();
        input.close();
        System.out.println("Binary: " + Integer.toBinaryString(number));
        System.out.println("Octal: " + Integer.toOctalString(number));
        System.out.println("Hex: " + Integer.toHexString(number));
        System.out.println("Reverse hex value: " + Float.toHexString(1 / (float)number));
    }
}