// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int a[], int n)  
	{  
	    int[] sum=new int[n];
	    for(int i=0;i<n;i++)
	        sum[i]=a[i];
	        
	   int res=Integer.MIN_VALUE;
	   for(int i=1;i<n;i++){
	       for(int j=0;j<i;j++){
	           if(a[i]>a[j] && sum[i]<sum[j]+a[i])
	           {
	               sum[i]=sum[j]+a[i];
	           }
	       }
	   }
	   for(int i=0;i<n;i++){
	       res=Math.max(res, sum[i]);
	   }
	   return res;
	}  
}
