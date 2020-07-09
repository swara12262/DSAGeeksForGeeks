public class Sudoku {
    public static void main(String[] args)
    {
        int[][] grid = new int[][] { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
        };
        int n=grid.length;
        if(solve(grid, n))
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    System.out.print(grid[i][j]+" ");
                System.out.println();
            }
        }
        else
        {
            System.out.println(-1+"");
        }

    }
    public static boolean solve(int[][] grid, int n)
    {
        int row = -1; 
        int col = -1; 
        boolean isEmpty = true; 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
                if (grid[i][j] == 0) { 
                    row = i; 
                    col = j;
                   // System.out.println(row+"--"+col);
                    isEmpty = false; 
                    break; 
                } 
            } 
            if (!isEmpty) { 
                break; 
            } 
        } 
        if(isEmpty)return true;
        for(int k=1;k<=n;k++)
        {
            if(isSafe(grid, row, col, k,n))
            {
                grid[row][col]=k;
                if(solve(grid, n)==true)return true;
                grid[row][col]=0;
            }
        }
        return false;
    }
    public static  boolean isSafe(int[][] grid, int row, int col, int k,int n)
    {
        ///check if k is present in row or col
        for(int i=0;i<n;i++)
        {
            if(grid[row][i]==k || grid[i][col] ==k)
            {
                return false;
            }
        }
        //check if k is presnt in smal grid or not
        int sq=(int)Math.sqrt(n);
        int rs= row - row%sq;
        int cs= col - col%sq;

        for(int i=0;i<sq;i++)
        {
            for(int j=0;j<sq;j++)
            {
                if(grid[i+rs][j+cs]==k)
                    {
                        return false;
                    }
            }
        }

        return true;
    }
    
}
