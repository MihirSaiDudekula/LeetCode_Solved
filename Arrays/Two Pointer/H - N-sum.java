import java.util.*;

public class NSumSolution {

    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        Arrays.sort(nums);  // Sort the array first
        return nSumHelper(nums, 0, target, n);
    }
    
    private List<List<Integer>> nSumHelper(int[] nums, int start, int target, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base case: 2-sum
        if (n == 2) {
            return twoSum(nums, start, target);
        }
        
        // For n > 2, reduce to (n-1)-sum
        for (int i = start; i <= nums.length - n; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Recursive call: fix nums[i], solve (n-1)-sum
            List<List<Integer>> subResults = nSumHelper(nums, i + 1, target - nums[i], n - 1);
            
            // Add current number to each solution
            for (List<Integer> subResult : subResults) {
                List<Integer> current = new ArrayList<>();
                current.add(nums[i]);
                current.addAll(subResult);
                result.add(current);
            }
        }
        
        return result;
    }
    
    /**
     * Two-sum implementation using two pointers
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                result.add(Arrays.asList(nums[left], nums[right]));
                
                // Skip duplicates
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return result;
    }
    
    // Convenience methods for common cases
    public List<List<Integer>> twoSum(int[] nums, int target) {
        return nSum(nums, target, 2);
    }
    
    public List<List<Integer>> threeSum(int[] nums, int target) {
        return nSum(nums, target, 3);
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, target, 4);
    }
    
    // Test cases
    public static void main(String[] args) {
        NSumSolution solution = new NSumSolution();
        
        // Test 2-sum
        int[] nums2 = {1, 2, 3, 4, 5, 6};
        System.out.println("2-Sum (target=7): " + solution.twoSum(nums2, 7));
        
        // Test 3-sum
        int[] nums3 = {-1, 0, 1, 2, -1, -4};
        System.out.println("3-Sum (target=0): " + solution.threeSum(nums3, 0));
        
        // Test 4-sum
        int[] nums4 = {1, 0, -1, 0, -2, 2};
        System.out.println("4-Sum (target=0): " + solution.fourSum(nums4, 0));
        
        // Test generic n-sum
        int[] nums5 = {1, 2, 3, 4, 5};
        System.out.println("5-Sum (target=15): " + solution.nSum(nums5, 15, 5));
    }
}

/*
Time Complexity: O(n^(k-1)) where k is the value of n in n-sum
- For 2-sum: O(n)
- For 3-sum: O(n^2)  
- For 4-sum: O(n^3)
- For k-sum: O(n^(k-1))

Space Complexity: O(k) for recursion stack depth

Key Features:
1. Handles duplicates by skipping them
2. Uses two-pointer technique for the base case (2-sum)
3. Recursive reduction from n-sum to (n-1)-sum
4. Works for any value of n >= 2
5. Returns all unique combinations
*/


======================= OR ================================

import java.util.*;

public class NSumIterative {
    
    /**
     * Non-recursive N-Sum solver using nested loops
     * Follows the pattern: (n-2) nested loops + twoSum for the last two elements
     */
    public List<List<Integer>> nSum(int[] nums, int target, int n) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        if (n == 2) {
            return twoSum(nums, 0, target);
        }
        
