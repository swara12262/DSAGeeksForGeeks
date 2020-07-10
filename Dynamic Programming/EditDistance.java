import java.util.*;
public class EditDistance {
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
        
        //fill rows and columns
        for(int i=0;i<=m;i++)
            dp[0][i]=i;
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(as1[i-1]==as2[j-1])
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        System.out.println(dp[m][n]);
    }
    
}
