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
		       int l=0, m=0, h=n-1;
		       int tmp=0;
		       while(m<=h){
		           switch (a[m]){
		               case 0:{
		                   //swap a[l] amd a[m]
		                  tmp=a[l];
		                   a[l]=a[m];
		                   a[m]=tmp;
		                   l++;m++;
		                   break;}
		              case 1:{
		                m++;
		                break;}
		              case 2:{
		                //swap a[l] and a[h]
		                tmp=a[m];
		                a[m]=a[h];
		                a[h]=tmp;
		                 h--;
		                break;}
		           }
		          
		       }
		        for(int i=0;i<n;i++)
		           System.out.print(a[i]+" ");
		           System.out.println("");
		}
	}
}
