import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lab5 {
	public static void swap(int[] a, int pointer, int i) {
		int holder = a[pointer];
		a[pointer] = a[i];
		a[i] = holder;
	}
	public static void selection_sort(int[] a) {
		int n = a.length;
		int size = n-1;
		for (int i = 0; i< size; i++) {
			int pointer = i;
			for (int k = i+1; k<n;k++) {
				if(a[k] < a[pointer])
					pointer = k;
			}
		//swap(a, pointer, i);
		
		int temp = a[pointer];
		a[pointer] = a[i];
		a[i] = temp;
		/*
		*/
		}
		
	}
	public static void heap_sort(int[] a) {
		int n = a.length;
		int size = n-1;
		int zero = 0;
		build_MaxHeap(a); 
		
		for (int i = size;i>zero;i--) {
			//swap(a, a[0], a[i]); //swap(a, i, zero);
			
			int temp = a[0]; 
	        a[0] = a[i]; 
	        a[i] = temp;
	        /*
	        */
			max_heapify(a,i,zero); //maxHeapify(a, i, 0); 
		}
	}
	public static void build_MaxHeap(int[] a) {
		//int[] new_a = new int[100];
		
		int n = a.length;
		int s = (n/2) - 1;
		for (int i = s;i>=0;i--) {
			max_heapify(a,n,i);
		}
	}
	public static void max_heapify(int[] a, int len, int i) {
		int max = i;
		int left = 2 * i+ 1;
		int right = 2 * i + 2;
		if (left < len && a[left] > a[max]) {
			max = left;
		}
		if (right < len && a[right] > a[max]) {
			max = right;
		}
		if (max != i) { 
			/*swap(a, max, i);
			*/
			int swap = a[i];
			a[i] = a[max];
			a[max] = swap;
			max_heapify(a,len,max);
			
		}
	}
	
	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		
		/* Part 1 */
		System.out.println("----Part 1----");
		
		int a2 [] = new int[1000]; //initializing array for selection/heap sort
		for (int j = 0; j < a2.length; j++)
		{
			a2[j] = ThreadLocalRandom.current().nextInt(0, 100 + 1);
		}
		
		long clockS = System.nanoTime();
		for (int i = 0; i < 100; i++)
		{
			heap_sort(a2);
		}
		long clockE = System.nanoTime();
		long totalTime = clockE - clockS; 
		System.out.println("\nAverage-running time of heap sort function: " + totalTime/100 + " nanoseconds");
		
		long selectionStart = System.nanoTime();
		for (int i = 0; i < 100; i++)
		{
			selection_sort(a2);
		}
		long selectionEnd = System.nanoTime();
		long timeDiff = selectionEnd - selectionStart; 
		System.out.println("\nAverage-running time of selection sort function: " + timeDiff/100 + " nanoseconds");
		/* Part 2 */
		int max = 100;
		int min = -100;
		int n = 0;
		System.out.println("\n----Part 2----\n");
		
		System.out.print("Enter a positive integer: ");
		n = Scanner.nextInt();
		int[] a = new int[n]; // initializing array
		for (int i = 0; i < n; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		System.out.println("\nUnsorted Array: " + Arrays.toString(a));
		heap_sort(a);
		System.out.println("\nSorted Array using Heap Sort: " + Arrays.toString(a));
	}

}
