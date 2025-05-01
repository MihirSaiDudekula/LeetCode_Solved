// 2962. Count Subarrays Where Max Element Appears at Least K Times
// Solved
// Medium
// Topics
// Companies
// You are given an integer array nums and a positive integer k.

// Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

// A subarray is a contiguous sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,3,2,3,3], k = 2
// Output: 6
// Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
// Example 2:

// Input: nums = [1,4,2,1], k = 3
// Output: 0
// Explanation: No subarray contains the element 4 at least 3 times.
 

// Constraints:

// 1 <= nums.length <= 105
// 1 <= nums[i] <= 106
// 1 <= k <= 105

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long count = 0; // Number of occurrences of the max value
        long ans = 0;   // The final result (number of subarrays)
        int i = 0;     // Start index of the sliding window


        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == max) {
                count++;
            }

            while (count >= k) {
                ans += (nums.length - j); // All subarrays from i to any index >= j are valid
                // Shrink the window from the left
                if (nums[i] == max) {
                    count--;
                }
                i++;
            }
        }

        return ans;
    }
}