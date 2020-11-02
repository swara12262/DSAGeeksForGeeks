// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	    int t=Integer.parseInt(br.readLine().trim());
	    while(t > 0)
	    {
	        int n= Integer.parseInt(br.readLine().trim());
	        String x = br.readLine().trim();
	        String string_list[] = x.split(" ",n);
	        
	        Solution T = new  Solution();
	        
	        List <List<String>> ans = T.Anagrams(string_list);
	        
	        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> l1, List<String> l2) {
                    String s1 =  l1.get(0);
                    String s2 = l2.get(0);
                    
                    return s1.compareTo(s2);
                }
            });
	        
	        for(int i=0;i<ans.size();i++)
	        {
	            for(int j=0;j<ans.get(i).size();j++)
	            {
	                System.out.print(ans.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }
	       
	       
            t--;
	    }
	}
    
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        
        // Your Code here
        HashMap<String, List<String>> map=new HashMap<String, List<String>>();
        
        List<List<String>> res=new ArrayList<List<String>>();
        for(String s: string_list){
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            String sorted  = new String(arr);
            List<String> list = map.getOrDefault( sorted, new ArrayList<String>());
            list.add(s);
            map.put(sorted, list);            
        }
        for(Map.Entry<String, List<String>> en: map.entrySet()){
            res.add(en.getValue());
        }
        return res;
    }
}
