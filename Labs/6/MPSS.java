import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MPSS {
	public static double MPSS_mid(double a[], int start, int end) {
		int mid = a.length / 2;
		double subL[] = new double[mid];
		double subR[] = null;
		double Smin = Double.POSITIVE_INFINITY;
		double MPSS_MID = 0.0;
		if (a.length % 2 == 0) {
			subR = new double[mid];
		} else {
			subR = new double[mid + 1];
		}
		double leftover = 0;
		int subLIndex = subL.length - 1;
		for (int i = mid; i > start; i--) { // Filling Sl with left half of array
			leftover += a[i];
			subL[subLIndex] += leftover;
			subLIndex--;
		}
		double sumRight = 0;
		int subRIndex = 0;
		for (int i = mid + 1; i < end; i++) { // Filling Sr with right half of array
			sumRight += a[i];
			subR[subRIndex] += sumRight;
			subRIndex++;
		}
		heap_sort(subL);
		heap_sort(subR);
		int n = subR.length;
		subR = reverse(subR, n);
		int i = 0;
		int j = 0;
		while (i != subL.length && j < subR.length) { // Keeps running while iterators are less than the length
			double s = subL[i] + subR[j];
			if (s <= 0) {
				i++;
			} else if (s < Smin) {
				Smin = s;
				j++;
			} else {
				j++;
			}
		}
		MPSS_MID = Smin;
		return MPSS_MID;
	}

	public static double MPSS(double a[], int start, int end) {
		if (start != end) {
			int middle = (start + end) / 2;
			double leftMPSS = MPSS(a, start, middle);
			double rightMPSS = MPSS(a, middle + 1, end);
			double midMPSS = MPSS_mid(a, start, end); // explain for this part why I can't have MSS and have to make it
														// it's own method
			double compare = Math.min(leftMPSS, rightMPSS);
			return (Math.min(midMPSS, compare));
		} // review algorithm for MSS
			// explain why this algorithm works better
			// T(n)?
		else if (start == end) {
			return a[0];
		}
		return 0;
	}

	public static void heap_sort(double[] a) {
		int n = a.length;
		int size = n - 1;
		int zero = 0;
		build_MaxHeap(a);

		for (int i = size; i > zero; i--) {
			double temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			max_heapify(a, i, zero); // maxHeapify(a, i, 0);
		}
	}

	public static void build_MaxHeap(double[] a) {
		// int[] new_a = new int[100];
		int n = a.length;
		int s = (n / 2) - 1;
		for (int i = s; i >= 0; i--) {
			max_heapify(a, n, i);
		}
	}

	public static void max_heapify(double[] a, int len, int i) {
		int max = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < len && a[left] > a[max]) {
			max = left;
		}
		if (right < len && a[right] > a[max]) {
			max = right;
		}
		if (max != i) {
			double swap = a[i];
			a[i] = a[max];
			a[max] = swap;
			max_heapify(a, len, max);
		}
	}

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		/*
		 * testing array from example double[] a = {2, -3, 1, 4, -6, 10, -12, 5.2, 3.6,
		 * -8 }; System.out.println(MPSS(a, 0, a.length-1));
		 */

		System.out.print("Enter the size of the array: ");
		int size = Scanner.nextInt();
		double[] a = new double[size];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) ThreadLocalRandom.current().nextDouble(-20, 20 + 1);
		}
		System.out.println(Arrays.toString(a));
		int end = a.length - 1;
		System.out.println(MPSS(a, 0, end));
	}

	static double[] reverse(double[] a, int n) {
		double[] t = new double[n];
		int index = 0;
		for (int i = a.length - 1; i > 0; i--) {
			t[index] = a[i];
			index++;
		}
		return t;
	}
}
