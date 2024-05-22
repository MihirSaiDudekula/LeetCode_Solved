// Count Occurences of Anagrams
// MediumAccuracy: 48.09%Submissions: 73K+Points: 4
// Find better job opportunities this summer via Job-A-Thon Hiring Challenge!

// banner
// Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.

// Example 1:

// Input:
// txt = forxxorfxdofr
// pat = for
// Output: 3
// Explanation: for, orf and ofr appears
// in the txt, hence answer is 3.
// Example 2:

// Input:
// txt = aabaabaa
// pat = aaba
// Output: 4
// Explanation: aaba is present 4 times
// in txt.
// Your Task:
// Complete the function search() which takes two strings pat, txt, as input parameters and returns an integer denoting the answer. 
// You don't need to print answer or take inputs.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(26) or O(256)

// Constraints:
// 1 <= |pat| <= |txt| <= 105
// Both strings contain lowercase English letters.

class Solution {
    
    int[] lcw = new int[26];
    int[] lcs = new int[26];

    int search(String pat, String txt) {
        char[] word = txt.toCharArray();
        char[] subs = pat.toCharArray();
        
        int N = word.length;
        int k = subs.length;
        
        // Initialize the counts for the pattern characters
        for (char c : subs) {
            increment(lcw, c);
        }
        
        // Initialize the counts for the first k characters in the text
        for (int i = 0; i < k; i++) {
            increment(lcs, word[i]);
        }
        
        // Count of anagrams found
        int count = 0;
        if (areEq(lcw, lcs)) {
            count++;
        }
        
        // Slide the window over the text and check for anagrams
        for (int i = k; i < N; i++) {
            increment(lcs, word[i]);
            decrement(lcs, word[i - k]);
            if (areEq(lcw, lcs)) {
                count++;
            }
        }
        
        return count;
    }
    
    void increment(int[] arr, char x) {
        arr[x - 'a']++;
    }
    
    void decrement(int[] arr, char x) {
        arr[x - 'a']--;
    }
    
    boolean areEq(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
