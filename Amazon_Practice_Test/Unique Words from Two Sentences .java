// { Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String A = br.readLine();
                    String B = br.readLine();
                    Sol obj = new Sol();
                    ArrayList<String> res = obj.uniqueWords(A, B);
                    for(String i : res)
                        System.out.print(i + " ");
                    System.out.println();
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    ArrayList<String> uniqueWords(String A , String B)
        {
            ArrayList<String> res=new ArrayList<String>();
            TreeMap<String, Integer> count=new TreeMap<String, Integer>();
            
            for(String s: A.split(" "))
                count.put(s, count.getOrDefault(s, 0)+1);
            for(String s: B.split(" "))
                count.put(s, count.getOrDefault(s, 0)+1);    
            
            for(Map.Entry<String, Integer>  en: count.entrySet()){
                if(en.getValue()==1)
                    res.add(en.getKey());
            }    
            return res;
        }
}
