// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

  public class Driver_class {

    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int j = 0; j < V; j++) temp.add(0);
                graph.add(temp);
            }
            str = read.readLine().trim().split(" ");
            int k = 0;
            int i=0;
            while (i++<E) {
                int u = Integer.parseInt(str[k++]);
                int v = Integer.parseInt(str[k++]);
                int w = Integer.parseInt(str[k++]);
                u--;
                v--;
                graph.get(u).set(v, w);
                graph.get(v).set(u, w);
            }

            System.out.println(new MST().spanningTree(V, E, graph));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class MST {
    static int spanningTree(int v, int e, ArrayList<ArrayList<Integer>> graph) {
        
        // Add your code here
        //to keep track if cur vertex is added to mstset or not
        boolean[] mstSet = new boolean[v];
        int[] parent= new int[v];
        //to store the min key or wt for each vertex
        int[] key=new int[v];
        for(int i=0;i<v;i++){
            key[i]=Integer.MAX_VALUE;
        }
        //so that first vertex will be picked
        key[0]=0;
        parent[0]=-1;
        //for each vertex do below
        for(int i=0;i<v;i++){
            
            //find index of the key with min value and not included in mstset
            int u = minKey(mstSet, key);
            mstSet[u]=true;
            //for each adj of u update the key if dist from this u to key is less than already present
            for(int vertex=0; vertex<v; vertex++){
                if(graph.get(u).get(vertex)!= 0 &&graph.get(u).get(vertex)< key[vertex]
                && !mstSet[vertex] )
                {
                    parent[vertex]= u;
                    key[vertex]= graph.get(u).get(vertex);
                }
            }
            
        }
        int sum=0;
        for(int i=1;i<v;i++)
            {
                sum+=graph.get(i).get(parent[i]);
            }
        return sum;
    }
    static int minKey(boolean[] mstSet, int[] key){
        int min=Integer.MAX_VALUE;
        int minIndex=0;
        for(int i=0;i<key.length;i++){
            if(min>key[i] && mstSet[i]==false){
                minIndex=i;
                min=key[i];
            }
        }
        return minIndex;
    }
}
