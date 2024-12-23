# Variable-Sized Sliding Window Pattern Guide

## 1. Problem Identification
Key indicators that a problem requires the variable-sized sliding window pattern:
- Need to find a **contiguous** subarray/substring that satisfies certain conditions
- Keywords like "longest", "shortest", "contains", "at most k"
- Problems involving dynamic window size based on conditions
- Often includes optimization requirements (maximum/minimum length)
- Common conditions:
  - Sum equals/less than/greater than k
  - Maximum allowed frequency of elements
  - Distinct elements constraint
  - Optimization with constraints

## 2. General Problem-Solving Steps

1. Initialize window boundaries (start = 0, end = 0)
2. Initialize window state tracking variables:
   - Running sum for sum-based problems
   - HashMap for frequency-based problems
   - Counter for violation checking
3. Expand window (move end pointer):
   - Add new element to window state
   - Update relevant counters/sums
4. Contract window (move start pointer) when:
   - Window condition is violated
   - Need to find minimum window
5. Update result when window is valid
6. Continue until end reaches array boundary

## 3. General Template Code

```java
public class Solution {
    // Template for sum-based problems
    public int sumBasedWindow(int[] arr, int targetSum) {
        int start = 0, currSum = 0;
        int maxLen = 0; // or other result variable
        
        for (int end = 0; end < arr.length; end++) {
            currSum += arr[end];
            
            // Contract window while condition is violated
            while (start <= end && currSum > targetSum) {
                currSum -= arr[start];
                start++;
            }
            
            // Update result if window is valid
            if (currSum == targetSum) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }
        
        return maxLen;
    }
    
    // Template for frequency-based problems
    public int frequencyBasedWindow(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int start = 0, maxLen = 0;
        int distinctCount = 0; // or other constraint counter
        
        for (int end = 0; end < arr.length; end++) {
            // Add new element to window
            freqMap.put(arr[end], freqMap.getOrDefault(arr[end], 0) + 1);
            if (freqMap.get(arr[end]) == 1) distinctCount++;
            
            // Contract window while condition is violated
            while (distinctCount > k) {
                freqMap.put(arr[start], freqMap.get(arr[start]) - 1);
                if (freqMap.get(arr[start]) == 0) {
                    distinctCount--;
                    freqMap.remove(arr[start]);
                }
                start++;
            }
            
            // Update result
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}
```

## 4. Common Variations

1. **Longest Subarray with Sum K**
   - Modification: Track running sum
   - Variation: Sum less than or equal to K
   - Key: Handle negative numbers with HashMap

2. **Maximum Consecutive Ones III**
   - Modification: Count zeros and allow K flips
   - Focus: Frequency of zeros tracking

3. **Longest Substring with At Most K Distinct Characters**
   - Modification: Use HashMap for character frequency
   - Focus: Distinct elements count

4. **Minimum Window Substring**
   - Modification: Use two HashMaps for pattern matching
   - Focus: Minimum valid window tracking

5. **Kadane's Algorithm (Maximum Subarray Sum)**
   - Modification: Dynamic window size based on sum
   - Focus: Reset window when sum becomes negative

## 5. Common Error Solutions

1. **Window State Management**
   - Solution: Properly update all state variables
   - Keep window state and actual window synchronized
   - Clear/reset state when window contracts

2. **Window Contraction**
   - Solution: Contract window while condition is violated
   - Use while loop instead of if condition
   - Update all relevant counters during contraction

3. **Result Updates**
   - Solution: Update result after window becomes valid
   - Consider both current and previous valid windows
   - Handle edge case of empty result

4. **Negative Numbers Handling**
   - Solution: Use HashMap for sum-based problems
   - Consider prefix sum for certain variations
   - Handle overflow cases

5. **Zero-Length Window**
   - Solution: Allow zero-length window if needed
   - Handle empty window state properly
   - Consider minimum window size requirements

## 6. Edge Cases to Consider

1. **Array Content Edge Cases**
   - All elements same
   - All elements different
   - Array contains zeros/negative numbers
   - Empty array
   - Single element array

2. **Sum-Related Edge Cases**
   - Target sum = 0
   - Sum equals array element
   - Negative target sum
   - Maximum integer overflow
   - No valid subarray exists

3. **Window Size Edge Cases**
   - Window size = array length
   - Window size = 1
   - No valid window exists
   - Multiple valid windows
   - Equal length valid windows

4. **Frequency-Related Edge Cases**
   - K = 0
   - K = number of unique elements
   - K > number of unique elements
   - Single character/element frequency

5. **Special Conditions**
   - Empty string/array input
   - Null input
   - All constraints satisfied initially
   - No possible solution exists
   - Multiple optimal solutions