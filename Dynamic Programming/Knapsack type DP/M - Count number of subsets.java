// Perfect Sum Problem
// Difficulty: MediumAccuracy: 20.58%Submissions: 389K+Points: 4
// Given an array arr of size n of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

// Note: Answer can be very large, so, output answer modulo 109+7.

// Examples:

// Input: 
// n = 6, arr = [5, 2, 3, 10, 6, 8], sum = 10
// Output: 
// 3
// Explanation: 
// {5, 2, 3}, {2, 8}, {10} are possible subsets.
// Input: 
// n = 5, arr = [2, 5, 1, 4, 3], sum = 10
// Output: 
// 3
// Explanation: 
// {2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.

// Expected Time Complexity: O(n*sum)
// Expected Auxiliary Space: O(n*sum)

// Constraints:
// 1 ≤ n*sum ≤ 106
// 0 ≤ arr[i] ≤ 106

class Solution{
    // public static final int MOD = 1000000007;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	    int[][] t = new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                {
                    t[i][j] = 0;
                }
                if(j==0)
                {
                    t[i][j] = 1;
                }
                if(i>0 && arr[i-1]<=j)
                {
                    t[i][j] = ((t[i-1][j-arr[i-1]]+t[i-1][j]));
                    	// %MOD);
                }
                else if(i>0 && arr[i-1]>j)
                {
                    t[i][j] = ((t[i-1][j]));
                    	// %MOD);
                }
            }
        }
        return (t[n][sum]);
	} 
}