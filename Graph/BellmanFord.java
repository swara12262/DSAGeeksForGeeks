public class BellmanFord {
    public static int V = 5; // Number of vertices in graph 
    public static int E = 8; // Number of edges in graph 
    public static void main(String[] args)
    {
       
    // Every edge has three values (u, v, w) where 
    // the edge is from vertex u to v. And weight 
    // of the edge is w. 
        int graph[][] = { { 0, 1, -1 }, { 0, 2, 4 }, 
                    { 1, 2, 3 }, { 1, 3, 2 },  
                    { 1, 4, 2 }, { 3, 2, 5 },  
                    { 3, 1, 1 }, { 4, 3, -3 } };
                    BellmanFord b=new BellmanFord();
        b.calculateShortestPath(graph);
    }
    public void calculateShortestPath(int[][] graph)
    {
        int[] dist=new int[V];
        dist[0]=0;
        for(int i=1;i<V;i++)
            dist[i]=Integer.MAX_VALUE;
        for(int i=0;i<V-1;i++)
        {
            for(int e=0;e<E;e++)
            {
                if(dist[graph[e][0]]+graph[e][2]< dist[graph[e][1]])
                {
                    dist[graph[e][1]]= dist[graph[e][0]]+graph[e][2];
                }
            }
        }
        //check for negavtive edge
        for (int i = 0; i < E; i++)  
    { 
        int x = graph[i][0]; 
        int y = graph[i][1]; 
        int weight = graph[i][2]; 
        if (dist[x] != Integer.MAX_VALUE && 
                dist[x] + weight < dist[y]) 
            System.out.println("Graph contains negative"
                    +" weight cycle"); 
    } 
        for(int i=0;i<V;i++)
        {
            System.out.println(i+ "-- "+ dist[i]);
        }

    }
    
}
