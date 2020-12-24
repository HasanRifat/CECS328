import java.util.*;

public class Node {
	private int distance;
	private int value; 
	private Node parent;
	private LinkedList<Node> neighbors; 

	public Node() {
		distance = 0; 
		value = 0; 
		neighbors = new LinkedList<Node>();
		parent = null; 
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

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

	public LinkedList<Node> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(LinkedList<Node> neighbors) {
		this.neighbors = neighbors;
	}

	public LinkedList<Node> neighbors() {
		return neighbors;
	}

	public int compare(Node v, Node u) {
		if (v.value < u.value)
			return -1;
		if (v.value > u.value)
			return 1;
		return 0;
	}
}
