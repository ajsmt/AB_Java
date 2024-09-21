/*
Напишите программу, выбирающую и выводящую лотерейную комбинацию
из шести отдельных чисел в пределах от 1 до 49. Чтобы выбрать шесть отдель
ных чисел, начните со списочного массива, заполняемого числами от 1 до 49.
Выберите произвольный индекс и удалите элемент массива. Повторите эти
действия шесть раз подряд. Выведите полученный результат в отсортирован
ном порядке
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        System.out.print("ArrayList : ");
        GenerateLotteryArrayList();
        System.out.print("\nArray     : ");
        GenerateLotteryArray();
    }

    public static void GenerateLotteryArrayList() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++) {
            numbers.add(i);
        }
        ArrayList<Integer> lottery = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            int randomIndex = r.nextInt(numbers.size());
            lottery.add(numbers.get(randomIndex));
            numbers.remove(randomIndex);
        }
        Collections.sort(lottery);
        for (int num : lottery) {
            System.out.print(num + "\t");
        }
    }

    public static void GenerateLotteryArray() {
        int[] numbers = new int[49];
        for (int i = 0; i < 49; i++) {
            numbers[i] = i + 1;
        }
        int[] lottery = new int[6];
        for (int i = 0; i < 6; i++) {
            Random r = new Random();
            int randomIndex = r.nextInt(49 - i);
            lottery[i] = numbers[randomIndex];
            for (int j = randomIndex; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
        }
        Arrays.sort(lottery);
        for (int num : lottery) {
            System.out.print(num + "\t");
        }
    }
}