// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t>0)
		{
		    String s1=ob.next();
		    String s2=ob.next();
		    Solution ab=new Solution();
		    if(ab.valid(s1,s2))
		    System.out.println("Yes");
		    else
		    System.out.println("No");
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[] pcnt;
    int[] scnt;
    boolean valid(String p,String s)
    {
        //code here
        //take a window of length p and slide over s to keep the cnt of chars of window and match 
        //it with count of chars of p
        int plen=p.length();
        int slen=s.length();
        
         pcnt=new int[26];
        
        for(int i=0;i<p.length();i++)
            pcnt[p.charAt(i)-'a']++;
            
        scnt=new int[26];
        if(slen<plen)return false;
        
        for(int i=0;i<plen;i++){
                scnt[s.charAt(i)-'a']++;
            }    
        for(int i=0;i<slen-plen+1;i++){
            int  j=0;
            for(j=0;j<26;j++){
                if(scnt[j]!=pcnt[j]){
                    break;    
                }
            }
            if(j==26)return true;
            scnt[s.charAt(i)-'a']--;
            if(i+plen<slen)
                scnt[s.charAt(i+plen)-'a']++;
        }
        return false;
    }
    
}
