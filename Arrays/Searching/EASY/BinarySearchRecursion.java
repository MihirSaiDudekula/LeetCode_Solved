// https://leetcode.com/problems/binary-search/description/

// 704. Binary Search

// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4
// Example 2:

// Input: nums = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in nums so return -1
 

// Constraints:

// 1 <= nums.length <= 104
// -104 < nums[i], target < 104
// All the integers in nums are unique.
// nums is sorted in ascending order.

class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        return bins(nums, s, e, target);
    }

    public int bins(int[] arr, int s, int e, int key) {
        if (s <= e) {
            int mid = s + ((e - s) / 2);
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                return bins(arr, mid + 1, e, key);
            } else {
                return bins(arr, s, mid - 1, key);
            }
        }
        return -1; // Return -1 if the element is not found
    }
}

