// Rod Cutting
// Difficulty: MediumAccuracy: 60.66%Submissions: 139K+Points: 4
// Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

// Note: Consider 1-based indexing.

// Example:

// Input: n = 8, price[] = {1, 5, 8, 9, 10, 17, 17, 20}
// Output: 22
// Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5+17=22.
// Input: n = 8, price[] = {3, 5, 8, 9, 10, 17, 17, 20}
// Output: 24
// Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1]= 8*3 = 24.
// Your Task:  You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.

// Expected Time Complexity: O(n2)
// Expected Auxiliary Space: O(n)

// Constraints:
// 1 ≤ n≤ 1000
// 1 ≤ price[i] ≤ 105

class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[] len = new int[n];
        for(int i=0;i<n;i++)
        {
            len[i]=i+1;
        }
        return knapSack(n,n,price,len);
    }
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
