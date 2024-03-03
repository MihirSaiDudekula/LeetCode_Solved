// https://leetcode.com/problems/first-missing-positive/

// First Missing Positive

// Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

// Example 1:

// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.
// Example 2:

// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.
// Example 3:

// Input: nums = [7,8,9,11,12]
// Output: 1
// Explanation: The smallest positive integer 1 is missing.
 

// Constraints:

// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1


//naive solution

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1; // Handle empty array case
        }

        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > 0 && nums[i] > max) {
                max = nums[i];
            }
        }

        if (min > 1) {
            return 1; // Handle case when all positive integers are greater than 1
        } else {
            int i = 0;
            int temp;
            while (i < nums.length) {
                if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                    temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                } else {
                    i++;
                }
            }
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != j + 1) {
                    return j + 1; // Return the first missing positive integer
                }
            }
        }
        return max + 1; // Handle case when all positive integers from 1 to max are present
    }
}


//efficient solution

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // fun fact ==> in this question nums.length itself gives us the maximum element in our array
        int i = 0;
        while (i < n) {
            int correctIdx = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < n && nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}