//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

// Find All Numbers Disappeared in an Array

// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

// Example 1:

// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [5,6]
// Example 2:

// Input: nums = [1,1]
// Output: [2]
 

// Constraints:

// n == nums.length
// 1 <= n <= 105
// 1 <= nums[i] <= n
 

// Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> list=new ArrayList<Integer>();
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != arr[arr[i] - 1]) {
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[arr[i] - 1] = temp;
            } else {
                i++;    
            }
        }
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j]!=j+1)
            {
                list.add(j+1);
            }
        }
        return list;
    }
}