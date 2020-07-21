public class UnionbyRank {
    int parent[];
    int rank[];
    public static void main(String[] args)
    {
        UnionbyRank ur=new UnionbyRank();
        ur.parent=new int[5];
        ur.rank=new int[5];
        for(int i=0;i<5;i++)
            ur.parent[i]=i;

        ur.makeFriends(0,1);
        ur.makeFriends(1,3);

        if(ur.areFriends(0,4))
            System.out.println("Friends");
        else
            System.out.println(" Not Friends");
    }
    //return representative of x's set
    public int find(int x)
    {
        if(x==parent[x])
            return x;
        parent[x]= find(parent[x]);//optimisation in rank
        return parent[x];
    }
    //check if two ppl are friends
    public boolean areFriends(int x, int y)
    {
        return find(x)==find(y);
    }
    public void makeFriends(int x, int y)
    {
        union(x, y);
    }   
    public void union(int x, int y)
    {
        int x_z=find(x);
        int y_z=find(y);
        
        if(x_z==y_z)
        {
            System.out.println("Already friends");return;
        }
        if(rank[x_z]>rank[y_z])
            parent[y_z]=x_z;
        else if(rank[y_z]>rank[x_z])
            parent[x_z]=y_z;
        else
            {
                parent[y_z]=x_z;
                rank[x_z]++;
            }

    }
    
}