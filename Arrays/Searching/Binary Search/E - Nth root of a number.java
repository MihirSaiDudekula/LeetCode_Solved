// Find Nth root of M
// EasyAccuracy: 25.06%Submissions: 105K+Points: 2
// Be the comment of the day in POTD and win a GfG T-Shirt!
// Solve right now

// banner
// You are given 2 numbers (n , m); the task is to find n√m (nth root of m).
 

// Example 1:

// Input: n = 2, m = 9
// Output: 3
// Explanation: 32 = 9
// Example 2:

// Input: n = 3, m = 9
// Output: -1
// Explanation: 3rd root of 9 is not
// integer.
 

// Your Task:
// You don't need to read or print anyhting. Your task is to complete the function NthRoot() which takes n and m as input parameter and returns the nth root of m. If the root is not integer then returns -1.
 

// Expected Time Complexity: O(n* log(m))
// Expected Space Complexity: O(1)
 

// Constraints:
// 1 <= n <= 30
// 1 <= m <= 109

class Solution
{
    /**
     * Determines the relationship between mid^N and m.
     * Returns:
     *   1 if mid^N == m
     *   0 if mid^N < m
     *   2 if mid^N > m
     */
    public int checkRelationship(int mid, int n, int m) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= mid;
            if (result > m) {
                return 2;
            }
        }
        if (result == m) {
            return 1;
        } else {
            return 0;
        }
    }
    public int NthRoot(int n, int m)
    {
        // code here
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int relationship = checkRelationship(mid, n, m);
            if (relationship == 1) {
                return mid;
            } else if (relationship == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // No exact nth root found
    }
}
