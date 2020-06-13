import java.util.*;
public class FloorBST {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        FloorBST d = new FloorBST();
        String str=sc.nextLine();
        Node root= bst.buildBST(str);
        System.out.println("Inorder traversal of tree before deletion:");
        bst.inOrder(root);
       
        System.out.println();
        System.out.println("Enter a data to find floor in BST:");
        int key = sc.nextInt();
        System.out.println();
        System.out.println("Floor of given data : "+key +" :"+d.floor(root,key));
    }
    public int floor(Node root, int x)
    {
        if(root==null)
            return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        while(root!=null)
        {
            if(root.data == x)
                return root.data;
            else if(root.data>x)
                root = root.left;
            else{
                res =root.data;
                root = root.right;
            }         

        }
        return res;
    }

    
}