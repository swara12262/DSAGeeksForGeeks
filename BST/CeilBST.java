import java.util.*;
public class CeilBST {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        CeilBST d = new CeilBST();
        String str=sc.nextLine();
        Node root= bst.buildBST(str);
        System.out.println("Inorder traversal of tree before deletion:");
        bst.inOrder(root);
       
        System.out.println();
        System.out.println("Enter a data to find floor in BST:");
        int key = sc.nextInt();
        System.out.println();
        System.out.println("Floor of given data : "+key +" :"+d.ceil(root,key));
    }
    public int ceil(Node root, int x)
    {
        if(root==null)
            return -1;
        int res = -1;
        while(root!=null)
        {
            if(root.data == x)
                return root.data;
            else if(root.data<x)
                root = root.right;
            else{
                res =root.data;
                root = root.left;
            }         

        }
        return res;
    }

    
}