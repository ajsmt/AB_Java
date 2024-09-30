import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;

public class GenericUtils {
	public static void main(String[] args) {
		try {
			Integer[] arr = { 1, 2, 3, 4, 5, 4 };
			System.out.println("Array : " + Arrays.toString(arr) + "\n");

			System.out.println("1) Finding in array test : ");
			System.out.println("7 : " + findInArray(arr, 7));
			System.out.println("4 : " + findInArray(arr, 4));

			System.out.println("\n2) Counting in array test : ");
			System.out.println("7 : " + countInArray(arr, 7));
			System.out.println("4 : " + countInArray(arr, 4));

			System.out.println("------------------------");
			System.out.println("3) Standard find : ");
			System.out.println("7 : " + (Arrays.binarySearch(arr, 7) > -1));
			System.out.println("4 : " + (Arrays.binarySearch(arr, 4) > -1));

			System.out.println("\n3) Standard count : ");
			System.out.println("7 : " + Collections.frequency(Arrays.asList(arr), 7));
			System.out.println("4 : " + Collections.frequency(Arrays.asList(arr), 4));
			System.out.println("------------------------");

			System.out.println("\n4) Counting greater in array test : ");
			System.out.println("7 : " + countGreaterInArray(arr, 7));
			System.out.println("4 : " + countGreaterInArray(arr, 4));

			System.out.println("\n5) Accumulating array test : ");
			System.out.println("Sum : " + getSumOfArray(arr));

			System.out.println("\n6) Average of an array test : ");
			System.out.printf("Average : %.4f\n", getAverage(arr));

			System.out.println("\n7) Count with predicate test : ");
			System.out.println("Count : " + countIf(arr, x -> x % 2 == 0));

		} catch (IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static <T extends Comparable<T>> boolean findInArray(T[] arr, T value) throws IllegalArgumentException {
		if (arr == null) {
			throw new IllegalArgumentException("Array is null");
		}
		for (T x : arr) {
			if (x.compareTo(value) == 0)
				return true;
		}
		return false;
	}

	public static <T extends Comparable<T>> int countInArray(T[] arr, T value) throws IllegalArgumentException {
		if (arr == null) {
			throw new IllegalArgumentException("Array is null");
		}
		int count = 0;
		for (T x : arr) {
			if (x.compareTo(value) == 0)
				count++;
		}
		return count;
	}

	public static <T extends Comparable<T>> int countGreaterInArray(T[] arr, T value) throws IllegalArgumentException {
		if (arr == null) {
			throw new IllegalArgumentException("Array is null");
		}
		int count = 0;
		for (T x : arr) {
			if (x.compareTo(value) > 0)
				count++;
		}
		return count;
	}

	public static <T extends Number> double getSumOfArray(T[] arr) throws IllegalArgumentException {
		if (arr == null) {
			throw new IllegalArgumentException("Array is null");
		}
		double sum = 0.;
		for (T x : arr) {
			sum += x.doubleValue();
		}
		return sum;
	}

	public static <T extends Number> double getAverage(T[] arr) throws IllegalArgumentException {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Array is empty or null");
		}
		double sum = getSumOfArray(arr);
		return sum / arr.length;
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