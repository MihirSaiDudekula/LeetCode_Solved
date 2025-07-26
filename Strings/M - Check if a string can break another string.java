// 1433. Check If a String Can Break Another String
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given two strings: s1 and s2 with the same size, check if some permutation of string s1 can break some permutation of string s2 or vice-versa. In other words s2 can break s1 or vice-versa.

// A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for all i between 0 and n-1.

 

// Example 1:

// Input: s1 = "abc", s2 = "xya"
// Output: true
// Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc" which is a permutation of s1="abc".
// Example 2:

// Input: s1 = "abe", s2 = "acd"
// Output: false 
// Explanation: All permutations for s1="abe" are: "abe", "aeb", "bae", "bea", "eab" and "eba" and all permutation for s2="acd" are: "acd", "adc", "cad", "cda", "dac" and "dca". However, there is not any permutation from s1 which can break some permutation from s2 and vice-versa.
// Example 3:

// Input: s1 = "leetcodee", s2 = "interview"
// Output: true
 

// Constraints:

// s1.length == n
// s2.length == n
// 1 <= n <= 10^5
// All strings consist of lowercase English letters.

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) 
    {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        boolean forward = checkEach(c1,c2);
        boolean backward = checkEach(c2,c1);
        System.out.println(forward);
        System.out.println(backward);
        return forward || backward;

    }
    public boolean checkEach(char[] c1,char[] c2)
    {
        boolean flag = true;
        for(int i=0;i<c1.length;i++)
        {
            int id1 = c1[i]-'a';
            // System.out.println(id1);

            int id2 = c2[i]-'a';
            // System.out.println(id2);

            if(id1>id2)
            {
                flag = false;
                break;
            }
        }
        return flag;
    }
}