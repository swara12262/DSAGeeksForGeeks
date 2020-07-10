import java.util.*;
public class CoinChangeProblem {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();

        }
        int sum=sc.nextInt();
        int[][] dp=new int[sum+1][n+1];
        for(int i=0;i<=n;i++)
            dp[0][i] = 1;
        for(int i=1;i<=sum;i++)
            dp[i][0]=0;
        for(int i=1;i<=sum;i++)
        {
            for(int j=1;j<=n;j++)
            {
                dp[i][j]=dp[i][j-1];
                if(i>=a[j-1])
                {
                    dp[i][j] +=dp[i-a[j-1]][j];
                }
            }
        }
        System.out.println(dp[sum][n]+"");

    }
    
}
