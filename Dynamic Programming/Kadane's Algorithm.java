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
		  
		    int maxEndingHr=0, maxSofar=Integer.MIN_VALUE;
		    int start=0,  end =0, s=0;
		    
		    for(int i=0;i<n;i++){
		        maxEndingHr+=a[i];
		        if(maxSofar<maxEndingHr){
		            maxSofar = maxEndingHr;
		            start=s;
		            end=i;
		        }
		        if(maxEndingHr<0)
		        {
		            maxEndingHr = 0;
		            s=i+1;
		        }
		    }
		    System.out.println(maxSofar);
		    
		}
	}
}
