import java.util.*;
class Kanpsack {
    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = val.length;

        System.out.println(kanpsack(val,wt, W, n));
        
    }
    public static int kanpsack(int[] val, int[] wt, int W, int n)
    {
        if(W==0 || n==0) return 0;
        //do not inclue element if wt is greater than capacity
        if(wt[n-1]>W)
            return kanpsack(val, wt, W, n-1);
        else
        {
            return Math.max(val[n-1]+kanpsack(val, wt, W-wt[n-1], n-1),
            kanpsack(val, wt, W, n-1));
        }
    }
    
}
