// Find First and Last Position of Element in Sorted Array
// Solved
// Medium
// Topics
// Companies
// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]
 

// Constraints:

// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109



class Solution {
    public int[] searchRange(int[] nums, int target) {
        int fpos = firstpos(nums,0,nums.length-1,target);
        int lpos = lastpos(nums,0,nums.length-1,target);
        int[] a = new int[2];
        a[0] = fpos;
        a[1] = lpos;
        return a;
    }
    public int firstpos(int[] arr,int low,int high,int target)
    {
        // int mid= -1;
        int fp = -1;
        while(low<=high)
        {
            int mid = low+((high-low)/2);
            if(arr[mid]==target)
            {
                fp=mid;
                high=mid-1;
            }
            else if(arr[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return fp;
    }

    public int lastpos(int[] arr,int low,int high,int target)
    {
        // int mid=-1;
        int lp =-1;
        while(low<=high)
        {
            int mid = low+((high-low)/2);
            if(arr[mid]==target)
            {
                lp=mid;
                low=mid+1;
            }
            else if(arr[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return lp;
    }


}