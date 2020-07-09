
public class RatInMaze {
    public static void main(String[] args)
    {
        int maze[][] = { { 1, 0, 0, 0 }, 
        { 1, 1, 0, 1 }, 
        { 0, 1, 0, 0 }, 
        { 1, 1, 1, 1 } };
        int n=maze.length;
        int[][] soln=new int[n][n];
        if(solveMaze(maze, n,soln,0,0))
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    System.out.print(soln[i][j]+" ");
                System.out.println();
            }
            
        }
        else
            System.out.println(-1+"");

        

    }
    public static boolean solveMaze(int[][] maze, int n, int[][] soln, int i, int j)
    {
        if(i==n-1 && j==n-1)return true;
        if(isSafe(maze, n, i, j))
        {
            soln[i][j]=1;
            if(solveMaze(maze, n, soln, i+1,j)==true)return true;
            else if(solveMaze(maze, n, soln, i,j+1)==true)return true;
            soln[i][j]=0;
            
        }
        return false;
    }   
    public static boolean isSafe(int[][] maze, int n , int i, int j)
    {
        return (i<n && j<n && maze[i][j]==1);
    }
}
