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
public class HeightofBinaryTree {
    Node root;
    public static void main(String[] args)
    {
        HeightofBinaryTree tree =new HeightofBinaryTree();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.left =new Node(6);
        System.out.print(tree.height(tree.root));
    }  
    public int height(Node root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }

}