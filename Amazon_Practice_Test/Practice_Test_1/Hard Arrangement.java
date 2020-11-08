class Sol
{
    public class MyArrayListComparator implements java.util.Comparator<ArrayList>
    {
        public int compare(ArrayList al1, ArrayList al2)
        {
            int d1 = (int)al1.get(1) - (int)al2.get(1);
            int d2 = (int)al2.get(0) - (int)al1.get(0);
            if((int)al1.get(0) == (int)al2.get(0))
                return d1;
            else
                return d2;
    
        }
    }    
      
    ArrayList<Integer>arrange(ArrayList<Integer> A, ArrayList<Integer> B, int n)
    {
        ArrayList<ArrayList<Integer> > people = new ArrayList<ArrayList<Integer> >(n);
        for(int i=0; i<n; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            people.add(temp);
        }
        
        for(int i=0; i<n; i++)
        {
            people.get(i).add(A.get(i)); 
            people.get(i).add(B.get(i)); 
        }
        
        Collections.sort(people, new MyArrayListComparator());
            
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i =0; i<n; i++)
           ans.add(people.get(i).get(1) , people.get(i).get(0));
        
        return ans;   
    }
}
