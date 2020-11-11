// { Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    int r = Integer.parseInt(sc.next());
		    int c = Integer.parseInt(sc.next());
		    
		    int a[][] = new int[r][c];
		    for(int i=0;i<r;i++)
		    {
		        for(int j=0;j<c;j++)
		        {
		            a[i][j] = Integer.parseInt(sc.next());
		        }
		    }
		    
		    Solution T = new Solution();
		    System.out.println(T.rotOranges(a,r,c));
		    
		    t--;
		}
	}
}// } Driver Code Ends


//User function Template for Java

// a : given matrix
// R and C : number of rows and columns respectively

class Solution
{
    public int rotOranges(int grid[][],int m, int n)
    {
        // Write your code here
        
            Queue<int[]> q=new LinkedList<int[]>();
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                  
                    if(grid[i][j]==2)
                        q.add(new int[]{i,j});
                }
            }
            int ans=-1;
            //mark the end of current time
            q.add(null);
            int[] x={-1,1,0,0,};
            int[] y={0,0,-1,1};
            
            while(!q.isEmpty()){
                int[] tmp=q.poll();
                if(tmp==null){
                    ans++;
                    if(!q.isEmpty())
                        q.add(null);
                    
                }else{
                    //add all adj fresh organges in the queue
                    for(int k=0;k<4;k++){
                        int x_i = tmp[0]+x[k];
                        int y_j = tmp[1]+y[k];
                        if(x_i>=0 && x_i<m && y_j>=0 && y_j<n && grid[x_i][y_j]==1)
                        {
                            grid[x_i][y_j]=2;
                            q.add(new int[]{x_i,y_j});
                        }
                    }
                }
            }
        
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                
                if(grid[i][j]==1)
                    {
                        
                        return -1;
                       
                    }
                }
            }
            return ans;
            
        
    }
}
      
