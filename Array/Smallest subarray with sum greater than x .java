/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    int n=sc.nextInt();
		    int x=sc.nextInt();
		    int[] a=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=sc.nextInt();
		    int ans=Integer.MAX_VALUE;
		    int minSum=Integer.MAX_VALUE;
		    for(int i=0;i<n;i++){
		        int sum=0;
		        for(int j=i;j<n;j++){
		            sum+=a[j];
		            if(sum>x){
		                      minSum=sum;
		                      ans=Math.min(ans, j-i+1);
		                      break;
		            }
		        }
		    }
		    System.out.println(ans);
		}
	}
}
