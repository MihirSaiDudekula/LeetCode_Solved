// https://leetcode.com/problems/move-zeroes/

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1

class Solution {
    public void moveZeroes(int[] arr) 
    {
        int uq = 0;
        int temp;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=0)
            {
                uq++;
                temp=arr[i];
                arr[i]=arr[uq-1];
                arr[uq-1]=temp;
            }

        }
        
    }
}