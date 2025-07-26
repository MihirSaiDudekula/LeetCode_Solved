// 984. String Without AAA or BBB
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given two integers a and b, return any string s such that:

// s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
// The substring 'aaa' does not occur in s, and
// The substring 'bbb' does not occur in s.
 

// Example 1:

// Input: a = 1, b = 2
// Output: "abb"
// Explanation: "abb", "bab" and "bba" are all correct answers.
// Example 2:

// Input: a = 4, b = 1
// Output: "aabaa"
 

// Constraints:

// 0 <= a, b <= 100
// It is guaranteed such an s exists for the given a and b

// I MODIFIED THIS QUESTION TO GENERATE ALL COMBOS!!

class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        rec(sb, 0, 0, a, b);
        return sb.toString();
    }
    
    public void rec(StringBuilder sb, int consecutiveA, int consecutiveB, int a, int b) {
        // Base case: no more characters to add
        if (a == 0 && b == 0) {
            return;
        }
        
        // If only b's left, add them (but not more than 2 consecutive)
        if (a == 0) {
            if (consecutiveB < 2) {
                sb.append("b");
                rec(sb, 0, consecutiveB + 1, a, b - 1);
            }
            return;
        }
        
        // If only a's left, add them (but not more than 2 consecutive)
        if (b == 0) {
            if (consecutiveA < 2) {
                sb.append("a");
                rec(sb, consecutiveA + 1, 0, a - 1, b);
            }
            return;
        }
        
        // Both a and b available - make strategic choice
        
        // If we have 2 consecutive a's, we must add b
        if (consecutiveA == 2) {
            sb.append("b");
            rec(sb, 0, 1, a, b - 1);
        }
        // If we have 2 consecutive b's, we must add a
        else if (consecutiveB == 2) {
            sb.append("a");
            rec(sb, 1, 0, a - 1, b);
        }
        // If we have more a's than b's, prefer adding a
        else if (a > b) {
            sb.append("a");
            rec(sb, consecutiveA + 1, 0, a - 1, b);
        }
        // If we have more b's than a's, prefer adding b
        else if (b > a) {
            sb.append("b");
            rec(sb, 0, consecutiveB + 1, a, b - 1);
        }
        // If equal, add the one that has fewer consecutive occurrences
        else {
            if (consecutiveA <= consecutiveB) {
                sb.append("a");
                rec(sb, consecutiveA + 1, 0, a - 1, b);
            } else {
                sb.append("b");
                rec(sb, 0, consecutiveB + 1, a, b - 1);
            }
        }
    }
}