/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int[] a=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=sc.nextInt();
		    int cnt0=0;
		    int cnt1=0;
		    int cnt2=0;
		    for(int i=0;i<n;i++){
		        if(a[i]==0)
		            cnt0++;
		        else if(a[i]==1)
		            cnt1++;
		        else 
		            cnt2++;
		    }
		    int i=0;
		    while(cnt0-->0)
		        System.out.print("0"+" ");
		    while(cnt1-->0)
		        System.out.print("1"+" ");
		    while(cnt2-->0)
		        System.out.print("2"+" ");
               
		        System.out.println();
		}
	}
}
