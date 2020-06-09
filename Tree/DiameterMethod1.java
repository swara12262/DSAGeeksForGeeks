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
public class DiameterMethod1 {
    Node root;
    public static void main(String[] args) {
        DiameterMethod1 tree = new DiameterMethod1(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        System.out.println(tree.diameter());
    }
    int diameter()
    {
       return  diameter(root);
    }
    int diameter(Node root) {
        if(root==null)
            return 0;
        int d1= height(root.left)+height(root.right)+1;
        return Math.max(d1, Math.max(diameter(root.left),diameter(root.right)));
        
    }
    int height(Node root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }

    


}