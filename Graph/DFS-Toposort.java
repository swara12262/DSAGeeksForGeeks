// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            String s[] = read.readLine().trim().split("\\s+");
            int p = 0;
            for (int i = 1; i <= edg; i++) {
                int u = Integer.parseInt(s[p++]);
                int v = Integer.parseInt(s[p++]);
                list.get(u).add(v);
            }

            int[] res = new TopologicalSort().topoSort(list, nov);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/

/*
ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class TopologicalSort {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        
        boolean[] vis=new boolean[N];
        Stack<Integer> stk=new Stack<Integer>();
        int[] tsort=new int[N];
        for(int i=0;i<N;i++)
        {
            if(vis[i]==false)
            {
                dfs(adj,i,stk,vis);
            }
        }
        int i=0;
        while(!stk.isEmpty() && i<N)
        {
            tsort[i++]=stk.pop();
        }
        return tsort;
        
    }
    static void dfs(ArrayList<ArrayList<Integer>> adj, int u, 
    Stack<Integer> stk, boolean[] vis)
    {
        vis[u]=true;
        for(int tmp: adj.get(u))
        {
            if(vis[tmp]==false)
            {
                dfs(adj, tmp, stk, vis);
            }
        }
        stk.push(u);
    }
    
}
