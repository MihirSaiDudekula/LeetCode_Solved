// Permutations of a given string
// Difficulty: MediumAccuracy: 34.65%Submissions: 267K+Points: 4
// Given a string S. The task is to print all unique permutations of the given string that may contain dulplicates in lexicographically sorted order. 

// Example 1:

// Input: ABC
// Output:
// ABC ACB BAC BCA CAB CBA
// Explanation:
// Given string ABC has permutations in 6 
// forms as ABC, ACB, BAC, BCA, CAB and CBA .
// Example 2:

// Input: ABSG
// Output:
// ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
// BASG BGAS BGSA BSAG BSGA GABS GASB 
// GBAS GBSA GSAB GSBA SABG SAGB SBAG 
// SBGA SGAB SGBA
// Explanation:
// Given string ABSG has 24 permutations.
// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function find_permutation() which takes the string S as input parameter and returns a vector of string in lexicographical order.

// Expected Time Complexity: O(n! * n)
// Expected Space Complexity: O(n! * n)

// Constraints:
// 1 <= length of string <= 5

class Solution {
    public List<String> find_permutation(String S) {

        Set<String> permsSet = new TreeSet<>();
        // In this uestion the order in which the elements are geberated are of importance
        //if any character is repeated, it will cause generation of repeated results, ex: if instead of A,B,C we are given A,B,B the result BAB will be generated twice.
        //to avoid that we use a set
        //but a hashset doesn't maintain any specific order while storing
        // so we use something called a treeset which is a set thet stores in order of appearence of item
        List<String> perms = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return perms;
        }
        allPerm(permsSet, "", S);
        for(String x:permsSet)
        {
            perms.add(x);
        }
        return perms;
    }

    private void allPerm(Set<String> l, String current, String remaining) {
        if (remaining.isEmpty()) {
            l.add(current);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            char letter = remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            allPerm(l, current + letter, newRemaining);
        }
    }
}

