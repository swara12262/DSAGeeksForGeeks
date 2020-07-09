// { Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Driverclass
{
    public static void main (String[] args) throws IOException  
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    System.out.println(new Activity().activitySelection(start, end, n));
		}
    }
}

// } Driver Code Ends

class Act implements Comparable
{
    int start;
    int end;
    Act(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
    public int compareTo(Object a)
    {
        Act a1=(Act)a;
        return this.end - a1.end;
    }
}
class Activity
{
    static int activitySelection(int start[], int end[], int N)
    {
        int res=1;
        int prev=0;
        Act[] act=new Act[N];
        for(int i=0;i<N;i++)
        {
            act[i]=new Act(start[i], end[i]);
        }
        Arrays.sort(act);
       // for(int i=0;i<N;i++)
         //   System.out.println(act[i].end+"");
            
        
        for( int cur= 1; cur<N;cur++)
        {
            if(act[cur].start>=act[prev].end)
            {
                res++;
                prev=cur;
            }
        }
        return res;
    }
}
