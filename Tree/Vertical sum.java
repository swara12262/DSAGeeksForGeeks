// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}

// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class NewNode{
    Node node;
    int level;
    NewNode(Node node, int level){
        this.node=node;
        this.level=level;
    }
}
class Tree{
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        TreeMap<Integer, Integer> map=new TreeMap<Integer, Integer>();
        Queue<NewNode> q=new LinkedList<NewNode>();
        q.add(new NewNode(root, 0));
       // map.put(0, root.data);
        while(!q.isEmpty()){
            NewNode tmp=q.poll();
            int l=tmp.level;
            Node tmpnode=tmp.node;
           // System.out.println(tmpnode.data+" *");
            map.put(l, map.getOrDefault(l, 0)+tmpnode.data);
            
            if(tmpnode.left!=null)
                q.add(new NewNode(tmpnode.left, l-1));
            if(tmpnode.right!=null)
                q.add(new NewNode(tmpnode.right, l+1));
            
        }
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> en: map.entrySet()){
            res.add(en.getValue());
            //System.out.println(res);
        }
        return res;
    }
}
