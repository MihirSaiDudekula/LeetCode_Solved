// 1297. Maximum Number of Occurrences of a Substring
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a string s, return the maximum number of occurrences of any substring under the following rules:

// The number of unique characters in the substring must be less than or equal to maxLetters.
// The substring size must be between minSize and maxSize inclusive.
 

// Example 1:

// Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
// Output: 2
// Explanation: Substring "aab" has 2 occurrences in the original string.
// It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
// Example 2:

// Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
// Output: 2
// Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 

// Constraints:

// 1 <= s.length <= 105
// 1 <= maxLetters <= 26
// 1 <= minSize <= maxSize <= min(26, s.length)
// s consists of only lowercase English letters.

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        for(int i=0;i<=n-minSize;i++){ // if n=4, minsize = 3 then substr can start till idx 1 since 4-3=1
            int[] arr = new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'a']++;
                int count = 0;
                for(int x : arr){
                    if(x!=0){
                        count++;
                    }
                }
                if(count>maxLetters || j-i+1>maxSize){
                    break;
                }
                if(j-i+1>=minSize){
                    String str = s.substring(i,j+1);
                    map.put(str,map.getOrDefault(str,0)+1);
                    ans = Math.max(map.get(str),ans);
                }
            }
        }
        return ans;
    }
}