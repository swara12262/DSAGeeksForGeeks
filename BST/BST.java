import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data)
    {
        this.data=data;
        this.left=this.right=null;
    }
}
public class BST {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        String str = sc.nextLine();
        Node root = bst.buildBST(str);
        System.out.println("Inorder traversasl of BST:");
        bst.inOrder(root);
        System.out.println();
        System.out.println("Preorder traversasl of BST:");
        bst.preOrder(root);
        System.out.println();
        System.out.println("Postorder traversasl of BST:");
        bst.postOrder(root);

    }
    public Node buildBST(String str)
    {
        if(str.length()==0 || str.equals('N'))
            return null;
        String[] s=str.split(" ");
        Node root=new Node(Integer.parseInt(s[0]));
        Queue<Node> que=new LinkedList<Node>();
        que.add(root);
       // System.out.println(root.data+"**"+s.length+"**"+str);
        int i=1;
        while(!que.isEmpty() && i<s.length)
        {
            Node cur=que.remove();
            String  curStr = s[i];
           // System.out.println(curStr);
            if(!curStr.equals("N"))
            {
                cur.left= new Node(Integer.parseInt(curStr));
                que.add(cur.left);
            }
            i++;
            if(i>=s.length)
                break;
            curStr = s[i];
            if(!curStr.equals("N"))
            {
                cur.right= new Node(Integer.parseInt(curStr));
                que.add(cur.right);
            }
            i++;
        }
        return root; 
    }
    public void inOrder(Node root)
    {
        if(root==null)return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public void preOrder(Node root)
    {
        if(root==null)return;
        System.out.print(root.data+" ");
        inOrder(root.left);
        inOrder(root.right);
    }
    public void postOrder(Node root)
    {
        if(root==null)return;
        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.data+" ");
    }
    
}