public class Node {

	private Node parent;
	public Node[] adj;
	private int distance;
	private int value;

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setAdj(Node[] adjFull) {
		adj = adjFull;
	}
	
	public Node[] getAdj() {
		return adj;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node() { // default constructor
		parent = null;
		adj = null;
		distance = 0;
	}

	public Node(Node[] adj) {
		parent = null;
		this.adj = adj;
		distance = 0;
	}

	public Node(Node parent, Node[] adj, int distance) { // node constructor
		this.parent = parent;
		this.adj = adj;
		this.distance = distance;
	}
}
