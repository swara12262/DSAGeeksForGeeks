import java.util.*;
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data=data;
        left=right= null;
    }

}
public class FindLCAMethod1 {
    Node root;
    public static void main(String[] args)
    {
        FindLCAMethod1 tree = new FindLCAMethod1(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
  
        System.out.println("LCA(4, 5): " + tree.findLCA(4,5).data); 
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6).data); 
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4).data); 
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4).data); 
    }
    Node findLCA( int n1,int n2)
	{
	    ArrayList<Integer> l1= new ArrayList<Integer>();
	    ArrayList<Integer> l2= new ArrayList<Integer>();
	    int i=0;
	    if(findPath(root, n1,l1) && findPath(root, n2,l2))
	    {
	       /* for(int i: l1)
	            System.out.print(i+" ");
	       System.out.println();
	       for(int i: l2)
	            System.out.print(i+" ");  
	            System.out.println();*/
            for(  i=0;i<l1.size()-1 && i<l2.size()-1;i++)
            {
                if(l1.get(i+1)!=l2.get(i+1))
                    {
                        break;
                    }
            }
	    }
	    return new Node(l1.get(i));
	}
	boolean findPath(Node root, int n, ArrayList<Integer> l)
	{
	    if(root==null)
	        return false;
	    l.add(root.data);
	    if(root.data==n)
	        return true;
	   if(findPath(root.left, n, l) || findPath(root.right, n, l))
	        return true;
	   l.remove(l.size()-1);
	   return false;
	}
}