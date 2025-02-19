// 279. Perfect Squares
// Solved
// Medium
// Topics
// Companies
// Given an integer n, return the least number of perfect square numbers that sum to n.

// A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

// Example 1:

// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
// Example 2:

// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.
 

// Constraints:

// 1 <= n <= 104

class Solution {
    public int numSquares(int n) {
        // Create 1D DP array
        int[] dp = new int[n + 1];
        
        // Initialize with worst case (all ones)
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        
        // For each number from 2 to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            int square = i * i;
            // Update all possible sums using this square
            for (int j = square; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }
        
        return dp[n];
    }
}