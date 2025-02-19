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
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int i = 0, count = 0, n = 0;

        for (int j = 0; j < nums.length; j++) 
        {

            if (nums[j] % 2 != 0) {
                n++;
            }

            while (n > k) {
                if (nums[i] % 2 != 0) {
                    n--;
                }
                i++;
            }

            count += (j - i + 1);
        }

        return count;
    }
}
