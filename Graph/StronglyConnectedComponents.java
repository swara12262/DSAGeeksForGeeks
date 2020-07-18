import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v)
    {
        V=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<Integer>();
            
    }
    public void addEdge(int v, int w)
    {
        adj[v].add(w);
    }
    public static void main(String[] args)
    {
        Graph g=new Graph(5);
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(3, 4); 

        g.printSCC();
    }
    public void printSCC()
    {
       Stack<Integer> stk=new Stack<Integer>();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==false)
                fillStack(i, stk, vis);
        }
        Graph gt=transPose();
        vis=new boolean[V];        
        while(!stk.isEmpty())
        {
            int u=stk.pop();
            if(vis[u]==false)
                gt.dfsUtil(u, vis);
            System.out.println();
        }
    }
    public void fillStack(int u, Stack<Integer> stk, boolean[] vis)
    {
        vis[u]=true;
            for(int v:adj[u])
            {
                if(vis[v]==false)
                fillStack(v, stk, vis);
            }
          //  System.out.println(u);
        stk.push(u);

    }
    public Graph transPose()
    {
        Graph gr=new Graph(V);
        for(int u=0;u<V;u++)
        {
          //  LinkedList list=adj[u];
            for(int v:adj[u])
                gr.addEdge(v, u);
        }
        return gr;
    }
    public void dfsUtil(int u, boolean[] vis)
    {
        vis[u]=true;
        System.out.print(u+" ");
            for(int v:adj[u])
            {
                if(vis[v]==false)
                dfsUtil(v, vis);
            }
          
        //stk.push(u);

    }
}
