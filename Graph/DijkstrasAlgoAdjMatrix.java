public class DijkstrasAlgoAdjMatrix {
    public static int V=9;
    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        DijkstrasAlgoAdjMatrix d=new DijkstrasAlgoAdjMatrix();
        d.shortestPath(graph);    
    }
    public void shortestPath(int[][] graph)
    {
        boolean[] sptSet=new boolean[V];
        int[] key=new int[V];
        for(int i=0;i<V;i++)
        {
            key[i]=Integer.MAX_VALUE;
        }
        key[0]=0;

        for(int i=0;i<V;i++)
        {
            int u=minIndex(key, sptSet);
            sptSet[u]=true;
            for(int v=0;v<V;v++)
            {
                if(sptSet[v]==false && graph[u][v]!=0  && key[v]> key[u]+graph[u][v])
                {
                    key[v]=key[u]+graph[u][v];
                }
            }
        }
        System.out.println("Shorted distance of all vertices from source vertex 0:");
        for(int i=0;i<V;i++)
        {
            System.out.println(i+"---"+key[i]);
        }
    }
    public int minIndex(int[] key, boolean[] sptSet)
    {
        int min_index=0, min=Integer.MAX_VALUE;
        for(int i=0;i<V;i++)
        {
            if(min>key[i] && sptSet[i]==false)
            {
                min=key[i];min_index=i;
            }
        }
        return min_index;
    }
}
