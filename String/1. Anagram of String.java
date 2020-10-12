// { Driver Code Starts
//saksham raj seth
import java.util.*;
class Anagrams{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			GfG g=new GfG();
			System.out.println(g.remAnagrams(s,s1));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int remAnagrams(String s1,String s2)
    {
        int res=0;
        if(s1.equals(s2))return res;
        int[] cnt1=new int[26];
        int[] cnt2=new int[26];
        
        for(int i=0;i<s1.length();i++)
            cnt1[s1.charAt(i)-'a']++;
        for(int i=0;i<s2.length();i++)
            cnt2[s2.charAt(i)-'a']++;
            
        for(int i=0;i<26;i++)
            res+=Math.abs(cnt1[i]-cnt2[i]);
            
        return res;            
        
    }
}
