# Sliding Window Problem Pattern Guide

## 1. Problem Identification
Key indicators that a problem requires the sliding window pattern:
- Involves processing/finding something among all **contiguous** subarrays/substrings of a specific size
- Keywords like "subarray", "substring", "window", "consecutive elements"
- The problem asks for minimum, maximum, or some calculation from a contiguous sequence
- Often deals with arrays or strings where ordering matters
- Common size requirements:
  - Fixed window size (k)
  - Variable window size with a constraint (sum less than k, etc.)

## 2. General Problem-Solving Steps

### For Fixed Window Size:
1. Initialize window sum/state with first k elements
2. Create window boundaries (start = 0, end = k-1)
3. Process result for first window
4. Slide window by one position:
   - Remove contribution of element at start
   - Add contribution of new element
   - Update result based on new window
5. Repeat steps until end reaches array boundary

### For Variable Window Size:
1. Start with empty window (start = end = 0)
2. Expand window by moving end pointer until window condition is violated
3. Contract window from start until condition is satisfied again
4. Update result if current window is valid
5. Repeat until end reaches array boundary

## 3. General Template Code

```java
// Fixed Window Size Template
public class Solution {
    public int fixedSlidingWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0) {
            return 0;
        }
        
        // Initialize first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int result = windowSum; // or other initial value based on problem
        
        // Slide window
        for (int end = k; end < arr.length; end++) {
            int start = end - k;
            windowSum = windowSum - arr[start] + arr[end];
            result = Math.max(result, windowSum); // or other operation
        }
        
        return result;
    }
    
    // Variable Window Size Template
    public int variableSlidingWindow(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int start = 0, windowSum = 0;
        int result = 0; // or other initial value
        
        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            
            // Contract window if condition is violated
            while (windowSum > target) {
                windowSum -= arr[start];
                start++;
            }
            
            // Update result if window is valid
            result = Math.max(result, end - start + 1);
        }
        
        return result;
    }
}
```

## 4. Common Variations

1. **Maximum Sum Subarray of Size K**
   - Modification: Track running sum
   - Focus: Simple accumulation and sliding

2. **First Negative in Every Window**
   - Modification: Use deque to track negative numbers
   - Focus: Maintaining order of elements

3. **Sliding Window Maximum**
   - Modification: Use deque to maintain decreasing sequence
   - Focus: Efficient maximum tracking

4. **Minimum Window Substring**
   - Modification: Use HashMap for frequency counting
   - Focus: Character frequency matching

5. **Longest Substring Without Repeating Characters**
   - Modification: Use HashSet/HashMap for uniqueness
   - Focus: Variable window with uniqueness constraint

## 5. Common Error Solutions

1. **Window Initialization**
   - Solution: Always verify if array length ≥ window size
   - Check for null arrays and invalid window sizes

2. **Window Sliding Logic**
   - Solution: Maintain proper window boundaries
   - Use end-k for start index calculation
   - Ensure window size remains constant

3. **Result Updates**
   - Solution: Update result after window is valid
   - Consider edge case of single-element windows

4. **Variable Window Size**
   - Solution: Contract window as soon as condition breaks
   - Update result only when window is valid

5. **Deque Operations**
   - Solution: Remove elements from front and back
   - Clean expired elements before adding new ones

## 6. Edge Cases to Consider

1. **Array/String Length Edge Cases**
   - Empty array/string
   - Array length smaller than window size
   - Single element array
   - Window size = 1 or array length

2. **Window Size Edge Cases**
   - k = 0
   - k = array length
   - k > array length

3. **Element Value Edge Cases**
   - All elements same
   - All elements different
   - Negative numbers
   - Zero elements
   - Maximum/Minimum integer values

4. **Window Movement Edge Cases**
   - First window
   - Last window
   - Single sliding step

5. **Data Type Edge Cases**
   - Integer overflow in sum calculations
   - Negative sums in circular arrays
   - Character encoding in string problems