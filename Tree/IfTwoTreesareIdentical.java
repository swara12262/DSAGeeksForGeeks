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
class BinaryTree{
    Node root1, root2;
    public static void main(String[] args)
    {
        BinaryTree tree1 = new BinaryTree(); 
        tree1.root1 = new Node(1); 
        tree1.root1.left = new Node(2); 
        tree1.root1.right = new Node(3); 
        tree1.root1.left.left = new Node(4); 
        tree1.root1.left.right = new Node(5);
        BinaryTree tree2 = new BinaryTree(); 
        tree2.root2 = new Node(1); 
        tree2.root2.left = new Node(2); 
        tree2.root2.right = new Node(3); 
        tree2.root2.left.left = new Node(4); 
        tree2.root2.left.right = new Node(5);
        tree2.root2.left.right.left = new Node(5);
        if(isIndentical(tree1.root1, tree2.root2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    public static boolean isIndentical(Node root1, Node root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1!=null && root2!=null)
            return (root1.data==root2.data &&
            isIndentical(root1.left, root2.left)&&
            isIndentical(root1.right, root2.right));
        return false;
    }
}
