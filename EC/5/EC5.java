import java.util.*;
public class EC5 { 
	Node root; 
    
    public void preOrderTraversal(Node node) 
    { 
        if (node != null) 
        { 
            System.out.print(node.key + " "); 
            preOrderTraversal(node.left); 
            preOrderTraversal(node.right); 
        } 
    } 
    public static void main(String[] args) { 
        EC5 newTree = new EC5();
        Scanner input = new Scanner (System.in);
        System.out.println("How many nodes to add? ");
        int num = input.nextInt();
        for (int i = 0; i < num ; i++ )
        {
        	System.out.print("Enter your next node: ");
            int node = input.nextInt();
            newTree.root = newTree.insert(newTree.root, node); 
        }
        System.out.println("AVL tree is: "); 
        newTree.preOrderTraversal(newTree.root); 
    } 
} 
