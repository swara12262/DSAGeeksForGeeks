// { Driver Code Starts
//Initial Template for Java

import java.util.*; 
import java.io.*;
import java.lang.*;

class DriverClass
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            
            GFG g = new GFG();
            g.rotate(arr);
            printMatrix (arr);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}// } Driver Code Ends


//User function Template for Java

class GFG
{
    //transpose and reverse cols
    static void rotate(int a[][]) 
    {
        int m=a.length;
        int n=a[0].length;
        // Code Here
        for(int i=0;i<m;i++){
            for(int j=0;j<i+1;j++){
                int tmp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=tmp;
            }
        }
        //reverse cols
        for(int i=0;i<n;i++){
            for(int j=0, k=n-1;j<k  ;j++,k--){
                int tmp=a[j][i];
                a[j][i]= a[k][i];
                a[k][i]=tmp;
            }
        }
        
    }
}
