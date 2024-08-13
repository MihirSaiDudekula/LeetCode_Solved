// 78. Subsets
// Medium
// Topics
// Companies
// Given an integer array nums of unique elements, return all possible 
// subsets
//  (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        genSubsets(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void genSubsets(List<List<Integer>> l, List<Integer> cur, int[] nums, int i) 
    {
        if (i == nums.length) {
            l.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        genSubsets(l, cur, nums, i + 1);
        cur.remove(cur.size() - 1);
        genSubsets(l, cur, nums, i + 1);
    }
}
