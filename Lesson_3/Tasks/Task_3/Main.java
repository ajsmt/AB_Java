/*
Напишите программу, сохраняющую треугольник Паскаля вплоть до заданной
величины п в переменной типа ArrayList<ArrayList<Integer».
*/

import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input n : ");
        int n = scanner.nextInt();
        scanner.close();
        GeneratePascalTriangleArray(n);
        GeneratePascalTriangleArrayList(n);
    }

    public static void GeneratePascalTriangleArray(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        System.out.println("Array : ");
        for (int[] row : triangle) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void GeneratePascalTriangleArrayList(int n) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        System.out.println("ArrayList : ");
        for (ArrayList<Integer> row : triangle) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}