// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new solve().infixToPostfix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class solve{
	public static String infixToPostfix(String exp) {
		Stack<Character> stk=new Stack<Character>();
		String res=new String("");
		
		for(int i=0;i<exp.length();i++){
		    char ch=exp.charAt(i);
		    if(Character.isLetterOrDigit(ch))
		        res+=ch;
		    else if(ch=='(')
		        stk.push(ch);
		    else if(ch==')')
		    {
		        //pop until '(' is occurred
		           while(!stk.isEmpty() && stk.peek()!='(')
		                res+=stk.pop();
		          if(!stk.isEmpty())
		            stk.pop();
		    }
		    else{
		        //an operator is encontered then
		        
		        while(!stk.isEmpty() && prec(stk.peek())>=prec(ch))
		            res+=stk.pop();
		           stk.push(ch);
		    }
		    
		}
		while(!stk.isEmpty())
		            res+=stk.pop();
		return res;
		
	}
	static int prec(Character c){
    //^,*,/,+,-. 
 
    if(c == '^') 
        return 3; 
    else if(c == '*' || c == '/') 
        return 2; 
    else if(c == '+' || c == '-') 
        return 1; 
    else
        return -1; 
    
}
}
