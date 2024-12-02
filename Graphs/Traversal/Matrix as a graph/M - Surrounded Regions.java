// 130. Surrounded Regions
// Solved
// Medium
// Topics
// Companies
// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// A surrounded region is captured by replacing all 'O's with 'X's in the input matrix board.

 

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Explanation:


// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

// Example 2:

// Input: board = [["X"]]

// Output: [["X"]]

 

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.

class Solution {
    public void solve(char[][] board) {
        // Corner case: if the board is empty, return early
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        // Mark cells connected to boundary
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'S'; // Mark as safe ('S')
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }

        // BFS to mark connected 'O's as 'S'
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            // Check all 4 neighbors (up, down, left, right)
            if (r + 1 < m && board[r + 1][c] == 'O') {
                board[r + 1][c] = 'S'; // Mark as safe ('S')
                q.offer(new int[]{r + 1, c});
            }

            if (r - 1 >= 0 && board[r - 1][c] == 'O') {
                board[r - 1][c] = 'S'; // Mark as safe ('S')
                q.offer(new int[]{r - 1, c});
            }

            if (c + 1 < n && board[r][c + 1] == 'O') {
                board[r][c + 1] = 'S'; // Mark as safe ('S')
                q.offer(new int[]{r, c + 1});
            }

            if (c - 1 >= 0 && board[r][c - 1] == 'O') {
                board[r][c - 1] = 'S'; // Mark as safe ('S')
                q.offer(new int[]{r, c - 1});
            }
        }

        // Convert all 'O' to 'X' (unsafe), and 'S' back to 'O' (safe)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // This is an 'O' that is surrounded by 'X'
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O'; // This is a safe 'O' that should remain 'O'
                }
            }
        }
    }
}
