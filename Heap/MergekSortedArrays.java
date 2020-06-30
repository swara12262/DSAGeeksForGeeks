// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

/*Complete the function below*/
class Ele implements Comparable
{
    int val;
    int apos;
    int valpos;
    Ele(int val,int apos, int valpos)
    {
        this.val=val;
        this.apos =apos;
        this.valpos = valpos;
    }
    public int compareTo(Object e)
    {
        Ele e1=(Ele)e;
        if(this.val<=e1.val)
            return -1;
        else
            return 1;
    }
    
}
class Solution{
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        ArrayList<Integer> out=new ArrayList<Integer>();
        PriorityQueue que=new PriorityQueue<Ele>();
        int i=0;
        while(i<k)
        {
            que.add(new Ele(arrays[i][0],i,0));
            i++;
        }
        
        while(!que.isEmpty())
        {
            Ele tmp = (Ele)que.poll();
            out.add(tmp.val);
            if(tmp.valpos+1<arrays[tmp.apos].length)
            {
                que.add(new Ele(arrays[tmp.apos][tmp.valpos+1], tmp.apos, tmp.valpos+1));
            }
        }
        return out;
        
    }
}