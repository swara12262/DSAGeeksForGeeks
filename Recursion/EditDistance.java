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
        System.out.println(ED(as1, as2, m,n));

    }
    public static int ED(char[] s1, char[] s2, int m, int n)
    {
        if(m==0)return n;
        if(n==0) return m;
        if(s1[m-1]==s2[n-1])
            return ED(s1,s2,m-1,n-1);
        else
        {
            return 1+Math.min(ED(s1,s2,m,n-1), Math.min(ED(s1,s2,m-1,n), ED(s1,s2,m-1,n-1)));
        }

    }
    
}
