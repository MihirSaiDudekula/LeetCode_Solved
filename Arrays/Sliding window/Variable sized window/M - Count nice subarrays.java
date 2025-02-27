// 1248. Count Number of Nice Subarrays
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

// Return the number of nice sub-arrays.

 

// Example 1:

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
// Example 2:

// Input: nums = [2,4,6], k = 1
// Output: 0
// Explanation: There are no odd numbers in the array.
// Example 3:

// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16
 

// Constraints:

// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10^5
// 1 <= k <= nums.length

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0;
        int oddc = 0;
        int count = 0;
        int curr = 0;
        
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] % 2 != 0) {
                oddc++;
            }
            while (oddc > k) {
                if (nums[start] % 2 != 0) {
                    oddc--;
                }
                start++;
            }

            if (oddc == k) {
                int temp = start;
                curr = 1;  
                while (temp < nums.length && nums[temp] % 2 == 0) {
                    curr++;
                    temp++;
                }
                count += curr;  
            }
        }
        return count;
    }
}
