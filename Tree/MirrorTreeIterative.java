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

public class MirrorTreeIterative {
    Node root;
    public static void main(String[] args) {
        MirrorTreeIterative tree = new MirrorTreeIterative(); 
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
        if(root==null)
            return;
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        while(!que.isEmpty())
        {
            Node cur =que.poll();

            
            Node tmp =cur.left;
            cur.left  =cur.right;
            cur.right = tmp;
            
            if(cur.left!=null)
                que.add(cur.left);
            if(cur.right!=null)
                que.add(cur.right);

        }
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