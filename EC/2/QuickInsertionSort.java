import java.util.*;

public class QuickInsertionSort {

	public static void Quicksort(int[] a, int start, int end) {
		if (start < end) {
			int index = partition(a, start, end);
			int keyN = index - 1;
			int keyP = index + 1;
			Quicksort(a, start, keyN);
			Quicksort(a, keyP, end);
		}
	}
	
	public static int partition(int[] a, int start, int end) {
		int mid = a[(start + end) / 2];
		while (start < end) {
			if ((a[start]) < (mid)) {
				start++;
			} else if ((a[end]) > (mid)) {
				end--;
			} else {
				swap(a, start, end);
			}
		}
		return start;
	}
	
	private static void swap(int[] a, int left, int right) {
		int temp = a[right];
		a[right] = a[left];
		a[left] = temp;
	}
	
	public static void Insertionsort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int pointer = a[i];
			int k = i - 1;
			while (k >= 0 && a[k] > pointer) {
				a[k + 1] = a[k];
				k = k - 1;
			}
			a[k + 1] = pointer;
		}
	}

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Enter a positive integer: ");
		int number = Scanner.nextInt();

		/* Quick sort */

		int[] a = new int[number];
		int max = 5000;
		int min = -5000;
		long s = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			for (int k = 0; k < a.length; k++) {
				a[k] = rand.nextInt(max - min) + min;
			}
			Quicksort(a, 0, a.length - 1);
		}
		long e = System.nanoTime();
		long time = e - s;
		System.out.println(Arrays.toString(a));
		System.out.println("Time for quicksort: " + time + " ns");

		/* Insertion sort */

		int[] a2 = new int[number];
		long s2 = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			for (int k = 0; k < a2.length; k++) {
				a2[k] = rand.nextInt(max - min) + min;
			}
			Insertionsort(a2);
		}
		long e2 = System.nanoTime();
		long time2 = e2 - s2;
		System.out.println(Arrays.toString(a2));
		System.out.println("Time for insertion sort: " + time2 + " ns");

	}

}
