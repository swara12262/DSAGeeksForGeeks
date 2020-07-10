
import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s1= sc.next();
        String s2=sc.next();

        System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }
    public static int lcs(char[] s1, char[] s2, int m, int n)
    {
        if(m==0 || n==0)
            return 0;
        if(s1[m-1]==s2[n-1])
            return 1+lcs(s1, s2, m-1, n-1);
        else
        {
            return Math.max(lcs(s1, s2, m, n-1), 
                            lcs(s1, s2, m-1, n));
        }
    }
    
}
