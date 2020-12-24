package p2;

import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		int n = 0;
		int key = 0;
		int counter = 0;
		System.out.println("What's the key: ");
		key = Scanner.nextInt();
		System.out.println("Enter the Size of Array: ");
		n = Scanner.nextInt();
		int[] a = new int[n];
		System.out.println("Enter array in sorted order: ");
		for (int i = 0; i < n; i++) {
			a[i] = Scanner.nextInt();
		}
		for (int i = 0; i<a.length;i++) {
			if (a[i] == key) {
				counter++;
			}
		}
		System.out.println(key + " was repeated " + counter + " times");
	}
}

	
