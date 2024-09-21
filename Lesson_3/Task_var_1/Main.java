/*
Ввод матрицы осуществлять из файла посредством класса Scanner. Проверять
ошибочные ситуации, в т.ч. недостатка или избытка входных данных. Матрицу
представлять в виде [][].
*/
/*
1. Найти решение треугольной системы линейных уравнений
*/

import java.io.File;
import java.util.Scanner;

class WrongInputException extends RuntimeException {
    public WrongInputException(String message) {
        super(message);
    }
}

class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new WrongInputException("Wrong number of arguments");
            }

            // Получаем расширенную матрицу соответствующую системе линейных уравнений
            double[][] matrix = MatrixInput(args[0]);
            // Вывод этой матрицы на экран
            System.out.println("Matrix: ");
            printMatrix(matrix);
            // Получение решения
            double[] solution = solveMatrix(matrix);
            // Вывод решения
            System.out.println("Solution:");
            for (double x : solution) {
                System.out.printf("%.8f \n", x);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static double[][] MatrixInput(String input) throws Exception {
        Scanner scanner = new Scanner(new File(input));
        if (!scanner.hasNext()) {
            scanner.close();
            throw new WrongInputException("No input size");
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double[][] matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        if (scanner.hasNextDouble()) {
            scanner.close();
            throw new WrongInputException("Too many arguments");
        }
        scanner.close();
        return matrix;
    }

    public static void printMatrix(final double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[] solveMatrix(final double[][] inputMatrix) throws Exception {
        double[][] matrix = CopyMatrix(inputMatrix);
        int n = matrix.length;
        int m = matrix[0].length;
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            matrix[i][m - 1] /= matrix[i][i];
            for (int j = 0; j < i; j++)
                matrix[j][m - 1] -= matrix[j][i] * matrix[i][m - 1];
        }
        for (int i = 0; i < n; i++)
            solution[i] = matrix[i][m - 1];
        return solution;
    }

    public static double[][] CopyMatrix(double[][] matrix) throws Exception {
        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }
}