public class EggDrop {
    public static void main(String args[]) 
    { 
        int n = 2, k = 10; 
        System.out.print("Minimum number of "
                         + "trials in worst case with "
                         + n + " eggs and " + k 
                         + " floors is " + eggDrop(n, k)); 
    } 
    public static int eggDrop(int e, int f)
    {
        if(f==0 || f==1) return f;
        if(e==1) return f;
        int res=Integer.MAX_VALUE;

        int i=1;
        //consider all dropping from 1st floor to f floor
        for( i=1;i<=f;i++)
            res=Math.min(res, 1+Math.max(eggDrop(e-1, i-1), eggDrop(e, f-i)));
            return res;
    }

    
}
