
// 20. Valid Parentheses
// Solved
// Easy
// Topics
// Companies
// Hint
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false
 

// Constraints:

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

class Solution {
    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char x:c)
        {            
            boolean c1 = x=='(';
            boolean c2 = x=='{';
            boolean c3 = x=='[';

            if(c1||c2||c3)
            {
                st.push(x);
            }
            else
            {
                if(st.isEmpty())
                {
                    //here it means stack hasnt even had any
                    //push of (,{ or [ into it yet
                    return false;
                }                
                if(x==')' && st.peek()=='(')
                {
                    st.pop();
                }
                else if(x==']' && st.peek()=='[')
                {
                    st.pop();
                }
                else if(x=='}' && st.peek()=='{')
                {
                    st.pop();
                }
                else
                {
                    st.push(x);
                }
            }

        }
        if(st.isEmpty())
        {
            return true;
        }
        return false;
    }
    
}