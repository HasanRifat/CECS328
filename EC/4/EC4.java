import java.util.*;

public class EC4 {
	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		System.out.print("Enter k index away from position: ");
		int k = Scanner.nextInt();
		int[] a = { 2, 8, 0, 17, 5, 12 };
		System.out.print("Unsorted array: ");
		Scanner.close();
		System.out.println(Arrays.toString(a));
		System.out.print("Array is sorted until index " + k + ": [ ");
		minHeap(a, a.length, k);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.print("]");
	}

	private static void minHeap(int[] a, int n, int k) {
		PriorityQueue<Integer> binHeap = new PriorityQueue<>();
		for (int i = 0; i < k + 1; i++) {
			binHeap.add(a[i]);
		}
		int i = 0;
		for (int j = k + 1; j < n; j++) {
			a[i++] = binHeap.peek();
			binHeap.poll();
			binHeap.add(a[j]);
		}
		Iterator<Integer> it = binHeap.iterator();
		while (it.hasNext()) {
			a[i++] = binHeap.peek();
			binHeap.poll();
		}
	}
}
