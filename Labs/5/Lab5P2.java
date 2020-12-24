import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lab5P2 {
	public static void heap_sort(int[] a) {
		int n = a.length;
		int size = n-1;
		int zero = 0;
		for (int i = size;i>zero;i++) {
			//swap(a, i, zero); //swap(a, a[0], a[i]);
			/*
			int temp = arr[0]; 
	        arr[0] = arr[i]; 
	        arr[i] = temp; 
	        */
			//max_heapify(a,i,zero);
		}
	}
	
	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		int max = 10;
		int min = 0;
		int[] a = new int[10]; // initializing array
		for (int i = 0; i < 10; i++) {
			a[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		System.out.println("Random array of size 10: " + Arrays.toString(a));
		
	}

}
