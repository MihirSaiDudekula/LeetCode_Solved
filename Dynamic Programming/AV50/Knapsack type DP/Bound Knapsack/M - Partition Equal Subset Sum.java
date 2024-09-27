// 416. Partition Equal Subset Sum
// Solved
// Medium
// Topics
// Companies
// Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

// Example 1:

// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
// Example 2:

// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 

// Constraints:

// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

class Solution {
    public boolean canPartition(int[] nums) 
    {
        int sum = 0;
        for(int x:nums)
        {
            sum+=x;
        }    
        if(sum%2!=0)
        {
            return false;
        }

        int reqsum = sum/2;
        return isSubsetSum(nums.length,nums,reqsum);

    }
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