// Knapsack with Duplicate Items
// Difficulty: MediumAccuracy: 52.13%Submissions: 157K+Points: 4
// Given a set of N items, each with a weight and a value, represented by the array wt and val respectively. Also, a knapsack with weight limit W.
// The task is to fill the knapsack in such a way that we can get the maximum profit. Return the maximum profit.
// Note: Each item can be taken any number of times.

// Examples:

// Input: N = 2, W = 3, val = {1, 1}, wt = {2, 1}
// Output: 3
// Explanation: 1.Pick the 2nd element thrice. 2.Total profit = 1 + 1 + 1 = 3. Also the total weight = 1 + 1 + 1  = 3 which is <= 3.
// Input: N = 4, W = 8, val[] = {6, 1, 7, 7}, wt[] = {1, 3, 4, 5}
// Output: 48
// Explanation: The optimal choice is to pick the 1st element 8 times.
// Your Task:
// You do not need to read input or print anything. Your task is to complete the function knapSack() which takes the values N, W and the arrays val and wt as input parameters and returns the maximum possible value.

// Expected Time Complexity: O(N*W)
// Expected Auxiliary Space: O(W)

// Constraints:
// 1 ≤ N, W ≤ 1000
// 1 ≤ val[i], wt[i] ≤ 100

class Solution {
    static int knapSack(int N, int W, int val[], int wt[]) {
        
        int[][] t = new int[N+1][W+1];
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(i == 0 || j == 0) 
                {
                    t[i][j] = 0;
                }
                if (i>0 && wt[i-1] <= j) 
                {
                    // Return the maximum of including the last item or excluding it
                    t[i][j] = Math.max(val[i - 1] + t[i][j-wt[i-1]],t[i-1][j]);
                } 
                else if(i>0 && wt[i-1] > j)
                {
                    // If the last item's weight is more than the current capacity, skip it
                    t[i][j] = t[i-1][j];
                }

            }
        }
        return t[N][W];   
    }
}
