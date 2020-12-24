import java.util.*;
public class Problem2 {
	/* Checks For Subset */
	public static boolean HashCheck(int[] a1, int[] a2, int length1, int length2) {
		HashSet<Integer> table = new HashSet<>();
		for (int i = 0; i<length1;i++) {
			if (!table.contains(a1[i])) {
				table.add(a1[i]);
			}
		}
		for (int i = 0;i<length2;i++) {
			if (!table.contains(a2[i])) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
	    /* Setting up Problem */
		Scanner Scanner = new Scanner(System.in);
		/*
		System.out.print("Enter size of sorted array: ");
		int n = Scanner.nextInt();
		int[] array1 = new int[n];
		System.out.println("Enter array in sorted order: ");
		for (int i = 0; i < n; i++) {
			array1[i] = Scanner.nextInt();}
		Arrays.sort(array1);
		System.out.println("Array n: " + Arrays.toString(array1));
		System.out.println("Enter size of random array: (smaller than first array) ");
		int k = Scanner.nextInt();
		int[] array2 = new int[k];
		int max = 50;
		for (int i = 0;i<array2.length;i++) {
			array2[i] = new Random().nextInt(max-50);}
		System.out.println("Array k: " + Arrays.toString(array2));
		*/
		/* For Testing */
		int[] array1 = {-2, 3, 5, 7, 8, 10, 15};
        System.out.println(Arrays.toString(array1));
		int[] array2 = {-2,10,5, 9};
        System.out.println(Arrays.toString(array2));
		int l1 = array1.length;
		int l2 = array2.length;
		if (HashCheck(array1, array2, l1, l2)) {
			System.out.println("B is a subset of A");
		} else {
			System.out.println("B is not a subset of A");
		}
	}
}
/*
		int first = array1[array1.length-1];
		int last = array1[0];
		for (int i = 0; i<array2.length;i++) {
		    binarySearch(array1, first, last, array2[i]);
		}
		*/
/*
    public static boolean binarySearch(int[] a, int start, int end, int key) {
		int mid = (start + end) / 2;
		if (start <= end) {
			if (a[mid] > key) {
				return binarySearch(a, start, mid - 1, key);
			} else if (a[mid] < key) {
				return binarySearch(a, mid - 1, end, key);
			} else {
				return true;
			}
		}
		return false;
	}
    */
