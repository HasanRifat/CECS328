 import java.util.*;

public class Lin_BinSearch {
	// implementing linearSearch and binarySearch functions
	static boolean linearSearch(int a[], int key) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			if (a[i] == key)
				return true;
		}
		return false;
	}

	static boolean BinarySearch(int a[], int start, int end, int key) {
		int mid = (start + end) / 2;
		if (start <= end) {
			if (a[mid] > key) {
				return BinarySearch(a, start, mid - 1, key);
			} else if (a[mid] < key) {
				return BinarySearch(a, mid - 1, end, key);
			} else {
				return true;
			}
		}
		return false;
	}

	public static int inp_size(double d) {
		int result = (int) (Math.log(d) / Math.log(2));
		return result;
	}

	public static void main(String[] args) {
		int n;
		int user_input = 1;
		Random rand = new Random();
		int max = 1000;
		int min = -1000;
		int key;
		Scanner scanner = new Scanner(System.in);

		while (user_input == 1 || user_input == 2) { // while loop to pick which lab to run
			System.out.println("To choose a lab, input '1' or '2' or 'q' to quit");
			user_input = scanner.nextInt();
			if (user_input == 1) { // runs lab 1a
				System.out.print("Please input a positive integer: ");
				n = scanner.nextInt(); // n = 100000

				int[] a = new int[n]; // creates new array
				long begin = System.nanoTime(); // starts timer
				for (int i = 0; i < a.length; i++) {
					a[i] = rand.nextInt(max - min) + min; // generates n number of integers
				}
				Arrays.sort(a); // sorts array
				for (int i = 0; i < 100; i++) {
					key = a[rand.nextInt(n)]; // picks a new key after every loop
					linearSearch(a, key); // uses function linearSearch to go through array to find key
				}
				// System.out.println("Key: " + key);
				long end = System.nanoTime(); // stops timer
				long time = end - begin; // prints average-running time
				System.out.println("Average-Case Running Time: " + time / 100 + " nanoseconds");
			}

			if (user_input == 2) {
				System.out.println("Please input a positive integer: ");
				int n2 = scanner.nextInt();
				int[] b = new int[n2];
				for (int i = 0; i < b.length; i++) {
					b[i] = rand.nextInt(max - min) + min;
				}
				Arrays.sort(b);
				key = 5000; // key exceeds range
				int firstNum = b[b.length - 1];
				int lastNum = b[0];
				System.out.println(firstNum);
				System.out.println(lastNum);

				// finds time for worst case for binary search
				long begin1 = System.nanoTime();
				linearSearch(b, key);
				long end1 = System.nanoTime();
				long time1 = end1 - begin1;
				System.out.println("Worst Case for Linear Search: " + time1 + " nanoseconds");
				// finds time for worst case for binary search
				long begin2 = System.nanoTime();
				BinarySearch(b, firstNum, lastNum, key);
				long end2 = System.nanoTime();
				long time2 = end2 - begin2;
				System.out.println("Worst Case for Binary Search: " + time2 + " nanoseconds");
				long math1 = time1 / inp_size(n2);
				System.out.println("Time for running a single line of linear search: " + math1 + " nanoseconds");
				long math2 = time2 / inp_size(n2);
				System.out.println("Time for running single line of binary search: " + math2 + " nanoseconds");
				System.out.println(
						"Worst case runtime for linear search when n^15: " + math1 * Math.pow(10, 15) + " nanoseconds");
				System.out.println("Worst case runtime for linear search when n^15: "
						+ math2 * inp_size(Math.pow(10, 15)) + " nanoseconds");
			}
		}
	}
}
