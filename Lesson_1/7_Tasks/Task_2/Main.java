// Напишите программу, вводящую целочисленное (как положительное, так и
// отрицательное) значение угла и нормализующую его в пределах от 0 до 359
// градусов. Попробуйте сделать это сначала с помощью операции %, а затем метода
// floorMod( ).

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input angle : ");
        int Angle = input.nextInt();
        input.close();
        int Result_1 = Angle;
        while (Result_1 < 0) {
            Result_1 += 360;
        }
        Result_1 %= 260;
        System.out.println("Result with % : " + Result_1);
        int Result_2 = Math.floorMod(Angle, 360);
        System.out.println("Result with floorMod : " + Result_2);
    }
}