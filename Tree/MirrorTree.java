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

public class MirrorTree {
    Node root;
    public static void main(String[] args) {
        MirrorTree tree = new MirrorTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        System.out.println("Inorder traversal of input tree: ");
        tree.inOrder(tree.root);
        tree.mirror(tree.root);
        System.out.println();
        System.out.println("Inorder traversal of mirror tree: ");
        tree.inOrder(tree.root);
        
    }
    void mirror(Node root)
    {
        root = mirrorTree(root);
    }
    Node mirrorTree(Node root)
    {
        if(root==null)
            return root;
        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);

        root.left  =right;
        root.right  =left;
        return root;
    }
    void  inOrder(Node root)
    {
        if(root!=null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }    
}