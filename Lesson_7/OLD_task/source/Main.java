import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        try {
            Integer[] arr = { 1, 2, 3, 4, 5, 4 };
            System.out.println("Array : " + Arrays.toString(arr) + "\n");
            System.out.println("Number of ODD numbers: ");
            Predicate<Integer> p = new Predicate<Integer>() {
                @Override
                public boolean test(Integer t) {
                    return t % 2 != 0;
                }
            };
            System.out.println("Count : " + countIf(arr, x -> x % 2 != 0));

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static <T> int countIf(T[] array, Predicate<T> condition) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        int count = 0;
        for (T x : array) {
            if (condition.test(x)) {
                count++;
            }
        }
        return count;
    }
}