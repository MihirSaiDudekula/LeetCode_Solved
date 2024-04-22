//https://leetcode.com/problems/set-mismatch/description/

// Set Mismatch
// Solved
// Easy
// Topics
// Companies
// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// You are given an integer array nums representing the data status of this set after the error.

// Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

// Example 1:

// Input: nums = [1,2,2,4]
// Output: [2,3]
// Example 2:

// Input: nums = [1,1]
// Output: [1,2]
 

// Constraints:

// 2 <= nums.length <= 104
// 1 <= nums[i] <= 104

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        int i=0;
        int temp;
        while(i<nums.length)
        {
            if(nums[i]!=nums[nums[i]-1])
            {
                temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[temp-1]=temp;                
            }
            else
            {
                i++;
            }
        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]!=i+1)
            {
                arr[0]=nums[i];
                arr[1]=i+1;
            }
        }
        return arr;
    }
}