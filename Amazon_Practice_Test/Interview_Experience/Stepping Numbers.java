import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0){
	     int n=sc.nextInt();
	     int m=sc.nextInt();
	     int cnt=0;
	     for(int i=0;i<=9;i++){
	         cnt+=bfs(n,m, i);
	     }
	     System.out.println(cnt);
	    }
	 }
	 public static int bfs(int n, int m, int i){
	     Queue<Integer> q=new LinkedList<Integer>();
	     q.add(i);
	     int cnt=0;
	     while(!q.isEmpty()){
	         int num=q.poll();
	          if(num>=n && num<=m)cnt++;
	         if(num==0 ||   num>m)continue;
	        
	         int lastDigit= num%10;
	         //for each last digit calulate adj numbers
	         int adj1 = num*10+lastDigit-1;
	         int adj2 = num*10+lastDigit+1;
	         
	         if(lastDigit==0){
	             q.add(adj2);
	         }
	         else if(lastDigit==9)
	            q.add(adj1);
	       else{
                 q.add(adj1);
                  q.add(adj2);
	       }
	     }
	     return cnt;
	 }
}
