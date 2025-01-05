// 977. Squares of a Sorted Array
// Solved
// Easy
// Topics
// Companies
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// Example 2:

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]

class Solution {
    public int[] sortedSquares(int[] nums) 
    {
        int i=0;
        int j=nums.length-1;
        int[] ans = new int[nums.length];
        int k = ans.length-1;
        while(i!=j)
        {
            if(Math.abs(nums[i])>=Math.abs(nums[j]))
            {
                ans[k]=nums[i]*nums[i];
                i++;
                k--;
            }
            else if(Math.abs(nums[j])>=Math.abs(nums[i]))
            {
                ans[k]=nums[j]*nums[j];
                j--;
                k--;
            }
        }

        if(i==j && k==0)
        {
            ans[k]=nums[i]*nums[i];
        }

        return ans;

    }
}