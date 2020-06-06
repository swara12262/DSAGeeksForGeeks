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
public class LevelOrderTraversalLinebyLine {
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right  =new Node(3);
        root.left.left  = new Node(4);
        root.left.right  = new Node(5);
        root.right.left  = new Node(6);
        levelOrderTraversal(root);


    }
    public static void levelOrderTraversal(Node root)
    {
        Queue<Node> que=new LinkedList<Node>();
        que.add(root);
        
        while(true)
        {
            int cnt = que.size();
            if(cnt==0)
                break;
            while(cnt-->0)
            {
               Node tmp = que.poll();
                System.out.print(tmp.data+" ");
                if(tmp.left!=null)
                    que.add(tmp.left);
                if(tmp.right!=null)
                    que.add(tmp.right); 
            }
            System.out.print("$"+" ");    
          }
    }
}