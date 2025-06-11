// Longest Sub-Array with Sum K
// MediumAccuracy: 24.64%Submissions: 275K+Points: 4
// Be the comment of the day in POTD and win a GfG T-Shirt!
// Solve right now

// banner
// Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

// Example 2:

// Input : 
// A[] = {-1, 2, 3}
// K = 6
// Output : 0
// Explanation: 
// There is no such sub-array with sum 6.

 import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // base case: sum of 0 has occurred once

        for (int num : nums) {
            sum += num;

            if (prefixSumFreq.containsKey(sum - k)) {
                count += prefixSumFreq.get(sum - k);
            }

            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

