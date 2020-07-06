// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

/*
ArrayList<ArrayList<Integer>> adj: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    //using dfs
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean[] rec=new boolean[V];
        boolean[] vis=new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(vis[i]==false)
                if(dfs(adj, vis, rec, i)==true)
                    return true;
        }
        return false;

    }
    static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] rec,
    int v)
    {
        vis[v]=true;rec[v]=true;
        for(int u: adj.get(v))
        {
            if(vis[u]==false && dfs(adj, vis, rec, u)==true)
                return true;
            else if(rec[u]==true)
                return true;
        }
        rec[v]=false;
        return false;
        
    }
}
