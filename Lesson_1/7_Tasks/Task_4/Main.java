// Напишите программу, выводящую наименьшее и наибольшее положитель
// ные значения типа double. Подсказка: воспользуйтесь методом Math.nextUp ()
// из прикладного программного интерфейса Java API.

public class Main {
    public static void main(String[] args) {
        System.out.println("Double min positive value: " + Math.nextUp(.0));
        System.out.println("Double max positive value: " + Double.MAX_VALUE);
    }
}