        // Use nested loops approach for n > 2
        switch (n) {
            case 3:
                return threeSum(nums, target);
            case 4:
                return fourSum(nums, target);
            case 5:
                return fiveSum(nums, target);
            default:
                // For larger n, we can use a generic approach with dynamic nesting
                return nSumGeneric(nums, target, n);
        }
    }
    
    /**
     * 3-Sum: 1 loop + twoSum
     */
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Apply your formula: nums[i] + twoSum(target - nums[i], i+1, nums.length-1)
            int remainingTarget = target - nums[i];
            List<List<Integer>> twoSumResults = twoSum(nums, i + 1, remainingTarget);
            
            for (List<Integer> pair : twoSumResults) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.addAll(pair);
                result.add(triplet);
            }
        }
        
        return result;
    }
    
    /**
     * 4-Sum: 2 nested loops + twoSum
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // Apply your formula: nums[i] + nums[j] + twoSum(target - nums[i] - nums[j], j+1, nums.length-1)
                int remainingTarget = target - nums[i] - nums[j];
                List<List<Integer>> twoSumResults = twoSum(nums, j + 1, remainingTarget);
                
                for (List<Integer> pair : twoSumResults) {
                    List<Integer> quadruplet = new ArrayList<>();
                    quadruplet.add(nums[i]);
                    quadruplet.add(nums[j]);
                    quadruplet.addAll(pair);
                    result.add(quadruplet);
                }
            }
        }
        
        return result;
    }
    
    /**
     * 5-Sum: 3 nested loops + twoSum
     */
    public List<List<Integer>> fiveSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                for (int k = j + 1; k < nums.length - 2; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    
                    // Apply your formula: nums[i] + nums[j] + nums[k] + twoSum(target - nums[i] - nums[j] - nums[k], k+1, nums.length-1)
                    int remainingTarget = target - nums[i] - nums[j] - nums[k];
                    List<List<Integer>> twoSumResults = twoSum(nums, k + 1, remainingTarget);
                    
                    for (List<Integer> pair : twoSumResults) {
                        List<Integer> quintuple = new ArrayList<>();
                        quintuple.add(nums[i]);
                        quintuple.add(nums[j]);
                        quintuple.add(nums[k]);
                        quintuple.addAll(pair);
                        result.add(quintuple);
                    }
                }
            }
        }
        
        return result;
    }
    
    /**
     * Generic N-Sum using dynamic approach (still iterative but more flexible)
     * This demonstrates your concept for arbitrary n
     */
    public List<List<Integer>> nSumGeneric(int[] nums, int target, int n) {
        if (n == 2) {
            return twoSum(nums, 0, target);
        }
        
        // Use iterative approach with stacks to simulate nested loops
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> currentCombination = new Stack<>();
        
        nSumHelper(nums, 0, target, n, currentCombination, result);
        return result;
    }
    
    private void nSumHelper(int[] nums, int start, int target, int n, 
                           Stack<Integer> current, List<List<Integer>> result) {
        if (n == 2) {
            // Base case: use twoSum
            List<List<Integer>> twoSumResults = twoSum(nums, start, target);
            for (List<Integer> pair : twoSumResults) {
                List<Integer> combination = new ArrayList<>(current);
                combination.addAll(pair);
                result.add(combination);
            }
            return;
        }
        
        // Iterative nested loop simulation
        for (int i = start; i <= nums.length - n; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            current.push(nums[i]);
            nSumHelper(nums, i + 1, target - nums[i], n - 1, current, result);
            current.pop();
        }
    }
    
    /**
     * Two-sum using two pointers
     */
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                result.add(Arrays.asList(nums[left], nums[right]));
                
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return result;
    }
    
    // Test cases
    public static void main(String[] args) {
        NSumIterative solution = new NSumIterative();
        
        // Test 3-sum
        int[] nums3 = {-1, 0, 1, 2, -1, -4};
        System.out.println("3-Sum (target=0): " + solution.threeSum(nums3, 0));
        
        // Test 4-sum  
        int[] nums4 = {1, 0, -1, 0, -2, 2};
        System.out.println("4-Sum (target=0): " + solution.fourSum(nums4, 0));
        
        // Test 5-sum
        int[] nums5 = {-3, -2, -1, 0, 1, 2, 3};
        System.out.println("5-Sum (target=0): " + solution.fiveSum(nums5, 0));
        
        // Test generic approach
        System.out.println("Generic 4-Sum (target=0): " + solution.nSumGeneric(nums4, 0, 4));
    }
}

/*
Your Formula Implementation:
For n-sum: (n-2) nested loops + twoSum

3-Sum: for(i) + twoSum(target - nums[i], i+1, end)
4-Sum: for(i) for(j) + twoSum(target - nums[i] - nums[j], j+1, end)  
5-Sum: for(i) for(j) for(k) + twoSum(target - nums[i] - nums[j] - nums[k], k+1, end)

This exactly matches your intuition:
nums[i] + nums[j] + ... + nums[n-2] + twoSum(target - (sum of first n-2 elements), startIndex, endIndex)
*/