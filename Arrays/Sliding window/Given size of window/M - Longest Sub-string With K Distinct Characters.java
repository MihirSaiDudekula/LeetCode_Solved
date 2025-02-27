// Problem statement
// You are given a string 'S' of length 'N' consisting of lowercase English alphabet letters. You are also given a positive integer 'K'.

// Now, a substring of this string is good if it contains at most 'K' distinct characters. A string 'X' is a substring of string 'Y' if it can be obtained by deletion of several continuous elements(possibly zero) from the beginning and the end from the string 'Y'.

// Your task is to return the maximum size of any good substring of the string 'S'.

// Example:
// ‘S’ = “bacda” and ‘K’ = 3.

// So, the substrings having at most ‘3’ distinct characters are called good substrings. Some possible good substrings are:
// 1. “bac”
// 2. “acd”
// 3. “acda”

// The substring “acda” is the largest possible good substring, as we cannot get any other substring of length 5 or more having distinct characters less than or equal to ‘3’. Thus, you should return ‘4’ as the answer.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= T <= 10
// 1 <= K <= 26
// 1 <= N <= 10^4

// All the characters of the string are lowercase English alphabet letters.

// Time Limit: 1 sec
// Sample Input 1:
// 2
// 2
// abcbc
// 1
// abccc
// Sample Output 1:
// 4
// 3
// Explanation For Sample Input 1:
// For the first test case :
// K = 2, so we can choose substring “bcbc” having 2 distinct character which is less than or equal to K = 2. 

// We cannot get any other substring of length 5 or more having distinct characters less than or equal to 2. Thus, you should return ‘4’ as the answer.

// For the second test case :
// K = 1, so we can choose substring “ccc” having only 1 distinct character which is less than or equal to K = 1. 

// We cannot get any other substring of length 4 or more having distinct characters less than or equal to 1. Thus, you should return ‘3’ as the answer.
// Sample Input 2:
// 1
// 6
// abcba
// 3
// acbdab
// Sample Output 2:
// 5
// 4

import java.util.* ;
import java.io.*; 

public class Solution {
    public static int getLengthofLongestSubstring(String s, int k) {
        // Write your code here.
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int curlen = 0;
        int maxlen = 0;
        int i = 0;

        for (int j = 0; j < c.length; j++) {

            map.put(c[j], map.getOrDefault(c[j], 0) + 1);


            while (map.size() > k) {
                
                map.put(c[i], map.get(c[i]) - 1);
                if (map.get(c[i]) == 0) {
                    map.remove(c[i]);
                }
                i++; 
            }

            if (map.size() <= k) {
                curlen = j - i + 1;
                maxlen = Math.max(maxlen, curlen);
            }
        }

        return maxlen;
    }
}
