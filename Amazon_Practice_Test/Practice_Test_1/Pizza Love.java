


// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;
class GFG
{
    public static void main(String args[])throws ArrayIndexOutOfBoundsException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t > 0)
                {
                    int n , ans , i;
                    n = sc.nextInt();
                    int[] arr = new int[n];
                    for(i=0;i<n;i++)
                        arr[i] = sc.nextInt();
                    pizza p = new pizza() ;   
                    ans = p.maxPizza(n,arr);  
                    System.out.println(ans);
                    t--;
                }
        }
}// } Driver Code Ends

+++++++++++++++++++++++++++++++++++++++++++++++
//User function Template for Java
class pizza
{
    int maxPizza(int n, int[] a)
        {
            int[] dp=new int[n];
            
            if(n==1)
                return a[0];
            if(n==2)
                return Math.max(a[0], a[1]);
            dp[0]=a[0];
            dp[1]=Math.max(a[0], a[1]);
            for(int i=2;i<n;i++){
                dp[i]=Math.max(dp[i-1], dp[i-2]+a[i]);
            }
            return dp[n-1];
            
        }
};
