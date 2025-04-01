// 200. Number of Islands
// Solved
// Medium
// Topics
// Companies
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'

class Solution {
    public int numIslands(char[][] grid) {
        int len = grid.length;
        int brd = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[len][brd];
        int islandCount = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < brd; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    islandCount++;
                    q.offer(new int[] { i, j });
                    vis[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];

                        if (r + 1 < len && grid[r + 1][c] == '1' && !vis[r + 1][c]) {
                            q.offer(new int[] { r + 1, c });
                            vis[r + 1][c] = true;
                        }

                        if (r - 1 >= 0 && grid[r - 1][c] == '1' && !vis[r - 1][c]) {
                            q.offer(new int[] { r - 1, c });
                            vis[r - 1][c] = true;
                        }

                        if (c + 1 < brd && grid[r][c + 1] == '1' && !vis[r][c + 1]) {
                            q.offer(new int[] { r, c + 1 });
                            vis[r][c + 1] = true;
                        }

                        if (c - 1 >= 0 && grid[r][c - 1] == '1' && !vis[r][c - 1]) {
                            q.offer(new int[] { r, c - 1 });
                            vis[r][c - 1] = true;
                        }
                    }
                }
            }
        }
        return islandCount;
    }
}
