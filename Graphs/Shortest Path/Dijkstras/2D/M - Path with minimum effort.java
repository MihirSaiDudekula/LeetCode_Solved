// 1631. Path With Minimum Effort
// Solved
// Medium
// Topics
// Companies
// Hint
// You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

// Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

 

// Example 1:



// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
// Output: 2
// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
// This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
// Example 2:



// Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
// Output: 1
// Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
// Example 3:


// Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
// Output: 0
// Explanation: This route does not require any effort.
 

// Constraints:

// rows == heights.length
// columns == heights[i].length
// 1 <= rows, columns <= 100
// 1 <= heights[i][j] <= 106

import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[2], b[2]); 
            }
        });


        int[][] sp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sp[i][j] = Integer.MAX_VALUE;
            }
        }

        sp[0][0] = 0; 
        pq.offer(new int[] {0, 0, 0});  

        
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };


        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int row = cur[0];
            int col = cur[1];
            int effort = cur[2]; 
            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {

                    int weight = Math.abs(heights[newRow][newCol] - heights[row][col]);

                    int newEffort = Math.max(effort, weight);

                    if (newEffort < sp[newRow][newCol]) {
                        sp[newRow][newCol] = newEffort;
                        pq.offer(new int[] {newRow, newCol, newEffort});
                    }
                }
            }
        }

        return sp[n-1][m-1] == Integer.MAX_VALUE ? -1 : sp[n-1][m-1];
    }
}
