// Reverse array in groups of K

// Given an array arr[] of positive integers of size N. Reverse every sub-array group of size K.

// Note: If at any instance, there are no more subarrays of size greater than or equal to K, then reverse the last subarray (irrespective of its size). You shouldn't return any array, modify the given array in-place.

// Example 1:

// Input:
// N = 5, K = 3
// arr[] = {1,2,3,4,5}
// Output: 3 2 1 5 4
// Explanation: First group consists of elements
// 1, 2, 3. Second group consists of 4,5.
 

// Example 2:

// Input:
// N = 4, K = 3
// arr[] = {5,6,8,9}
// Output: 8 6 5 9
 

// Your Task:
// You don't need to read input or print anything. The task is to complete the function reverseInGroups() which takes the array, N and K as input parameters and modifies the array in-place. 

 

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

 

// Constraints:
// 1 ≤ N, K ≤ 107
// 1 ≤ A[i] ≤ 1018

//APPROACH

// Calculate the number of full groups: grps = n / k.
// This tells us how many complete groups of size k can be formed within the ArrayList.
// Calculate the remaining elements after forming full groups: rem = n % k.
// This tells us how many elements are left after forming all complete groups.
// Iterate over each complete group:
// Use a loop to iterate grps times.
// For each iteration i, reverse the sub-array from index i * k to (i + 1) * k - 1. This effectively reverses each group.
// Reverse the remaining elements:
// After processing all complete groups, there might be remaining elements if rem > 0.
// Reverse the remaining elements from index k * grps to n - 1.
// This approach ensures that each group of size k is reversed while handling any remaining elements at the end of the ArrayList.

class Solution {
    // Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        int grps = n / k;
        int rem = n % k;
        for (int i = 0; i < grps; i++) {
            reverse(arr, (i * k), ((i + 1) * k) - 1);
        }
        reverse(arr, (k * grps), n - 1); 
    }

    void reverse(ArrayList<Integer> arr, int s, int e) {
        while (s < e) {
            int temp = arr.get(s); 
            arr.set(s, arr.get(e)); 
            arr.set(e, temp); 

            s++;
            e--;
        }
    }
}




