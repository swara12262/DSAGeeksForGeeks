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
public class RightViewBinaryTree {
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right  =new Node(3);
        root.left.left  = new Node(4);
        root.left.right  = new Node(5);
        root.right.left  = new Node(6);
        leftView(root);
    }
    static void leftView(Node root)
    {
        if (root == null) 
            return; 
              
        Queue<Node> que = new LinkedList<>(); 
        que.add(root); 
        while(!que.isEmpty())
        {
            int n = que.size();
            for( int i=0;i<n;i++)
            {
                Node tmp =que.poll();
                if(i==n-1)
                    System.out.print(tmp.data+" ");
                if(tmp.left!=null)
                    que.add(tmp.left);
                if(tmp.right!=null)
                    que.add(tmp.right);
            }
        }
    }   
}