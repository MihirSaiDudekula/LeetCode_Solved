// Search in Rotated Sorted Array II
// Solved
// Medium
// Topics
// Companies
// There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

// Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

// Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

// You must decrease the overall operation steps as much as possible.

 

// Example 1:

// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true
// Example 2:

// Input: nums = [2,5,6,0,0,1,2], target = 3
// Output: false
 

// Constraints:

// 1 <= nums.length <= 5000
// -104 <= nums[i] <= 104
// nums is guaranteed to be rotated at some pivot.
// -104 <= target <= 104

class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return true;
            }

            else if(nums[start]==nums[end])
            {
                //if both our start and end element are same, 
                // we will not be able to tell which side is sorted

                // so if at all this element is the target, return it 
                if(nums[start]==target)
                {
                    return true;
                }
                // if not, there is no need to check it. since we just want to see which side is sorted, check from start++ and end-- (start and end are the same elem)
                else
                {
                    start++;
                    end--;
                }
                
            }
            
            // Check which side is sorted
            else if (nums[start] <= nums[mid]) { // Left side is sorted
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
        
        return false; // Target not found
      
    }
}
