// { Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg  =sc.nextInt();
            for(int i = 0; i < nov; i++)
                list.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            
            ArrayList<Integer> res = new Traversal().dfs(list, nov);
            for (int i = 0; i < res.size (); i++) 
                System.out.print (res.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


/*
g : adjacency list of graph
N : number of vertices

return a list containing the DFS traversal of the given graph
*/

class Traversal
{
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       boolean[] vis=new boolean[N];
       Stack<Integer> stk=new Stack<Integer>();
       ArrayList<Integer> out =new ArrayList<Integer>();
        dfsRec(0, out, g, vis);
        return out;
    }
    public static void dfsRec(int u, ArrayList<Integer> out, ArrayList<ArrayList<Integer>> g, boolean[] vis)
    {
            out.add(u);
            vis[u]=true;
            for(int v: g.get(u))
            {
                if(vis[v]==false)
                {
                    vis[v]=true;
                    dfsRec(v,out, g, vis );
                }
            }
    }
}
