import java.util.*;

import jdk.nashorn.api.tree.ParenthesizedTree;

class Edge implements Comparable<Edge>
{
    int src;
    int dst;
    int w;
    Edge(int src, int dst, int w)
    {
        this.src=src;
        this.dst=dst;
        this.w=w;
    }
    public int compareTo(Edge e)
    {
        return this.w-e.w;
    }
}
public class KruskalsAlgorithm {
    public static void main(String[] aStrings)
    {
        Edge[] e=new Edge[7];
        for(int i=0;i<7;i++)
            e[i]=new Edge(0, 0, 0);
        e[0].src=1;
        e[0].dst=3;
        e[0].w=3;

        e[1].src=0;
        e[1].dst=1;
        e[1].w=10;

        e[2].src=2;
        e[2].dst=4;
        e[2].w=12;

        e[3].src=0;
        e[3].dst=2;
        e[3].w=8;

        e[4].src=3;
        e[4].dst=4;
        e[4].w=15;

        e[5].src=2;
        e[5].dst=3;
        e[5].w=4;

        e[6].src=1;
        e[6].dst=2;
        e[6].w=5;

        Arrays.sort(e);
        int res=0;
        UnionbyRank u=new UnionbyRank();
        
        u.parent=new int[7];
        u.rank=new int[7];
        
        for(int i=0;i<7;i++)
            u.parent[i]=i;

        //minumum spanning tree should consist v-1 edges with no cycles    
        for(int i=0,s=0;s<6 &&i<7; i++)
        {
            int x=u.find(e[i].src);
            int y= u.find(e[i].dst);

            //otherwise adding edge will cause cycle for same representative or parent
            if(x!=y)
            {
                u.union(x, y);
                res+=e[i].w;
                s++;
            }
        }
        System.out.println(res);    
    }
}
