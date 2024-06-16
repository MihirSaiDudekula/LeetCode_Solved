// 53. Maximum Subarray
// Solved
// Medium
// Topics
// Companies
// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.

 

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104

class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        //say the maxsum is first element itself
        int sum = 0;
        // let initially our sum be 0
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            // for each sum in this array, add to our sum
            maxsum = maxsum>sum?maxsum:sum;
            // determine the bigger sum in current sum and previous max sum. assign that to maxsum
            if(sum<0)
            {
                sum=0;
                //if sum<0, it is of no use to us, as we know that max sum 
            }
        }
        return maxsum;        
    }
}