// 40. Combination Sum II
// Solved
// Medium
// Topics
// Companies
// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]
 

// Constraints:

// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the candidates to facilitate skipping duplicates
        Arrays.sort(candidates);
        backtrack(candidates, new ArrayList<>(), 0, target, result, 0);
        return result;
    }

    public void backtrack(int[] candidates, List<Integer> combo, int sum, int target, List<List<Integer>> result, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(combo));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            combo.add(candidates[i]);
            backtrack(candidates, combo, sum + candidates[i], target, result, i + 1);
            combo.remove(combo.size() - 1);
        }
    }
}

