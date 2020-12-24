import java.util.*;

public class EC3 {
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner Scanner = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int n = Scanner.nextInt();
		int[] a = new int[n];
		int max = 100;
		int min = -100;
		System.out.print("Generated Array: [ ");
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(max - min) + min;

			System.out.print(a[i] + ", ");
		}
		System.out.println("]\nOutput of O(n) function: " + MSS2(a, 0, a.length - 1));
		System.out.println("Output of O(nlogn): " + MSS1(a));
	}

	/* T(n) = O(n) */
	public static int MSS1(int[] a) {
		int max = Integer.MIN_VALUE;
		int last = 0;
		for (int i = 0; i < a.length; i++) {
			last += a[i];
			last = Math.max(last, a[i]);
			max = Math.max(max, last);
		}
		return max;
	}

	/* T(n) = O(nlogn) */
	public static int MSS2(int[] a, int l, int r) {
		if (r == l) {
			return a[l];
		}
		int mid = (l + r) / 2;
		int lMax = Integer.MIN_VALUE;
		int add = 0;
		for (int i = mid; i >= l; i--) {
			add += a[i];
			if (add > lMax) {
				lMax = add;
			}
		}
		int rMax = Integer.MIN_VALUE;
		add = 0;
		for (int i = mid + 1; i <= r; i++) {
			add += a[i];
			if (add > rMax) {
				rMax = add;
			}
		}
		int maxInt = Integer.max(MSS2(a, l, mid), MSS2(a, mid + 1, r));
		return Integer.max(maxInt, lMax + rMax);
	}

}
