package p3;
import java.util.*;
public class Part3 {

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		int n = 0;
		
		System.out.println("Input the size of the array: ");
		n = Scanner.nextInt();
		int[] a = new int[n]; 
		int max = n;
		for (int i = 0;i<a.length;i++) {
			a[i] = new Random().nextInt(max-1);
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
		int a_size = a.length;
		countReps(a, a_size);
	}
	
	static void countReps(int arr[], int length) { //remove static
		int max = 0;
        int pointer = 0;
       //ArrayList<Integer> repeatedArr = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) { 
        	
        	if (arr[i] == -1) {
        		continue;
        	}
        	
        	pointer = 1;
        	for (int k = i + 1;k<length;k++) {
        		if(arr[i] == arr[k]) {
        			arr[k] = -1;
        			pointer++;
        		}
        	}
        	if (pointer > 1) {
        		if (pointer >= max) {
        			max = pointer;
        			System.out.println(arr[i] + " is the mode" );
        		}
        		System.out.println(arr[i] + " was repeated " + pointer + " times ");
        	}
        }	
	}	
}
     /*   	
        	
        	pointer = 0;
            for (j = i + 1; j < length; j++) { 
                if (arr[i] == arr[j])  {
                	
                	repeatedArr.add(arr[i]);
                	System.out.print(repeatedArr + " ");
                	
                	//last element System.out.println("\n" + repeatedArr.get(repeatedArr.size() - 1));
                	
                } else {
                	System.out.print("no ");;
                }
            } 
        } 
    } 
	
}
		
	*/
	 


