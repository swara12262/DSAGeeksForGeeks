// { Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your codehere
          StringBuilder sb=new StringBuilder();
          for(int i=0;i<str.length();i++){
              sb.append(str.charAt(i));
              int cnt=1;
              while(i<str.length()-1 && str.charAt(i+1)==str.charAt(i)){
                  cnt++;i++;}
              sb.append(cnt);
          }
          return sb.toString();
	}
	
 }
