// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

            // creating arraylist of arraylist
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }

            // adding elements to the arraylist of arraylist
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }

            System.out.println(new Islands().findIslands(list, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Islands {

    //N---number of rows
    //M---number of columns

    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
        ArrayList<ArrayList<Boolean>> vis=new ArrayList<ArrayList<Boolean>>(N);
        int count=0;
        for(int i=0;i<N;i++)
        {
            ArrayList<Boolean> tmp=new ArrayList<Boolean>();
            vis.add(i,tmp);
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                vis.get(i).add(j, false);
            }
        }

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(vis.get(i).get(j)==false && list.get(i).get(j)==1)
                {
                    dfs(list, i, j, vis, N, M);
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isSafe(ArrayList<ArrayList<Integer>> list, int row, int col,
                          ArrayList<ArrayList<Boolean>> vis, int ROW,
                          int COL) { // Check boundary conditions for i and j.
                                     // Also check if node is not already
                                     // visited and is currently 1.
    return ((row>=0 ) && (row<ROW) && (col>=0) && (col<COL) && (vis.get(row).get(col)==false) && (list.get(row).get(col)==1));                                     
       
    }

    static void dfs(ArrayList<ArrayList<Integer>> list, int i, int j,
                    ArrayList<ArrayList<Boolean>> vis, int N, int M) {
            int[] row={-1, -1, -1, 0,0,1,1,1};
            int [] col={-1, 0, 1, -1,1,-1,0,1};
            vis.get(i).set(j, true);
            for(int k=0;k<8;k++)
            {
                if(isSafe(list, row[k]+i, col[k]+j, vis, N, M))
                    dfs(list, row[k]+i, col[k]+j, vis, N, M);
            }            
        }
    }

