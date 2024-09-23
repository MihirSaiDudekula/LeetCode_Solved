// Subset Sum Problem
// Difficulty: MediumAccuracy: 32.0%Submissions: 263K+Points: 4
// Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

// Examples:

// Input: n = 6, arr[] = {3, 34, 4, 12, 5, 2}, sum = 9
// Output: 1 
// Explanation: Here there exists a subset with sum = 9, 4+3+2 = 9.
// Input: n = 6, arr[] = {3, 34, 4, 12, 5, 2} , sum = 30
// Output: 0 
// Explanation: There is no subset with sum 30.

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function isSubsetSum() which takes the array arr[], its size N and an integer sum as input parameters and returns boolean value true if there exists a subset with given sum and false otherwise. The driver code itself prints 1, if returned value is true and prints 0 if returned value is false.

// Expected Time Complexity: O(sum*n)
// Expected Auxiliary Space: O(sum*n)

// Constraints:
// 1 <= n <= 100
// 1<= arr[i] <= 100
// 1<= sum <= 104

class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean[][] t = new boolean[N+1][sum+1];
        for(int i=0;i<=N;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                {
                    t[i][j] = false;
                }
                if(j==0)
                {
                    t[i][j] = true;
                }
                if(i>0 && arr[i-1]<=j)
                {
                    t[i][j] = t[i-1][j-arr[i-1]]||t[i-1][j];
                }
                else if(i>0 && arr[i-1]>j)
                {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[N][sum];
    }
}