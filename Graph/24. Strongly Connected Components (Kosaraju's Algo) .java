// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            
            int vertices = Integer.parseInt(sc.next());
            int edges = Integer.parseInt(sc.next());
            
            for(int i =0; i < vertices; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edges; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 list.get(u).add(v);
            }
            
            Solution T = new Solution();
            System.out.println(T.kosaraju(list, vertices));
		}
    }
}
// } Driver Code Ends


//User function Template for Java

// adj : Adjacency list representing the graph
// N: No of vertices


//first start from vertex 0 and do dfs and add all recusrion in stack
//reverse graph
//pop items from stack and do dfs and print output

class Solution
{
    boolean[]  vis;
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int n)
    {
        // Write your code here
        Stack<Integer> stk=new Stack<Integer>();
        vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i])
                dfsTofillStk(i, adj, stk);
        }        
        adj = transpose(adj,n); 
        int ans=0;
        vis=new boolean[n];
        
        while(!stk.isEmpty())
        {
            int i=stk.pop();
            if(!vis[i]){
                dfs(i, adj);
                ans++;
            }
        }
        return ans;
    }
    public void dfs(int u, ArrayList<ArrayList<Integer>> adj){
        vis[u]=true;
        for(int v: adj.get(u))
        {
            if(vis[v]==false)
                dfs(v, adj);
        }
    }
    public void  dfsTofillStk(int u, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk){
        vis[u]=true;
        
        for(int v: adj.get(u)){
            if(!vis[v])
                dfsTofillStk(v, adj, stk);
        }
        stk.push(u);
    }
    public ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> adj, int n){
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
            res.add(new ArrayList<Integer>());
            
        for(int i=0;i<n;i++){
            for(int u: adj.get(i))
                res.get(u).add(i);
        }
        return res;
    }
}
