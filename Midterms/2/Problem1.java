import java.util.*;
public class Problem1 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        /* Setup */
        /*
        System.out.print("Enter size of random array: ");
        int n = Scanner.nextInt();
        int[] a = new int[n];
        int max = 50;
        for (int i = 0;i<a.length;i++) {
            a[i] = new Random().nextInt(max-1);
        }
        System.out.println(Arrays.toString(a));
        */
        /* For Testing */
        
        int[] a = {10,8,7,5,2,1};
        System.out.println(Arrays.toString(a));
        
        
        /* Finding max-heap */
        boolean checker = true;
        for (int i = 1; i <a.length - 1; i++) {
            int parent = a[((i+1)/2)-1]; //shift by 1
            int child = a[(i+1)-1]; //shift by 1
            if (parent < child) {
                checker = false;
                System.out.println("This is NOT a max-heap ");
                System.exit(0); //exit if array isn't a max-heap
            } 
            checker = true;
        }
        if (checker = true) {
        System.out.println("This is a max-heap ");
        }
    }
}
