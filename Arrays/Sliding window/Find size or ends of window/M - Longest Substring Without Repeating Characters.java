// Given a string s, find the length of the longest 
// substring
//  without repeating characters.

 

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int max = 0; 
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (hs.contains(s.charAt(j))) {
                    break;
                }
                hs.add(s.charAt(j));
            }
            max = Math.max(max, hs.size());
        }
        return max;
    }
}

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int max = 0; 
        int j=-1;
        HashMap<Character,Integer> map = new HashMap<>();
        
        int i = 0;
        // map.put(s.charAt(0),0);
        map.put(s.charAt(i),i);

        // for(int i=0;i<s.length();i++)
        while(i<s.length())
        {
        	j=i+1;
        	while(j<s.length() && !map.contains(s.charAt(j)))
        	{
        		map.put(s.charAt(j),j);
        		j++;
        	}
        	max = Math.max(max,j-i);
        	i = map.get(s.charAt(j));
        }

        return max;
    }
}

// cooler, more optimal, better mindblowing solution

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;  
        int i = 0;  

        for (int j = 0; j < s.length(); j++) {

            if (map.containsKey(s.charAt(j))) {

                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }

            map.put(s.charAt(j), j);
            // Updates an existing entry in the HashMap or inserts a new entry if the key (s.charAt(j)) does not already exist in the map.

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}