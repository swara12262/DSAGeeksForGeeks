public class SubsetSum {
    public static void main(String[] args)
    {
        int set[] = { 3, 34, 4, 12, 5, 2 }; 
        int sum = 9;

        int n=set.length;
        System.out.println("No of possible subsets with given sum is: "+subSetSum(set, n, sum));
    }
    public static int subSetSum(int[] a, int n, int sum)
    {
        if(n==0)
        return sum==0?1:0;
        return subSetSum(a, n-1, sum)+subSetSum(a, n-1, sum-a[n-1]);
    }
    
}
