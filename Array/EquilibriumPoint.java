// { Driver Code Starts
import java.io.*;
import java.util.*;

class Equilibrium {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            EquilibriumPoint obj = new EquilibriumPoint();

            System.out.println(obj.equilibriumPoint(arr, n));
        }
    }
}// } Driver Code Ends


class EquilibriumPoint {

    // Function to find equilibrium point
    // a: input array
    // n: size of array
    public static int equilibriumPoint(long a[], int n) {
        if(n==1)
            return 1;
        long sum=0;
        for(int i=0;i<n;i++)
            sum+=a[i];
        long lsum=0;
        int i=0,j=1;
        while(j<n-1)
        {
            lsum+=a[i];
            if(lsum==sum-lsum-a[j])
                return j+1;
            i++;j++;
        }
        return -1;
    }
}
