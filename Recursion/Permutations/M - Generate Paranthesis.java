// 22. Generate Parentheses
// Solved
// Medium
// Topics
// Companies
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        generateParenthesesHelper(result, "", 0, 0, n);
        return result;
    }

    private static void generateParenthesesHelper(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generateParenthesesHelper(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            generateParenthesesHelper(result, current + ")", open, close + 1, n);
        }
    }
}
