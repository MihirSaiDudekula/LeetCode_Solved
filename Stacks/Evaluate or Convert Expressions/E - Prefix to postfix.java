// Prefix to Postfix Conversion
// Difficulty: MediumAccuracy: 82.25%Submissions: 6K+Points: 4
// You are given a string that represents the prefix form of a valid mathematical expression. Convert it to its postfix form.

// Example:

// Input: 
// *-A/BC-/AKL
// Output: 
// ABC/-AK/L-*
// Explanation: 
// The above output is its valid postfix form.

class Solution {
    static String preToPost(String pre_exp) {
        Stack<String> stack = new Stack<>();
        
        // Process the prefix expression from right to left
        for (int i = pre_exp.length() - 1; i >= 0; i--)
        //come from back
        {
            char c = pre_exp.charAt(i);
            
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c)); // Push operands onto stack
            } else {
                // Pop two operands from stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                
                // Form postfix expression for current operator
                String postfixExp = operand1 + operand2 + c;
                
                // Push the postfix expression back to stack
                stack.push(postfixExp);
            }
        }
        
        // The final postfix expression will be on top of the stack
        return stack.pop();
    }
}