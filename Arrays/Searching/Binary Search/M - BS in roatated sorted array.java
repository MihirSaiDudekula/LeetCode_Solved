// 33. Search in Rotated Sorted Array
// Solved
// Medium
// Topics
// Companies
// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1
 

// Constraints:

// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -104 <= target <= 104

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check which side is sorted
            if (nums[start] <= nums[mid]) { // Left side is sorted
                // Check if target is within the sorted left side
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1; // Target lies in the sorted left side
                } else {
                    start = mid + 1; // Target lies in the unsorted right side
                }
            } else { // Right side is sorted
                // Check if target is within the sorted right side
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1; // Target lies in the sorted right side
                } else {
                    end = mid - 1; // Target lies in the unsorted left side
                }
            }
        }
        
        return -1; // Target not found
    }
}

