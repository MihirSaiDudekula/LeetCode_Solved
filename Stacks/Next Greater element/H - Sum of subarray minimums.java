// 907. Sum of Subarray Minimums
// Medium
// Topics
// Companies
// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

// Example 1:

// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.

import java.util.Stack;

public class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        
        // Arrays to store Previous Less Element (PLE) and Next Less Element (NLE)
        int[] PLE = new int[n];
        int[] NLE = new int[n];
        
        // Initialize PLE and NLE
        for (int i = 0; i < n; i++) {
            PLE[i] = -1;
            NLE[i] = n;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        // Calculate PLE for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                PLE[i] = stack.peek();
            }
            stack.push(i);
        }
        
        stack.clear();
        
        // Calculate NLE for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                NLE[i] = stack.peek();
            }
            stack.push(i);
        }
        
        // Calculate the result using PLE and NLE
        long result = 0;
        for (int i = 0; i < n; i++) {
            long leftCount = i - PLE[i];
            // leftCount is The number of elements to the left of arr[i] that can form subarrays with arr[i] as the minimum. This is given by the difference between the current index i and the index of the PLE, PLE[i].

            long rightCount = NLE[i] - i;
            result = (result + arr[i] * leftCount * rightCount) % MOD;
            // For each element arr[i], calculate the total number of subarrays where it is the minimum by multiplying leftCount and rightCount.
			// The contribution of arr[i] to the overall sum is then arr[i] * leftCount * rightCount.
			// Sum these contributions for all elements
        }
        
        return (int) result;
    }
}
