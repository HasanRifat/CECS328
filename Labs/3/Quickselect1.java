import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {
	
	public static int partition(int a[], int start, int end) {
        int mid = a[(start + end)/2];
        while (start < end) {
            if (a[start] < mid) {
                start++;
            } else if (a[end] > mid) {
                end--;
            } else {
                int swap = a[end];
                a[end] = a[start];
                a[start] = swap;
            }
        }
        return start;
    }
	//using Vivian's pseudocode from class
	public static int quickSelect(int []a, int l, int r, int k) {
        int pivotIndex = partition(a, l, r);
        if (pivotIndex == k) { 
            return a[pivotIndex];
        } else if (pivotIndex > k) { 
            return quickSelect(a, l, pivotIndex -1, k);
        } else {
            return quickSelect(a, pivotIndex +1, r, k); 
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
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		System.out.println(Arrays.toString(a));
		System.out.println("Enter a number between 1 and " + n + ": ");
		k = Scanner.nextInt();
		System.out.println(k + "rd smallest number: " + quickSelect(a, 0, a.length - 1, k - 1));
		
	}
}
