// Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.

 

// Example 1:

// Input: S = "231*+9-"
// Output: -4
// Explanation:
// After solving the given expression, 
// we have -4 as result.

class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> st = new Stack<>();
        char[] ch = S.toCharArray();
        for(char c:ch)
        {
            if(Character.isDigit(c))
            {
                int x = c-'0';
                st.push(x);
            }
            else
            {
                int a = st.pop();
                int b = st.pop();
                int ans = 0;
                switch(c)
                {
                    case '+':
                        ans=b+a;
                        break;
                    case '-':
                        ans=b-a;
                        break;
                    case '*':
                        ans=b*a;
                        break;
                    case '/':
                        ans=b/a;
                        break;
                }
                st.push(ans);
                
            }
            
        }
        return st.pop();
    }
}