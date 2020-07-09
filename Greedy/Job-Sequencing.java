// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            int[] res = new solve().JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}// } Driver Code Ends



class MyComparator implements Comparator<Job>
{
    public int compare(Job o1, Job o2)
    {
        return o2.profit-o1.profit;
    }
    
}
class solve{
    // return an array of size 2 having the 0th element equal to the count
    // and 1st element equal to the maximum profit
    int[] JobScheduling(Job arr[], int n){
        Arrays.sort(arr, new MyComparator());
        int out[] = new int[2];
        int maxDeadline=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(maxDeadline<arr[i].deadline)
                maxDeadline = arr[i].deadline;
        }
        int[] job = new int[maxDeadline];
        
        for(int i=0;i<n;i++)
        {
            int slot = arr[i].deadline;
           // System.out.println(arr[i].profit);
            for(int j=slot-1; j>=0;j--)
            {
                if(job[j]==0)
                {
                    //System.out.println(job[j]+"-"+j+"out[1]"+out[1]+"-"+arr[i].profit);
                    job[j]=arr[i].deadline;
                    out[0]++;
                    out[1]=out[1]+arr[i].profit;
                    break;
                }
            }
        }
        return out;
    }
}
