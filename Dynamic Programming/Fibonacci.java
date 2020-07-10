import java.util.*;
public class Fibonacci {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fib(n));
    }
    public static int fib(int n)
    {
        int[] f=new int[n+1];
        f[0]=0;
        f[1]=1;
        for(int i=2;i<=n;i++)
        {
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }

}