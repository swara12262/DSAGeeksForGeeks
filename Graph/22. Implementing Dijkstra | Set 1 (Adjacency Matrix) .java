// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    static void printSolution(int dist[], int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print(dist[i] + " ");
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        
        while(t > 0)
        {
            int V = Integer.parseInt(sc.next());;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(V);
            for(int i = 0;i < V; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>(V);
                list.add(i, temp);
            }
            
            for(int i = 0; i < V; i++)
            {
                ArrayList<Integer> temp = list.get(i);
                for(int j = 0; j < V; j++)
                {
                    temp.add(Integer.parseInt(sc.next()));
                }
                list.add(temp);
            }
            int s = Integer.parseInt(sc.next());;
            Solution T = new Solution();
            int[] res = T.dijkstra(list, s, V);
            printSolution (res, V);
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

/*
*   g: vector of vectors which represents the graph
*   src: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution
{
    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int v)
    {
           int[] dist=new int[v];
           boolean[] sptset= new boolean[v];
           for(int i=0;i<v;i++){
               dist[i]=Integer.MAX_VALUE;
           }
           //from source we will calculate distance to all other verties;
           dist[src] = 0; 
           
           for(int v1=0;v1<v;v1++){
               //caluate min value index which is not inclued in sptset and has min disatnec
               //from source vertes
               int u=minValueIndex(sptset, dist);
               //include u to sptset
               sptset[u]=true;
               //for all vertce adj to u
               for(int i=0;i<v;i++){
                   if(g.get(u).get(i)!=0 && sptset[i]==false
                   &&dist[u]!=Integer.MAX_VALUE &&  dist[i]>g.get(u).get(i)+dist[u])
                   {
                       dist[i]=g.get(u).get(i)+dist[u];
                   }
               }
           }
           return dist;
    }
    public static int minValueIndex(boolean[]  sptset, int[] dist){
        int minIndex=0;
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<dist.length;i++){
            if(!sptset[i] && min>=dist[i]){
                minIndex=i;
                min=dist[i];
            }
        }
        return minIndex;
    }
}

