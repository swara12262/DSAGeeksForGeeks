// { Driver Code Starts


import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] a, int n) {
        // code here
        long maxE=1, minE=1;
        long maxSoFar=1, flg=0;
        
        for(int i=0;i<n;i++){
            if(a[i]>0){
                maxE=maxE*a[i];
                minE=Math.min(minE*a[i], 1);
                flg=1;
            }
            else if(a[i]==0){
                maxE=minE=1;
            }
            else{
                long tmp=maxE;
                maxE= Math.max(minE*a[i], 1);
                minE=tmp*a[i];
            }
            if(maxSoFar<maxE)
                maxSoFar=maxE;
        }
         if (flg == 0 && maxSoFar == 1) 
            return 1; 
        return maxSoFar;
        
    }
}
