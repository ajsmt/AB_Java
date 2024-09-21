/*
Напишите программу, вводящую двумерный массив целочисленных значений
и определяющую, содержится ли в нем магический квадрат (т.е. одинаковая
сумма значений во всех строках, столбцах и диагоналях). Принимая строки
вводимых данных, разбивайте их на отдельные целочисленные значения, пре
кратив этот процесс, когда пользователь введет пустую строку.
*/

import java.util.Scanner;

class MainArray {
    public static void main(String[] args) {
        System.out.println("Array : ");
        IsMagicSquareArray();
    }

    public static void IsMagicSquareArray() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int count = 0;
        int[][] square = null;
        while (line != "") {
            if (count == 0) {
                String[] str = line.split(" ");
                int[] array = new int[str.length];
                for (int i = 0; i < str.length; i++)
                    array[i] = Integer.parseInt(str[i]);
                square = new int[str.length][];
                square[count] = array;
                count++;
                line = scanner.nextLine();
                continue;
            }
            if (count >= square.length) {
                System.out.println("Not a magic square");
                scanner.close();
                return;
            }
            String[] str = line.split(" ");
            if (square.length != str.length) {
                System.out.println("Not a magic square");
                scanner.close();
                return;
            }
            int[] array = new int[str.length];
            for (int i = 0; i < str.length; i++)
                array[i] = Integer.parseInt(str[i]);
            square[count] = array;
            count++;
            line = scanner.nextLine();
        }
        scanner.close();
        int sum = 0;
        for (int i = 0; i < square.length; i++)
            sum += square[i][i];
        int secondSum = 0;
        for (int i = 0; i < square.length; i++)
            secondSum += square[i][square.length - 1 - i];
        if (sum != secondSum) {
            System.out.println("Not a magic square");
            return;
        }
        for (int i = 0; i < square.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < square.length; j++) {
                tempSum += square[j][i];
            }
            if (sum != tempSum) {
                System.out.println("Not a magic square");
                return;
            }
        }
        for (int i = 0; i < square.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < square.length; j++) {
                tempSum += square[i][j];
            }
            if (sum != tempSum) {
                System.out.println("Not a magic square");
                return;
            }
        }
        System.out.println("Yes a magic square");
    }
}