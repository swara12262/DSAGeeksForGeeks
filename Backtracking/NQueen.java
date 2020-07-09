import java.util.*;
public class NQueen {
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int board[][]=new int[n][n];
        if(solve(board, 0, n))
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    System.out.print(board[i][j]+" ");
                System.out.println();
            }
        }
        else    
        System.out.println(-1+"");

    }    
    public static boolean solve(int[][] board, int col, int n)
    {
        if(col==n) return true;
        //for each row check if queen can be placed thr for a col
        for(int i=0;i<n;i++)
        {
            if(isSafe(board, i, col, n))
            {
                board[i][col]=1;
                if(solve(board, col+1, n)==true) return true;
                board[i][col]=0;
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] board, int row, int col, int n)
    {
        //to check if other queen is present in same row
        for(int i=0;i<col;i++)
        {
            if(board[row][i]==1)
                return false;
        }
        ///upper diagonal
        for(int i=row, j=col; i>=0 && j>=0;i--,j--)
        {
            if(board[i][j]==1)
                return false;
        }
        for(int i=row, j=col; i<n && j>=0;i++,j--)
        {
            if(board[i][j]==1)
                return false;
        }
        return true;
    }
}
