// Напишите программу, вычисляющую факториал п ! = 1 х 2 * . . . х n, 
// используя класс Biglnteger. Вычислите факториал числа 1000.

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(n + "! is : " + FactorialCalculator(n));
    }

    public static BigInteger FactorialCalculator(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++)
            factorial = factorial.multiply(BigInteger.valueOf(i));
        return factorial;
    }
}