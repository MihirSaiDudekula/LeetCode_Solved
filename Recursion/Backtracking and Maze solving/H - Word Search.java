// 79. Word Search
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.
 

// Follow up: Could you use search pruning to make your solution faster with a larger board?

class Solution {
    private int rows;
    private int cols;
    private int[][] directions = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        
        if (index == word.length()){
            return true;
        }

        if (r < 0 || r >= rows || c < 0 || c >= cols ||
            board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c]; // Save current letter
        board[r][c] = '#';       // Mark as visited

        for (int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            boolean ans = dfs(board, word, newRow, newCol, index + 1);
            if(ans==true) {
                return true;
            }
            else
            {
                continue;
            }
        }

        board[r][c] = temp; // Backtrack
        return false;
    }
}
