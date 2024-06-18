// Postfix to Prefix Conversion
// Difficulty: MediumAccuracy: 83.44%Submissions: 6K+Points: 4
// You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its prefix form.

// Example 1:

// Input: 
// ABC/-AK/L-*
// Output: 
// *-A/BC-/AKL
// Explanation: 
// The above output is its valid prefix form.

import java.util.Stack;

class Solution {
    static String postToPre(String post_exp) {
        Stack<String> stack = new Stack<>();
        
        for (char c : post_exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c)); // Push operands onto stack
            } else {
                // Pop two operands from stack
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                
                // Form prefix expression for current operator
                String prefixExp = c + operand1 + operand2;
                
                // Push the prefix expression back to stack
                stack.push(prefixExp);
            }
        }
        
        // The final prefix expression will be on top of the stack
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String postfix = "ABC/-AK/L-*";
        String prefix = postToPre(postfix);
        System.out.println("Prefix expression: " + prefix);
    }
}
