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
public class LevelOrderTraversalSpiralForm {
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right  =new Node(3);
        root.left.left  = new Node(4);
        root.left.right  = new Node(5);
        root.right.left  = new Node(6);
        levelOrderTraversalSpiral(root);


    }
    public static void levelOrderTraversalSpiral(Node root)
    {
        Stack<Node> s1 =new Stack<Node>();
        Stack<Node> s2 =new Stack<Node>();
        s1.add(root);
        while(true){
            if(s1.isEmpty() && s2.isEmpty())
                 break;
            while(!s1.isEmpty())
            {
                Node tmp = s1.pop();
                if(tmp==null)
                     break;
                System.out.print(tmp.data+" ");
                if(tmp.right!=null)
                     s2.push(tmp.right);
                 if(tmp.left!=null)
                     s2.push(tmp.left);    
            }
            while(!s2.isEmpty())
            {
                Node tmp  = s2.pop();
                if(tmp==null)
                     break;
                System.out.print(tmp.data+" ");
                if(tmp.left!=null)
                     s1.push(tmp.left);
                 if(tmp.right!=null)
                     s1.push(tmp.right);    
            }
            
        }
    }   
}