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
		
		int dia[] = new int[1];
		findDiametre(root,dia);
        System.out.print("\n\nDiametre of the tree is "+ dia[0]);
        
        //Boundary traversal of trees
        System.out.print("\n\nBoundary traversal of trees : ");
        ArrayList<Integer> boundary = new ArrayList<>();
        boundary.add(root.data);
        addLeft(root,boundary);
        addLeaf(root,boundary);
        addRight(root,boundary);
        for(int i=0;i<boundary.size();i++)
        {
            System.out.print(boundary.get(i)+" ");
        }
        //Right view of a binary tree
        System.out.print("\n\nRight view of a binary tree : ");
        ArrayList<Integer> rView = new ArrayList<>();
        rightView(root,0,rView);
        for(int i=0;i<rView.size();i++)
        {
            System.out.print(rView.get(i)+" ");
        }
	}
	public static void rightView(Node root,int level,ArrayList<Integer> ans)
	{
	    if(root==null) return;
	    
	    if(ans.size()==level) ans.add(root.data);
	    
	    rightView(root.right,level+1,ans);
	    rightView(root.left,level+1,ans);
	    
	}
	public static void addLeft(Node root,ArrayList<Integer> arr)
	{
	    Node curr = root.left;
	    while(curr!=null)
	    {
	        if(!isLeaf(curr)) arr.add(curr.data);
	        if(curr.left!=null) curr = curr.left;
	        else curr = curr.right;
	    }
	}
	public static void addLeaf(Node root,ArrayList<Integer> arr){
	    if(isLeaf(root)){
	        arr.add(root.data);
	        return;
	    }
	    if(root.left!=null) addLeaf(root.left,arr);
	    if(root.right!=null) addLeaf(root.right,arr);
	}
	public static void addRight(Node root,ArrayList<Integer> arr)
	{
	    ArrayList<Integer> temp = new ArrayList<>();
	    Node curr = root.right;
	    while(curr!=null)
	    {
	        if(!isLeaf(curr)) temp.add(curr.data);
	        if(curr.right!=null) curr = curr.right;
	        else curr = curr.left;
	    }
	    for(int i=temp.size()-1;i>=0;i--)
	    {
	        arr.add(temp.get(i));
	    }
	}
	public static boolean isLeaf(Node root)
	{
	    if(root.left==null && root.right==null) return true;
	    return false;
	}
	public static void findDiametre(Node root,int []dia)
	{
	    if(root==null) return;
	    
	    int lh = maxDepth(root.left);
	    int rh = maxDepth(root.right);
	    
	    dia[0] = Math.max(dia[0],lh+rh);
	    
	    findDiametre(root.left,dia);
	    findDiametre(root.right,dia);
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
