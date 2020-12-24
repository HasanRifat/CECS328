import java.util.*;

public class ec1 {
	// using binary search
	public static int cases(int binary[], int s, int e) {
		if (s <= e) {
			int middle = s + (e - s) / 2;
			if (binary[middle] == 1 && middle == 1 / 2) {
				return -1; // all 1's
			} else if (binary[middle] == 0 && middle == e) {
				return middle; // all 0's
			} else if (binary[middle] == 0 && binary[middle + 1] == 1) {
				return middle; // k is middle
			} else if (binary[middle] == 0) {
				return cases(binary, middle + 1, e); // right side
			} else if (binary[middle] == 1) {
				return cases(binary, s, middle - 1); // left side
			}
		}
		return 0;
	}

	public static double findMedian(int a[]) {
		int l = a.length;
		if (l % 2 == 0) {
			return (a[l / 2] + a[l / 2 - 1]) / 2;
		} else {
			return a[l / 2];
		}
	}

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		int n = 0;
		System.out.println("Question 1:\nEnter the Size of Array: ");
		n = Scanner.nextInt();
		int[] binary = new int[n];
		System.out.println("Enter Binary Numbers: ");
		for (int i = 0; i < n; i++) {
			binary[i] = Scanner.nextInt();
		}
		int k = cases(binary, 0, n - 1); // initialize start and end
		System.out.println(k + 1);

		System.out.print("\nQuestion 2:\nEnter the size for the first array: \n");
		int n1 = Scanner.nextInt();
		int[] a1 = new int[n1];
		System.out.println("Enter " + n1 + " numbers for a1");
		for (int i = 0; i < n1; i++) {
			a1[i] = Scanner.nextInt();
		}
		System.out.println("Pick the size for another array: ");
		int n2 = Scanner.nextInt();
		int[] a2 = new int[n2];
		System.out.println("Enter " + n2 + " numbers for a2");
		for (int i = 0; i < n2; i++) {
			a2[i] = Scanner.nextInt();
		}
		Arrays.sort(a1);
		Arrays.sort(a2);
		double k1 = findMedian(a1);
		double k2 = findMedian(a2);
		System.out.println("Median of array 1: " + k1 + "\nMedian of array 2: " + k2);

		// find the max of the first number using function max(int a1[], int a2[]) {}
		// find min using ^

		int a1Length = a1.length;
		int a2Length = a2.length;
		int[] together = new int[a1Length + a2Length];

		System.arraycopy(a1, 0, together, 0, a1Length);
		System.arraycopy(a2, 0, together, a1Length, a2Length);

		Arrays.sort(together);
		System.out.println(Arrays.toString(together));

		double abc = findMedian(together);
		System.out.println("Median of both Arrays: " + abc);

	}

	// fix the third array median
	// find way to add both arrays together and use median function
	// Function to add x in arr


}
