import java.util.*;
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
        left=right=null;
    }

}
class BinaryTree{
    Node root;
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.Inorder();
    }
    public void Inorder()
    {
        Stack <Node> stk =new Stack<Node>();
        
        while(root!=null || !stk.isEmpty())
        {
            while(root!=null)
            {
               
                stk.push(root);
                root=root.left;
            }
            root= stk.pop();
            System.out.print(root.data+" ");
            root=root.right;

        }
    }
}