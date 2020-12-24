import java.util.*;
import java.util.LinkedList;

class Lab8 {
	public static int timer = 0;

	public static void DFS_Visit(Node s) {
		timer++; // increments timer for each visit then set to start timer
		s.setStart(timer);
		for (int v = 0; v < s.adj.length; v++) {

			if (s.adj[v].getStart() == 0) { // null
				s.adj[v].setParent(s);
				DFS_Visit(s.adj[v]);
			} else if (s.adj[v].getStart() != 0 && s.adj[v].getEnd() == 0) { // back edge
				System.out.println("Cycle detected, topological sort is impossible");
				System.exit(0);
			}
		}
		timer++; // increment timer again and set to end timer
		s.setEnd(timer);
	}

	public static void DFS(Node s) {
		timer = 0;
		// test.setValue(-1);
		for (int n = 0; n < s.adj.length; n++) {
			Node p = s.adj[n];
			topological(p.getEnd());
			if (s.adj[n].getParent() == null) {
				Node o = s.adj[n];
				o.setValue(-1);
				s.adj[n].setParent(o);
				// s.adj[n].setParent(null); //Can't set this to int type since it's already
				// node so not sure how to set to -1

				DFS_Visit(s);
			}
		}
	}

	public static LinkedList<Integer> topological(int n) {
		LinkedList<Integer> topSort = new LinkedList<Integer>();
		topSort.add(n);
		System.out.print(topSort + " <-- ");
		return new LinkedList<Integer>();
	}

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);

		Node[] matrix = new Node[8];
		for (int i = 0; i < 8; i++) {
			matrix[i] = new Node();
		}
		
		matrix[0].setAdj(new Node[] { matrix[1], matrix[2], matrix[3] });
		matrix[1].setAdj(new Node[] { matrix[3] });
		matrix[2].setAdj(new Node[] { matrix[3] });
		matrix[3].setAdj(new Node[] { matrix[4] });
		matrix[4].setAdj(new Node[] { matrix[6] });
		matrix[5].setAdj(new Node[] { matrix[4] });
		matrix[6].setAdj(new Node[] {}); // goes to nothing
		/*
		matrix[0].setAdj(new Node[] { matrix[1], matrix[2]});
		matrix[1].setAdj(new Node[] { matrix[2], matrix[3], matrix[4]});
		matrix[2].setAdj(new Node[] { matrix[3] });
		matrix[3].setAdj(new Node[] { matrix[4] });
		matrix[4].setAdj(new Node[] { matrix[1] });
		matrix[5].setAdj(new Node[] { matrix[4] });
		matrix[6].setAdj(new Node[] {}); */
		System.out.print("Enter the starting vertex: ");
		int u = Scanner.nextInt();
		DFS(matrix[u-1]);
		//DFS_Visit(matrix[u - 1]);

		System.out.println("\nDFS starting and ending times in start/end format starting from node " + u + ":");
		for (int i = 0; i < 8; i++) {
			System.out.println("Node " + (i + 1) + ": " + matrix[i].getStart() + "/" + matrix[i].getEnd());
		}
		
	}
}
