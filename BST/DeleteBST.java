import java.util.*;
public class DeleteBST {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        DeleteBST d = new DeleteBST();
        String str=sc.nextLine();
        Node root= bst.buildBST(str);
        System.out.println("Inorder traversal of tree before deletion:");
        bst.inOrder(root);
        System.out.println();
        System.out.println("Enter a data to delete in BST:");
        int key = sc.nextInt();
        root = d.deleteNode(root,key);
        System.out.println();
        System.out.println("Inorder traversal of tree after deletion:");
        bst.inOrder(root);
    }
    public Node deleteNode(Node root, int x)
    {
        if(root==null)
            return null;
        if(root.data>x)
            root.left = deleteNode(root.left,x);
        else if(root.data<x)
            root.right = deleteNode(root.right, x);
        else{
            //node if no child or single child
            if(root.left ==  null)
                return root.right;
            else if(root.right == null)
                return root.left;
            //node with two childs 
            //find inorder succesor
            root.data = inOrderSuccessor(root.right);
            root.right = deleteNode(root.right, root.data);

        }
        return root;
    }
    public int inOrderSuccessor(Node root)
    {
        int res = root.data;
        while(root.left!=null)
        {
            res = root.data;
            root  =root.left;
        }
        return res;
    }   

}