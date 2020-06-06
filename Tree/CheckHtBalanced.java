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
public class CheckHtBalanced {

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right  =new Node(3);
        root.left.left  = new Node(4);
        root.left.right  = new Node(5);
        root.right.left  = new Node(6);
        root.right.left.left  = new Node(6);
        root.right.left.left.left  = new Node(6);
        if(isBalanced(root))
            System.out.println("YEs");
        else
            System.out.println("NO");
    }
    static boolean  isBalanced(Node root)
    {
        if(root==null)
            return true;
        if(root!=null)
            return (Math.abs(height(root.left)-height(root.right))<=1 &&
        isBalanced(root.left) && isBalanced(root.right));
        return false;
	    
    }
    static int height(Node root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    
}