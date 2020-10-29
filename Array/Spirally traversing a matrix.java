/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    
		    int[][] a=new int[m][n];
		    for(int i=0;i<m;i++){
		        for(int j=0;j<n;j++)
		            a[i][j]=sc.nextInt();
		    }
		    print(a, 0, 0, m, n);
		}
	}
	static void print(int arr[][], int i, int j, int m,
                      int n)
    {
        // If i or j lies outside the matrix
        if (i >= m || j >= n) {
            return;
        }
 
        // Print First Row
        for (int p = i; p < n; p++) {
            System.out.print(arr[i][p] + " ");
        }
 
        // Print Last Column
        for (int p = i + 1; p < m; p++) {
            System.out.print(arr[p][n - 1] + " ");
        }
 
        // Print Last Row, if Last and
        // First Row are not same
        if ((m - 1) != i) {
            for (int p = n - 2; p >= j; p--) {
                System.out.print(arr[m - 1][p] + " ");
            }
        }
 
        // Print First Column, if Last and
        // First Column are not same
        if ((n - 1) != j) {
            for (int p = m - 2; p > i; p--) {
                System.out.print(arr[p][j] + " ");
            }
        }
        print(arr, i + 1, j + 1, m - 1, n - 1);
    }
}
