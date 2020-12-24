import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect2 {
	public static int partition(int a[], int start, int end) {
		int mid = a[(start + end) / 2];
		while (start < end) {
			if ((a[start]) < (mid)) {
			//if (Math.abs(a[start]) < Math.abs(mid)) {
				start++;
			} else if ((a[end]) > (mid)) {
				end--;
			} else {
				swap(a, start, end);
				/*
				int swap = a[end];
				a[end] = a[start];
				a[start] = swap;
				*/
			}
		}
		return start;
	}

	private static int abs_partition(int[] a, int leftMarker, int rightMarker) {
		int pivot = Math.abs(a[leftMarker]), pivotIndex = leftMarker; // index of the pivot

		for (int i = leftMarker + 1; i <= rightMarker; i++) {

			if (pivot >= Math.abs(a[i])) { 
				swap(a, i, i - 1);
				pivotIndex = i;
			} else if (pivot < Math.abs(a[i])) { 
				swap(a, i--, rightMarker--);
			}
		}
		return pivotIndex;
	}

	private static void swap(int[] a, int left, int right) {
		int temp = a[right];
		a[right] = a[left];
		a[left] = temp;
	}

	public static int quickSelect(int[] a, int l, int r, int k, int flag) {
		int pivotIndex = partition(a, l, r);
		if (pivotIndex == k) {
			return a[pivotIndex];
		} else if (pivotIndex > k) {
			return quickSelect(a, l, pivotIndex - 1, k, 0);
		} else {
			return quickSelect(a, pivotIndex + 1, r, k, 0);
		}
	}

	public static int ogQuickSelect(int[] a, int l, int r, int k) {
		int pivotIndex = partition(a, l, r);
		if (pivotIndex == k) {
			return a[pivotIndex];
		} else if (pivotIndex > k) {
			return ogQuickSelect(a, l, pivotIndex - 1, k);
		} else {
			return ogQuickSelect(a, pivotIndex + 1, r, k);
		}
	}

	public static int[] findMedian(int[] a, int pMedian) {
		int[] diff = new int [a.length];
		for (int i = 0; i < a.length; i++) {
			diff[i] = (a[i] - a[pMedian]);
		}
		return diff;
	}
	
	public static void kClosest(int[] diff, int k, int median) {
		int aLength = diff.length - 1;
		int index = quickSelect(diff, k, 0, aLength, 1);
		System.out.println("k closest elements: [");
		for (int i = 0; i <= index; i++) {
			if (i < index)
				System.out.format("%d, ", (diff[i] + median));
				//System.out.format("%d, ", (diff[i] + median));
			else {
				System.out.format("%d]\n", (diff[i] + median));
			}
		}
	}
	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		int max = 100;
		int min = -100;
		int n = 0;
		int k = 0;
		System.out.print("Enter a positive integer: ");
		n = Scanner.nextInt();
		int[] a = new int[n]; // initializing array
		for (int i = 0; i < n; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		
		System.out.println("Enter a number between 1 and " + n + ": ");
		k = Scanner.nextInt();
		int aLength = a.length - 1; // array size
		
		int pMedian = quickSelect(a, aLength / 2, 0, aLength, 0);
		int[] diff = findMedian(a, pMedian);System.out.println(Arrays.toString(a)); // print array
		System.out.println("Median is " + a[pMedian]);
		
		int median = a[pMedian];
		kClosest(diff, k, median);
		
		
		System.out.println("diff array: " + Arrays.toString(diff));
		System.out.println("k = " + k);
		//System.out.println(k + "rd smallest number: " + quickSelect(a, 0, a.length - 1, k - 1, 1));
	}
}
