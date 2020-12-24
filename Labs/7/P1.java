import java.util.*;

class P1 {
	public LinkedList<Node> graph;
	// from Lecture 27
	public static void BFS(Node s) {
		s.setDistance(0); // 0 bc starting node
		s.setParent(null); // original node has no parent
		Queue<Node> queue = new LinkedList<>(); // every new node is pushed to empty queue
		queue.add(s);
		while (queue.size() != 0) {
			Node w = queue.remove();
			Node[] adj = w.adj;// pointer
			
			for (int i = 0; i < adj.length; i++) { // takes popped neighbors and adds to queue if null
			
				if (adj[i].getParent() == null) {
					path(adj);
					System.out.println();
					adj[i].setParent(w); // sets pointer to w
					adj[i].setDistance(w.getDistance() + 1);
					queue.add(adj[i]);
					
				}
			}
		}
	}
	public static void path(Node[] adj) {
		for (int o = 0; o < adj.length; o++) {
			Node p = adj[o];
			System.out.print(" <- " + p.getDistance());
		}
	}
	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		Node[] matrix = new Node[8]; // 8 nodes
		for (int i = 0; i < 8; i++) {
			matrix[i] = new Node();
		}
		
		/**
		 * a -> c/d 	//a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7
		 * b -> c/e
		 * c -> b/d
		 * d -> c/e/f
		 * e -> a/c/e/f
		 * f -> d/e/h
		 * g -> isolated node
		 * h -> f
		 */

		matrix[0].setAdj(new Node[] { matrix[2], matrix[3] }); // a
		matrix[1].setAdj(new Node[] { matrix[2], matrix[4] }); // b
		matrix[2].setAdj(new Node[] { matrix[1], matrix[3] }); // c
		matrix[3].setAdj(new Node[] { matrix[2], matrix[4], matrix[5] }); // d
		matrix[4].setAdj(new Node[] { matrix[0], matrix[2], matrix[4], matrix[5] }); // e
		matrix[5].setAdj(new Node[] { matrix[3], matrix[4], matrix[7] }); // f
		matrix[6].setAdj(new Node[] { null }); // g (isolated)
		matrix[7].setAdj(new Node[] { matrix[5] }); // h

		System.out.print("Determine starting vertex a for BFS: (integers only) ");
		int u = Scanner.nextInt();
		BFS(matrix[u - 1]);
		System.out.println("Shortest path from vertex " + u + ":");
		int count = 1;
		for (int i = 0; i < 8; i++) {
			System.out.println("Node " + u + " to " + count++ + " is " + matrix[i].getDistance());
		}
	}
}
