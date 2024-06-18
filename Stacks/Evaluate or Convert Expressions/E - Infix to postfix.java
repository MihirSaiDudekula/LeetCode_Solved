// Infix to Postfix

// Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

// Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
// Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
// Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. Ignore the right associativity of ^.
// Example 1:

// Input: str = "a+b*(c^d-e)^(f+g*h)-i"
// Output: abcd^e-fgh*+^*+i-
// Explanation:
// After converting the infix expression 
// into postfix expression, the resultant 
// expression will be abcd^e-fgh*+^*+i-

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        StringBuilder output = new StringBuilder();
        Stack<Character> s = new Stack<>();
        
        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                output.append(c);
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    output.append(s.pop());
                }
                s.pop(); // Remove '(' from stack
            } else { // c is an operator +, -, *, /, ^
                while (!s.isEmpty() && priority(c) <= priority(s.peek())) {
                    output.append(s.pop());
                }
                s.push(c);
            }
        }
        
        // Pop all the operators from the stack
        while (!s.isEmpty()) {
            output.append(s.pop());
        }
        
        return output.toString();
    }
    
    public static int priority(char c) {
        switch (c) {
            case '^':
                return 3;
            case '/':
            case '*':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0; // lowest priority
        }
    }
}
