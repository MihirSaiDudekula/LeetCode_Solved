// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The answer is guaranteed to fit into a signed 32-bit integer.

 

// Example 1:

// Input: amount = 5, coins = [1,2,5]
// Output: 4
// Explanation: there are four ways to make up the amount:
// 5=5
// 5=2+2+1
// 5=2+1+1+1
// 5=1+1+1+1+1
// Example 2:

// Input: amount = 3, coins = [2]
// Output: 0
// Explanation: the amount of 3 cannot be made up just with coins of 2.
// Example 3:

// Input: amount = 10, coins = [10]
// Output: 1
 

// Constraints:

// 1 <= coins.length <= 300
// 1 <= coins[i] <= 5000
// All the values of coins are unique.
// 0 <= amount <= 5000

class Solution {
    public int change(int amount, int[] coins) {
        int N = coins.length;
        int W = amount;
        int[][] t = new int[N + 1][W + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }

                if (i > 0) {
                    if (coins[i - 1] <= j) {
                        t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                    } else {
                        t[i][j] = t[i - 1][j];
                    }
                }
            }
        }
        return t[N][W];
    }
}

// Table Generation:
// Let me generate the 2D DP table for you. coins=[1,2,5] amount=10

// Coins\Amount		0	1	2	3	4	5	6	7	8	9	10
// Using no coins	1	0	0	0	0	0	0	0	0	0	0
// Using coin 1		1	1	1	1	1	1	1	1	1	1	1
// Using coin 2		1	1	2	2	3	3	4	4	5	5	6
// Using coin 5		1	1	2	2	3	4	5	6	7	8	10

// Table Generation:
// Let me generate the 2D DP table for you. coins=[1,2,5] amount=10

// Coins\Amount     0   1   2   3   4   5   6   7   8   9   10
// Using no coins   0   I   I   I   I   I   I   I   I   I   I
// Using coin 1     0   1   2   3   4   5   6   7   8   9   10
// Using coin 2     0   1   1   2   2   3   3   4   4   5   5
// Using coin 5     0   1   1   2   2   1   2   2   3   3   2

