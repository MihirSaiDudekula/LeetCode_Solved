// Generate all binary strings
// Difficulty: MediumAccuracy: 71.74%Submissions: 8K+Points: 4
// Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

// A binary string is that string which contains only 0 and 1.

// Example 1:

// Input:
// N = 3
// Output:
// 000 , 001 , 010 , 100 , 101
// Explanation:
// None of the above strings contain consecutive 1s. "110" is not an answer as it has '1's occuring consecutively. 
// Your Task:

// You don't need to read input or print anything. Your task is to complete the function generateBinaryStrings() which takes an integer N as input and returns a list of all valid binary strings in lexicographically increasing order.

// Expected Time Complexity: O(2N)
// Expected Auxiliary Space: O(N)

// Constraints:
// 1 <= N <= 20

class Solution {
    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        char[] array = new char[n];
        // char array so that we can easily acsess last element and append to fixed length string 
        array[0] = '0';
        // second parameter = 1 = index = indicates index of \0 char
        // although we should note that theres no \0 in the array 
        generateStrings(n, 1, array, result);
        array[0] = '1';
        generateStrings(n, 1, array, result);
        return result;
    }

    public static void generateStrings(int n, int index, char[] array, List<String> result) 
    {
        if (index == n) {
            result.add(new String(array)); 
            // Convert char array to String, toString() wont work
            return;
        }
        
        if(array[index-1]=='0')
        {
            // Choose '0'
            array[index] = '0';
            generateStrings(n, index + 1, array, result);
    
            // Choose '1'
            array[index] = '1';
            generateStrings(n, index + 1, array, result);
        }
        if(array[index-1]=='1')
        {
            // Choose '0'
            array[index] = '0';
            generateStrings(n, index + 1, array, result);
        }
    }
}

//far better soln
class Solution {
    public List<String> validStrings(int n) {
        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        rec(l, 0, sb, n);
        rec(l, 1, sb, n);
        return l;
    }
    
    public void rec(List<String> l, int dig, StringBuilder cur, int n) {
        // Append the digit
        cur.append(dig);
        
        // Check if we've reached the target length
        if(cur.length() == n) {
            l.add(cur.toString());
        } else {
            // Continue recursion if not at target length
            if(dig == 0) {
                rec(l, 1, cur, n);
            } else if(dig == 1) {
                rec(l, 0, cur, n);
                rec(l, 1, cur, n);
            }
        }
        
        // CRITICAL: Remove the digit we added before returning
        // This is backtracking - undo the change we made in this call
        cur.deleteCharAt(cur.length() - 1);
    }
}