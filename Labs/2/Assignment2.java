import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Assignment2 {

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		int N = 0;
		int sqrt = 0;
		System.out.println("Input a number: ");
		N = Scanner.nextInt();
		System.out.println("Input: " + N);

		sqrt = squareRt(N);

		System.out.println("Output: " + sqrt);

		System.out.println("\nQuestion 2\nEnter size of array: ");
		int maxSize = Scanner.nextInt();
		System.out.println("Enter max range -> m: ");
		int m = Scanner.nextInt();
		int[] sizeArray = new int[maxSize];
		Set<Integer> set = new LinkedHashSet<Integer>();

		while (set.size() < maxSize) {
			set.add(ThreadLocalRandom.current().nextInt(0, m));
		}
		System.out.println("Unsorted set: " + set);
		Iterator value = set.iterator();
		for (int i = 0; i < sizeArray.length; i++) {
			sizeArray[i] = (int) (value.next());
		}
		Arrays.sort(sizeArray);

		System.out.println("Sorted array is ");
		for (int i = 0; i < sizeArray.length; i++) {
			System.out.println(sizeArray[i]);
		}
		// Assignment2 smallestNum = new Assignment2();
		System.out.println("Smallest missing number is " + binSearch(sizeArray, 0, sizeArray.length - 1));

	}

	public static int binSearch(int a[], int s, int e) {
		int middle = (s + e) / 2;
		if (s > e) {
			return e + 1;
		}
		if (s != a[s]) {
			return s;
		}

		if (a[middle] == middle) {
			return binSearch(a, middle + 1, e);
		}
		return binSearch(a, s, middle);
	}

	public static int squareRt(int n) {
		int squared = 0;
		int s = 1;
		int e = n;

		while (s <= e) {
			int middle = (s + e) / 2;
			if (middle * middle == n) {
				return middle;
			}
			if (middle * middle < n) {
				s = middle + 1;
				squared = middle;
			} else {
				e = middle - 1;
			}
		}
		Math.ceil(squared);
		if (n > (squared * squared)) {
			squared = squared + 1;
		}
		return squared;
	}
}
