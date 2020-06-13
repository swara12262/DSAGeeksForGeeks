import java.util.*;
class SearchBST {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        BST bst=new BST();
        SearchBST inBst = new SearchBST();
        String str=sc.nextLine();
        Node root= bst.buildBST(str);
        System.out.println("Inorder traversal of tree:");
        bst.inOrder(root);
        System.out.println();
        System.out.println("Enter a data to serach in BST:");
        int key = sc.nextInt();

        if(inBst.search(root,key))
            System.out.println("Key found");
        else
            System.out.println("Key not found");
    }
    public boolean search(Node root, int x)
    {
        if(root!=null){
	    if(root.data>x)
	        return search(root.left,x);
	    else if(root.data<x)
	        return search(root.right,x);
	    else
            return true;
        }
        return false;
    }
    
}