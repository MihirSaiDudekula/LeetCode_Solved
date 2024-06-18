// Prefix to Infix Conversion
// Difficulty: MediumAccuracy: 78.09%Submissions: 7K+Points: 4
// You are given a string S of size N that represents the prefix form of a valid mathematical expression. Convert it to its infix form.

// Example 1:

// Input: 
// *-A/BC-/AKL
// Output: 
// ((A-(B/C))*((A/K)-L))
// Explanation: 
// The above output is its valid infix form.

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        StringBuilder output = new StringBuilder();
        char[] c = pre_exp.toCharArray();
        String[] sa = new String[c.length];
        int count=0;
        for(int i=c.length-1;i>=0;i--)
        {
            sa[count]=String.valueOf(c[i]);
            count++;
            //reversed as a string array
        }
        for(String str:sa)
        {
            if(Character.isAlphabetic(str.charAt(0))||str.charAt(0)=='(')
            {
                st.push(str);
            }
            else
            {
                String a = st.pop();
                String b = st.pop();
                output.append('(');
                output.append(a);
                output.append(str);
                output.append(b);
                output.append(')');
                st.push(output.toString());
                output.setLength(0);
                
            }
        }
        return st.pop().toString();
    }
}
