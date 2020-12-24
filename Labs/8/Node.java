public class Node {

	private Node parent;
	public Node[] adj;
	private int start;
	private int end;
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

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public Node() { // default constructor
		parent = null;
		adj = null;
		setStart(0);
		setEnd(0);
		distance = 0;
	}

	public Node(Node[] adjFull) {
		parent = null;
		adj = adjFull;
		setStart(0);
		setEnd(0);
		distance = 0;
	}

	public Node(Node parent, Node[] adj, int start, int end, int distance) { // node constructor
		this.parent = parent;
		this.adj = adj;
		this.setStart(start);
		this.setEnd(start);
		this.distance = distance;
	}
}
