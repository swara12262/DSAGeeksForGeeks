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
public class FindLCAMethod2 {
    Node root;
    public static void main(String[] args)
    {
        FindLCAMethod2 tree = new FindLCAMethod2(); 
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
    Node findLCA(int n1,int n2)
	{
	    return lca(root, n1, n2);
    }
    Node lca(Node root, int n1, int n2)
    {
        //base condition
        if(root==null)
            return null;

        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if(root.data==n1 || root.data==n2)
            return root;
        
        //loook for keys in left and rightsubtrees    
        Node left_lca = lca(root.left, n1, n2);
        Node right_lca =lca(root.right, n1, n2);
        
        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if(left_lca!=null && right_lca!=null)
            return root;

         // Otherwise check if left subtree or right subtree is LCA       
         return (left_lca!=null)? left_lca:right_lca;
            
    }
	
}