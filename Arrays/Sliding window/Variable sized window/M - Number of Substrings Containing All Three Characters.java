// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

// Example 1:

// Input: s = "abcabc"
// Output: 10
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
// Example 2:

// Input: s = "aaacb"
// Output: 3
// Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
// Example 3:

// Input: s = "abc"
// Output: 1
 

// Constraints:

// 3 <= s.length <= 5 x 10^4
// s only consists of a, b or c characters

class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0};
        int left = 0;
        int total = 0;
        for(int right=0; right < s.length(); right++){
            count[s.charAt(right) - 'a']++;

            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                total += s.length() - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return total;
    }
}