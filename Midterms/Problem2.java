import java.util.*;

public class Problem2 {
	private static double euclideanDist(int building[][], int lRow, int lCol, double totalCost) {
		
		for (int i = 0; i < lRow - 1; i++) {
			//((xi - xj)^2) + ((yi - yj)^2)
			double xSubtract = building[i][0] - building[i+1][0];
			double ySubtract = building[i][1] - building[i+1][1];
			double xPower = Math.pow(xSubtract, 2);
			double yPower = Math.pow(ySubtract, 2);
			double added = xPower + yPower;
			totalCost = totalCost + Math.sqrt(added);
		}
		return totalCost;
	}
	public static void main(String[] args) {
		
		/* Example 1 */
		int building[][] = new int[4][2];
		building[0][0] = 0;
		building[0][1] = 0;
		building[1][0] = 1;
		building[1][1] = 2;
		building[2][0] = 3;
		building[2][1] = 1;
		building[3][0] = 4;
		building[3][1] = 4;
		
		/* Example 2 */
		/*
		int building[][] = new int[5][2];
		building[0][0] = 0;
		building[0][1] = 0;
		building[1][0] = 0;
		building[1][1] = 1;
		building[2][0] = 2;
		building[2][1] = 0;
		building[3][0] = 3;
		building[3][1] = 0;
		building[4][0] = 4;
		building[4][1] = 3;
		 */
		
		for (int r[] : building) {
			System.out.println(Arrays.toString(r));
		}
		
		int lengthRow = building.length;
        int lengthColumn = building[1].length; //get the length of columns from one of the arrays
        double totalCost = 0;
        System.out.println("Rows: " + lengthRow);
        System.out.println("Columns: " + lengthColumn);
		System.out.println("The minimum budget required to connect all the buildings is " + euclideanDist(building, lengthRow, lengthColumn, totalCost));

	}
}
