// 386. Lexicographical Numbers
// Solved
// Medium
// Topics
// Companies
// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

// You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

// Example 1:

// Input: n = 13
// Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
// Example 2:

// Input: n = 2
// Output: [1,2]
 

// Constraints:

// 1 <= n <= 5 * 104

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n); // Pre-size the list
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }
    
    private void dfs(int current, int n, List<Integer> result) {
        // Add current number if it's within range
        if (current > n) {
            return;
        }
        
        result.add(current);
        
        // Explore children (append digits 0-9)
        current *= 10;
        for (int i = 0; i <= 9 && current + i <= n; i++) {
            dfs(current + i, n, result);
        }
    }
}