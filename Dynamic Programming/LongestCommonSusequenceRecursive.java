import java.util.*;

public class import java.util.*;

public class LongestCommonSusequenceRecursive {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1= sc.next();
        String s2=sc.next();
        int m=s1.length();
        int n = s2.length();
        int[][] memo=new int[m+1][n+1];
        for (int[] row : memo) { 
            Arrays.fill(row, -1); 
        } 
        System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), m, n, memo));
    }
    public static int lcs(char[] s1, char[] s2, int m, int n, int[][] memo)
    {
        if(memo[m][n]!=-1)
            return memo[m][n];
        else{
            if(m==0 || n==0)
            memo[m][n] = 0;
        else if(s1[m-1]==s2[n-1])
            memo[m][n]= 1+lcs(s1, s2, m-1, n-1,memo);
        else
        {
            memo[m][n]= Math.max(lcs(s1, s2, m, n-1, memo), 
                            lcs(s1, s2, m-1,n, memo));
        }

        }
        return memo[m][n];
        
    }
    
} {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1= sc.next();
        String s2=sc.next();
        int m=s1.length();
        int n = s2.length();
        int[][] memo=new int[m+1][n+1];
        for (int[] row : memo) { 
            Arrays.fill(row, -1); 
        } 
        System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), m, n, memo));
    }
    public static int lcs(char[] s1, char[] s2, int m, int n, int[][] memo)
    {
        if(memo[m][n]!=-1)
            return memo[m][n];
        else{
            if(m==0 || n==0)
            memo[m][n] = 0;
        else if(s1[m-1]==s2[n-1])
            memo[m][n]= 1+lcs(s1, s2, m-1, n-1,memo);
        else
        {
            memo[m][n]= Math.max(lcs(s1, s2, m, n-1, memo), 
                            lcs(s1, s2, m-1,n, memo));
        }

        }
        return memo[m][n];
        
    }
    
}
