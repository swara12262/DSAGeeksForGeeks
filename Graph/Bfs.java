// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();

            for (int i = 0; i < nov; i++) list.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            ArrayList<Integer>res = new Traversal().bfs(list,nov);
            for (int i =0 ;i < res.size (); i++) 
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*  g[]: adj list of the graph
*  N : number of vertices
*/
class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        ArrayList<Integer> out=new ArrayList<Integer>();
        Queue<Integer> que=new LinkedList<Integer>();
        boolean[] v = new boolean[N];
        que.add(0);
        v[0]=true;
        while(!que.isEmpty())
        {
            int tmp = que.poll();
            out.add(tmp);
            for(int node:g.get(tmp))
            {
                if(v[node]==false)
                {
                    v[node]=true;
                    que.add(node);
                }
            }
        }
        return out;
    }
}
