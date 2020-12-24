import java.util.*;

public class Q3 {
	private static LinkedList<Node> graph = new LinkedList<Node>();
	private int u;
	private int v;

	public Q3() {
	};

	public Q3(int u, int v) { //sets the size and order for BFS
		this.u = u;
		this.v = v;
		graph = new LinkedList<Node>();
		for (int i = 0; i < u; i++) {
			graph.add(new Node());
		}
	}

	public void BFS(int point, boolean[][] checked, int j, int k, int[][] m) {
		int note = 0;
		Node v = graph.get(point);
		v.setDistance(0);
		v.setParent(null); // -1
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(v);
		Node w = null;
		int x = 0;
		int y = 0;
		while (!queue.isEmpty()) {
			w = queue.poll();
			for (int e = 0; e < 8; e++) { //8 for all directions
				while (x != j - 1 || y != k - 1) {
					x++;
					if (m[x][y] == 1) {
						checked[j][k] = true;
						note++;
					}
					y++;
					}
				}
			}
		for (Node u : w.getNeighbors()) { //iterate through adjacent nodes
			if (u.getParent() == null) {
				u.setParent(w);
				u.setDistance(w.getDistance() + 1);
				queue.add(u);
			}
		}
	}

	public static void main(String[] args) {
		/* Example 1 */
		int[][] m = new int[][] { // 5 rows 4 columns
				{ 0, 1, 1, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 1, 1, 0, 0 } };

		/* Example 2 */
		/*
		 * int m[][] = new int[][] { //3 rows 5 columns { 1, 1, 1, 0, 1 }, { 1, 0, 0, 0,
		 * 0 }, { 0, 0, 1, 1, 0 }, };
		 */
		int counter = 0;
		Q3 g = new Q3(5, 4);
		for (int r[] : m) {
			System.out.println(Arrays.toString(r));
		}
		int lengthRow = m.length;
		int lengthColumn = m[1].length; // get the length of columns from one of the arrays
		boolean[][] checked = new boolean[lengthRow][lengthColumn];
		System.out.println("Rows: " + lengthRow);
		System.out.println("Columns: " + lengthColumn);
		int startNode = (m[1][1]);
		System.out.println("Starting node m[1][1] = " + startNode);
		
		for (int j = 0; j < lengthRow; j++) {
			for (int k = 0; k < lengthColumn; k++) {
				if (m[j][k] == 1 && !checked[j][k]) {
					g.BFS(startNode, checked, lengthRow, lengthColumn, m);
					counter++;
				}
			}
		}
		System.out.println("Number of one's in matrix: " + counter);
		System.out.println("The total number of connected components is " );
	}
}
