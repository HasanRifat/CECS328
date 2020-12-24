import java.util.*;
public class Node { 
	int key, height; 
    Node left, right;
    Node() {};//default
    Node(int data) { 
    	key = data; 
	    height = 1; 
	    }  

    int height(Node node) 
    { 
        if (node == null) 
            return 0; 
        return node.height; 
    } 
  
    public Node rightRotate(Node y) 
    { 
        Node x = y.left; 
        Node z = x.right; 
        x.right = y; 
        y.left = z;  
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
        return x; 
    } 
  
    public Node leftRotate(Node x) 
    { 
        Node y = x.right; 
        Node z = y.left; 
        y.left = x; 
        x.right = z; 
        x.height = Math.max(height(x.left), height(x.right)) + 1; 
        y.height = Math.max(height(y.left), height(y.right)) + 1; 
        return y; 
    } 
    public int getBalance(Node node) 
    { 
        if (node == null) 
            return 0;  
        return height(node.left) - height(node.right); 
    } 
  
    public Node insert(Node node, int key) 
    { 
        if (node == null) 
            return (new Node(key));  
        if (key < node.key) 
            node.left = insert(node.left, key); 
        else if (key > node.key) 
            node.right = insert(node.right, key); 
        else 
            return node; 
        node.height = 1 + Math.max(height(node.left), 
                              height(node.right)); 
        int balance = getBalance(node); 
        if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 
        if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 
        if (balance > 1 && key > node.left.key) 
        { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
        if (balance < -1 && key < node.right.key) 
        { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
        return node; 
    } 
}
