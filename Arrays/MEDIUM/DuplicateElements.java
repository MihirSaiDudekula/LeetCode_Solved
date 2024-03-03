// # https://leetcode.com/problems/find-all-duplicates-in-an-array/

// Find All Duplicates in an Array

// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

// You must write an algorithm that runs in O(n) time and uses only constant extra space.

 

// Example 1:

// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]
// Example 2:

// Input: nums = [1,1,2]
// Output: [1]
// Example 3:

// Input: nums = [1]
// Output: []
 

// Constraints:

// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
// Each element in nums appears once or twice.

class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        List<Integer> list=new ArrayList<Integer>();
        int i = 0;
        int temp;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp;
            } else {
                i++;    
            }
        }
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j]!=j+1)
            {
                list.add(arr[j]);
            }
        }
        return list;
    }
}