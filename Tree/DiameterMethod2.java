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
class A
{
    int ans=Integer.MIN_VALUE;
}
public class DiameterMethod2 {
    Node root;
    public static void main(String[] args) {
        DiameterMethod2 tree = new DiameterMethod2(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        tree.diameter();
      //  System.out.println(tree.diameter());
    }
    void diameter()
    {
        A a  = new A();
       height(root,  a);
       System.out.println(a.ans);
    }
    int height(Node root, A a) {
        if(root==null)
            return 0;
        
        int lh =height(root.left, a);
        int rh =height(root.right, a);

        a.ans = Math.max(a.ans, lh+rh+1);
        return 1+Math.max(lh, rh);
    }
    

    


}