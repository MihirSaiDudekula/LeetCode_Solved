// 1020. Number of Enclaves
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

// Example 1:


// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
// Example 2:


// Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
// Output: 0
// Explanation: All 1s are either on the boundary or can reach the boundary.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 500
// grid[i][j] is either 0 or 1.

class Solution {
    public int numEnclaves(int[][] grid) 
    {
        int m = grid.length;
        int n = grid[0].length;
        if(grid==null||m==0||n==0)
        {
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j]==1)
                {
                    grid[i][j] = 2;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if(r+1<m && grid[r+1][c]==1)
            {
                grid[r+1][c]=2;
                q.offer(new int[]{r+1,c});
            }            
            if(c+1<n && grid[r][c+1]==1)
            {
                grid[r][c+1]=2;
                q.offer(new int[]{r,c+1});
            }
            if(r-1>=0 && grid[r-1][c]==1)
            {
                grid[r-1][c]=2;
                q.offer(new int[]{r-1,c});
            }
            if(c-1>=0 && grid[r][c-1]==1)
            {
                grid[r][c-1]=2;
                q.offer(new int[]{r,c-1});
            }           

        }

        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }
}