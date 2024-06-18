// Postfix to Infix Conversion

// You are given a string that represents the postfix form of a valid mathematical expression. Convert it to its infix form.

// Example:

// Input:
// ab*c+ 
// Output: 
// ((a*b)+c)
// Explanation: 
// The above output is its valid infix form.
// Your Task:

// Complete the function string postToInfix(string post_exp), which takes a postfix string as input and returns its infix form.

 

// Expected Time Complexity: O(N).

// Expected Auxiliary Space: O(N).

// Constraints:

// 3<=post_exp.length()<=104

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st = new Stack<>();
        StringBuilder output = new StringBuilder();
        char[] ch = exp.toCharArray();
        String[] sa = new String[ch.length];
        for(int i=0;i<ch.length;i++)
        {
            sa[i]=String.valueOf(ch[i]);
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
                output.append(b);
                output.append(str);
                output.append(a);
                output.append(')');
                st.push(output.toString());
                output.setLength(0);
                
            }
        }
        return st.pop().toString();
    }
}

