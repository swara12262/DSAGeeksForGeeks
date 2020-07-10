import java.util.*;
public class LongestCommonSusequenceTabulation {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1= sc.next();
        String s2=sc.next();
        
        int m=s1.length();
        int n = s2.length();
        char[] as1 = s1.toCharArray();
        char[] as2 = s2.toCharArray();

        int[][] dp=new int[m+1][n+1];
        //fill first row
        for(int i=0;i<=n;i++)
            dp[0][i]=0;

        //fill first column
        for(int i=0;i<=m;i++)
            dp[i][0]=0;

        //fill remaining values
        for(int i=1;i<=m; i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(as1[i-1]==as2[j-1])
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    {
                        dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                    }
            }
        }
        System.out.println(dp[m][n]);

    }
    
}
