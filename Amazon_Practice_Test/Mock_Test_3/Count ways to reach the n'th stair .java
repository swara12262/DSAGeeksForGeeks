// { Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    int m = sc.nextInt();
		    
		    DynamicProgramming obj = new DynamicProgramming();
		    
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}// } Driver Code Ends


    // function to count ways to reach nth stair

class DynamicProgramming{
    
    // function to count ways to reach mth stair
    Long countWays(int n){
         if (n == 1) {
            return 1l;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i]=dp[i]%1000000007;
        }
        return dp[n];
    
        
    }
    
    
}
