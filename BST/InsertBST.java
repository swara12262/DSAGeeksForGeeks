import java.util.*;

public class InsertBST {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        InsertBST inBst = new InsertBST();
        String str=sc.nextLine();
        Node root= bst.buildBST(str);
        System.out.println("Inorder traversal of tree:");
        bst.inOrder(root);
        System.out.println();
       /* System.out.println("Enter node to insert in BST:");
        int n =sc.nextInt();
        root = inBst.insertBSTRecursive(root, n);
        System.out.println("Inorder traversal of tree after insertion recursive:");
        bst.inOrder(root);*/

        System.out.println("Enter node to insert in BST:");
        int n =sc.nextInt();
        inBst.insertBSTIterative(root, n);
        System.out.println("Inorder traversal of tree after insertion iterative:");
        bst.inOrder(root);

    }
    public Node insertBSTRecursive(Node root, int data)
    {
        if(root==null )
            return new Node(data);
        if(root.data>data)
            root.left = insertBSTRecursive(root.left, data);
        if(root.data<data)
            root.right = insertBSTRecursive(root.right, data);
        else if(root.data==data)
            return root;
        return root;
    }
    public Node insertBSTIterative(Node root, int data)
    {
        Node tmp =new Node(data);
        Node parent=root;
        Node cur=root;
        while(cur!=null)
        {
            parent =cur;
            if(cur.data>data)
                cur=cur.left;
            else if(cur.data<data)
                cur=cur.right;
            else
                break;
        }
        if(parent==null)
            parent=tmp;
        if(parent.data==data)
            return root;
        if(parent.data>data)
            parent.left=tmp;
        else
            parent.right=tmp;
        return parent;
    }

    
}