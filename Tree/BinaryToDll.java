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
public class BinaryToDll {
    Node root, prev;
    Node head;
    public static void main(String[] args) {
        BinaryToDll tree = new BinaryToDll(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(6);
        tree.head = tree.binarytoDll(tree.root);
        tree.printList(tree.head);

    }
    Node binarytoDll(Node root)
    {
        if(root==null)
            return null;
        binarytoDll(root.left);
        if(prev==null)
        {
            head=root;
        }
        else
        {
            root.left =prev;
            prev.right = root;

        }
        prev=root;
        binarytoDll(root.right);
        return head;
    }
    void printList(Node head)
    {
        Node cur=head;
        
        while(cur!=null)
        {
            System.out.print(cur.data+" ");
            cur=cur.right;
        }
    }

}