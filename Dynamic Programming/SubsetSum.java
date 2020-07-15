public class SubsetSum {
    public static void main(String[] args)
    {
        int a[] = { 3, 34, 4, 12, 5, 2 }; 
        int sum = 9;

        int n=a.length;
        int dp[][]=new int[n+1][sum+1];
        
        
        for(int i=0;i<=n;i++)
            dp[i][0]=1;
        for(int i=1;i<=sum;i++)
            dp[0][i]=0;
            
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(j<a[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-a[i-1]];
            }
        }

        System.out.println("No of possible subsets with given sum is: "+dp[n][sum]);
    }
}
