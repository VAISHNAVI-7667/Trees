/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Enter root value: ");
	    int val = sc.nextInt();
		Node root = new Node(val);
		boolean a = true;
		while(a)
		{
		    System.out.print("Enter the elements");
		    val = sc.nextInt();
		    if(val == -1)
		    {
		        a = false;
		    }
		    else{
		        insert(root,val);
		    }
		}
// 		print(root);
        int height=levelOrder(root);
		System.out.print("\nMax depth using level order traversal is "+height); // Finding max height of the tree using level order
		
		// Finding max height of tree using recurssion
		
		System.out.print("\nMax Depth of the tree using recurssion is "+maxDepth(root));
		
		boolean isBalanced;
		if(check(root)==-1)
		isBalanced = false;
		else
		isBalanced = true;
		
		System.out.print("\nBalanced tree : "+isBalanced);
		
		//Find the diametre of a binary tree
		
		int diametre = findDiametre(root);
        System.out.print("diametre of the tree is "+ diametre);
	}
	public int findDiametre(Node root)
	{
	    if(root == null) return 0;
	    
	    int lh = maxDepth(root.left);
	    int rh = maxDepth(root.right);
	    
	    int max = Math.max(max,lh+rh);
	    
	    findDiametre(root.left);
	    findDiametre(root.right);
	} 
	
	public static int check(Node root)
	{
	    if(root == null) return 0;

        int lh = check(root.left);
        int rh = check(root.right);

        if(lh==-1 || rh==-1) return -1;
        if(Math.abs(rh-lh)>1) return -1;

        return 1+Math.max(lh,rh);
	}
	
	public static int maxDepth(Node root)
	{
	    if(root == null) return 0;
	    
	    int left = maxDepth(root.left);
	    int right = maxDepth(root.right);
	    
	    return 1+Math.max(left,right);
	}
	public static void insert (Node root,int val)
	{
	    if(val<root.data)
	    {
	        if(root.left!=null)
	        {
	            insert(root.left,val);
	        }
	        else{
	            root.left = new Node(val);
	        }
	    }
	    else{
	        if(root.right!=null)
	        {
	            insert(root.right,val);
	        }
	        else{
	            root.right = new Node(val);
	        }
	    }
	    
	}
	public static int levelOrder(Node root)
	{
		int count =0;
	    Queue <Node> q = new LinkedList<Node>();
	    q.offer(root);
	    while(!q.isEmpty())
	    {
	        int n = q.size();
	        for(int i=0;i<n;i++)
	        {
	            if(q.peek().left!=null) q.offer(q.peek().left);
	            if(q.peek().right!=null) q.offer(q.peek().right);
	            System.out.print(q.poll().data+" ");
	        }
			count++;
	    }
		return count;
	    
	}
    public static void print(Node temp)  
    {  
    if (temp == null)  
        return;  
      print(temp.left); 
    System.out.print(temp.data + " "); 
   
    print(temp.right);  
    }  
	
}
