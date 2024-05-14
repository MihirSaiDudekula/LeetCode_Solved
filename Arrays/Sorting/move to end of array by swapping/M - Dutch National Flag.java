// Sort Colors
// Solved
// Medium
// Topics
// Companies
// Hint
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

class Solution {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap the element at mid with the element at low
                swap(nums, low, mid);
                // Increment both low and mid
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Move mid pointer forward if the element is 1
                mid++;
            } else {
                // Swap the element at mid with the element at high
                swap(nums, mid, high);
                // Decrement high pointer only
                high--;
            }
        }
    }
}
