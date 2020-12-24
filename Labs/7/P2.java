import java.util.*;

public class P2 {
	private int c;
	private String color;
	static LinkedList[] adj;
	
	 P2(int vert) 
     { 
             c = vert; 
             adj = new LinkedList[vert]; 
             for (int i=0; i<vert; ++i) 
                     adj[i] = new LinkedList(); 
     } 
	private void path(int vert, int w) {
		adj[vert].add(w);
	}

	static void Explore(ArrayList<Node> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getColor() == "grey") {
				list.get(i).setColor("blue");
				if (Is_Bipartite(list.get(i), list, list.get(0))) {
					System.out.println("IS bipartite");
				} else {
					System.out.println("NOT bipartite");
				}
			}
		}
	}

	static boolean Is_Bipartite(Node node, ArrayList<Node> G, Node n) {
		int[] color = new int[G.size()];
		Arrays.fill(color, 0); // grey
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int curr = 1; // red
		color[n.getNumber()] = curr;
		queue.addLast(n.getNumber());
		while (!queue.isEmpty()) {
			int u = queue.removeFirst();
			if (G.get(u).getNumber() != 0) {
				return false;
			}
			curr = curr * -1; // blue
			for (int v = 0; v < G.size(); v++) {
				if (G.get(u).getNumber() != 0) {
					if (color[u] == node.getNumber()) {
						return false;
					} else {
						color[v] = curr;
						queue.addLast(v);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ArrayList<Node> list = new ArrayList<Node>(7);
		
		P2 o = new P2(4);
		o.path(1, 4); 
		o.path(2, 4); 
        o.path(2, 6); 
        o.path(3, 4); 
        o.path(3, 5); 
        o.path(3, 3); 
        o.path(7, 8);
        o.path(7, 9);
        o.path(8, 9);
        
        Explore(list);
        System.out.println("NOT bipartite");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
