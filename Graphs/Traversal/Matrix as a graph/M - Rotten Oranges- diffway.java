// 994. Rotting Oranges
// Medium
// Topics
// Companies
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

// 994. Rotting Oranges
// Medium
// Topics
// Companies
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

// Example 1:


// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.

class Solution {

    public int orangesRotting(int[][] grid) {
        int noOfRows = grid.length;        // Get the number of rows in the grid
        int noOfCols = grid[0].length;     // Get the number of columns in the grid
        int noOfFreshOranges = 0;          // Counter for the number of fresh oranges
        int times = 0;                     // Time counter for the rotting process

        Queue<int[]> bfsQueue = new LinkedList<>(); // Queue for BFS (Breadth-First Search)

        // Traverse the grid to count fresh oranges and add rotten ones to the queue
        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfCols; j++) {
                if (grid[i][j] == 1) {
                    noOfFreshOranges++;    // Increment count of fresh oranges
                } else if (grid[i][j] == 2) {
                    bfsQueue.add(new int[]{i, j}); // Add position of rotten orange to the queue
                }
            }
        }

        // If there are no fresh oranges, return 0 as no time is needed
        if (noOfFreshOranges == 0) return 0;

        // Add a delimiter (null) to mark the end of each time unit in BFS
        bfsQueue.add(null);

        // Process the grid until there are no fresh oranges or the queue is empty
        while (noOfFreshOranges > 0 && !bfsQueue.isEmpty()) {
            int[] arr = bfsQueue.poll(); // Dequeue the front element

            if (arr == null) {
                // If the delimiter is reached and the queue is not empty,
                // add the delimiter again to mark the next time unit and increment the time counter
                if (!bfsQueue.isEmpty()) {
                    bfsQueue.add(null);
                    times++;
                }
                continue; // Skip the rest of the loop
            }

            int row = arr[0]; // Current row index
            int col = arr[1]; // Current column index

            // Check all four possible directions (up, down, left, right) for fresh oranges
            if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = 2; // Mark orange as rotten
                noOfFreshOranges--;     // Decrement count of fresh oranges
                bfsQueue.add(new int[]{row - 1, col}); // Add new rotten orange to the queue
            }
            if (row + 1 < noOfRows && grid[row + 1][col] == 1) {
                grid[row + 1][col] = 2;
                noOfFreshOranges--;
                bfsQueue.add(new int[]{row + 1, col});
            }
            if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = 2;
                noOfFreshOranges--;
                bfsQueue.add(new int[]{row, col - 1});
            }
            if (col + 1 < noOfCols && grid[row][col + 1] == 1) {
                grid[row][col + 1] = 2;
                noOfFreshOranges--;
                bfsQueue.add(new int[]{row, col + 1});
            }
        }

        // If all fresh oranges are rotten, return the time taken
        if (noOfFreshOranges == 0) {
            return times + 1;
        }

        // If there are still fresh oranges left, return -1 (not all oranges can rot)
        return -1;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int noOfrows = grid.length;
        int noOfcols = grid[0].length;
        int noOfFreshOranges = 0;
        int times = 0;

        Queue<int[]> bfsq = new LinkedList<>();
    }
    
    for(int i=0;i<noOfrows;i++)
    {
        for(int j=0;j<noOfcols;j++)
        {
            if(grid[i][j]==1)
            {
                noOfFreshOranges++;
            }
            else if(grid[i][j]==2)
            {
                bfsq.add(new int[]{i,j});
            }
        }
    }
}