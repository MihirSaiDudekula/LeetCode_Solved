// 39. Combination Sum
// Medium
// Topics
// Companies
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combos of candidates where the chosen numbers sum to target. You may return the combos in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combos are unique if the 
// frequency
//  of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combos that sum up to target is less than 150 combos for the given input.

 

// Example 1:

// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combos.
// Example 2:

// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]
// Example 3:

// Input: candidates = [2], target = 1
// Output: []
 

// Constraints:

// 1 <= candidates.length <= 30
// 2 <= candidates[i] <= 40
// All elements of candidates are distinct.
// 1 <= target <= 40

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> comboSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, new ArrayList<>(), 0, target, result, 0);
        return result;
    }

    public void backtrack(int[] candidates, List<Integer> combo, int sum, int target, List<List<Integer>> result,
            int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(combo));
            return;
        }

        // if i simply wanted all combinations that can make up my answer, i could do i=0, but we choose to do i=start because we need uniue combinations and, here [2,2,3] and [2,3,2] are considered to be same
        for (int i = start; i < candidates.length; i++) {
            combo.add(candidates[i]);
            backtrack(candidates, combo, sum + candidates[i], target, result, i);
            combo.remove(combo.size() - 1);
        }
    }
}
