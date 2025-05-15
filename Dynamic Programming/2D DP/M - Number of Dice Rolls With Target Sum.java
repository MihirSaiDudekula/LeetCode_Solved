// 1155. Number of Dice Rolls With Target Sum
// Solved
// Medium
// Topics
// Companies
// Hint
// You have n dice, and each dice has k faces numbered from 1 to k.

// Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.

 

// Example 1:

// Input: n = 1, k = 6, target = 3
// Output: 1
// Explanation: You throw one die with 6 faces.
// There is only one way to get a sum of 3.
// Example 2:

// Input: n = 2, k = 6, target = 7
// Output: 6
// Explanation: You throw two dice, each with 6 faces.
// There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
// Example 3:

// Input: n = 30, k = 30, target = 500
// Output: 222616187
// Explanation: The answer must be returned modulo 109 + 7.
 

// Constraints:

// 1 <= n, k <= 30
// 1 <= target <= 1000

class Solution {
    int mod = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        int ways = 0;
        for(int i=1; i<=k; i++) {
            ways = (ways + rec(k, n, i, 1, target)) % mod;
        }
        return ways;
    }

    public int rec(int faces, int dies, int runsum, int elems, int target) {
        if(runsum > target) {
            return 0;
        }

        if(elems == dies) {
            if(runsum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int ways = 0;
        for(int i=1; i<=faces; i++) {
            ways = (ways + rec(faces, dies, runsum+i, elems+1, target)) % mod;
        }

        return ways;
    }
}

// memo

class Solution {
    int mod = 1_000_000_007;
    
    public int numRollsToTarget(int n, int k, int target) {
        // Create memoization table and initialize with -1
        int[][] memo = new int[n + 1][target + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        int ways = 0;
        for(int i=1; i<=k; i++) {
            // Only add if the value doesn't exceed target
            if (i <= target) {
                ways = (ways + rec(k, n, i, 1, target, memo)) % mod;
            }
        }
        return ways;
    }
    
    public int rec(int faces, int dies, int runsum, int elems, int target, int[][] memo) {
        // Base case 1: Sum exceeds target
        if(runsum > target) {
            return 0;
        }
        
        // Base case 2: All dice used
        if(elems == dies) {
            return (runsum == target) ? 1 : 0;
        }
        
        // Check if this state has already been computed
        if (memo[elems][runsum] != -1) {
            return memo[elems][runsum];
        }
        
        int ways = 0;
        for(int i=1; i<=faces; i++) {
            // Only proceed if adding this face value won't exceed target
            if (runsum + i <= target) {
                ways = (ways + rec(faces, dies, runsum+i, elems+1, target, memo)) % mod;
            }
        }
        
        // Store the result in memo table before returning
        memo[elems][runsum] = ways;
        return ways;
    }
}