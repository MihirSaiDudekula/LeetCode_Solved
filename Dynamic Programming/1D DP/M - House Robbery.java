// 198. House Robber

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted

// recursive solution - TLE
class Solution {
    public int rob(int[] nums) {
        int ans = find(nums,0);
        return ans;
        
    }
    public int find(int[] nums,int i)
    {
        int n = nums.length;
        if(i==n-1)
        {
            return nums[n-1];
        }
        if(i==n-2)
        {
            return Math.max(nums[n-2],nums[n-1]);
        }

        int pick = nums[i] + find(nums,i+2);
        int skip = find(nums,i+1);

        return Math.max(pick,skip);
    }
}

// modified into DP soln
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Edge cases
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        
        // Initialize the dp array
        int[] dp = new int[n];
        
        // Base cases
        dp[n-1] = nums[n-1];  // If we are at the last house, take its value
        dp[n-2] = Math.max(nums[n-2], nums[n-1]);  // For the second last house, take the max of last two houses
        
        // Fill the dp array from the back
        for (int i = n - 3; i >= 0; i--) {
            int pick = nums[i] + dp[i+2];  // Pick the current house and add the value from i+2
            int skip = dp[i+1];  // Skip the current house, and take the value from i+1
            dp[i] = Math.max(pick, skip);  // Store the best option
        }
        
        // The answer will be in dp[0], which represents the maximum rob value starting from house 0
        return dp[0];
    }
}
