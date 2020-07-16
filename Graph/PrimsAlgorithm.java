public class PrimsAlgorithm {
    private static final int V = 5;                                       
    public static void main(String[] args)
    {
        PrimsAlgorithm p =new PrimsAlgorithm();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
                                      { 2, 0, 3, 8, 5 }, 
                                      { 0, 3, 0, 0, 7 }, 
                                      { 6, 8, 0, 0, 9 }, 
                                      { 0, 5, 7, 9, 0 } };
        
        p.printMST(graph);                                      
    }
    public void printMST(int[][] graph)
    {
        int[] parent=new int[V];
        boolean[] mstSet=new boolean[V];
        int[] key=new int[V];

        parent[0]=-1;//root node
        key[0]=0;

        for(int i=1;i<V;i++)
         {
            mstSet[i] = false; 
            key[i]=Integer.MAX_VALUE;
         }   
        
        for(int i=0;i<V;i++)
        {
            int u=minKey(key, mstSet);
            mstSet[u]=true;
            for(int v=0;v<V;v++)
            {
                if(graph[u][v]!=0 && mstSet[v]==false && graph[u][v]<key[v])
                {
                    key[v]=graph[u][v];
                    parent[v]=u;
                }
            }

        }    
        for(int i=1;i<V;i++)
            System.out.println(parent[i]+"--"+i+" "+graph[i][parent[i]]);
    }
    public int minKey(int[] key, boolean[] mstSet)
    {
        int min=Integer.MAX_VALUE, min_index=-1;
        for(int i=0;i<V;i++)
        {
            //System.out.println(key[i]);
            if(min>key[i] && mstSet[i]==false)
                {
              //      System.out.println(key[i]);
                    min=key[i];
                    min_index=i;
                }
        }
        return min_index;
    }
    
}
