# Binary Search: A Complete Problem-Solving Framework

## 1. Problem Identification

Binary search problems often present themselves in several distinct ways. Understanding these indicators helps us quickly recognize when to apply this algorithm.

### Primary Indicators
The problem likely requires binary search when you encounter:

A sorted array or partially sorted array is involved in the problem statement. This is the most fundamental requirement, as binary search leverages the ordering property to achieve logarithmic time complexity.

The problem asks you to find something specific, such as:
- A particular value or position
- The first or last occurrence of an element
- A value that satisfies certain conditions
- The closest value to a target
- The minimum or maximum value meeting some criteria

The problem constraints suggest the need for O(log n) time complexity, typically when:
- The input size is large (e.g., 10^5 or greater)
- The problem explicitly asks for an optimized solution
- A linear scan would be too slow

### Secondary Indicators
Look for these phrases in the problem statement:
- "Find the minimum/maximum value that satisfies..."
- "Find the kth element..."
- "Find the closest element to..."
- "Find in rotated sorted array..."
- "Count occurrences of..."

## 2. General Problem-Solving Steps

### Step 1: Define the Search Space
First, identify what you're searching for and the range of possible values. The search space might be:
- Index positions in the array (0 to length-1)
- Actual values in a range (e.g., minimum to maximum possible value)
- Answers to an optimization problem (e.g., minimum to maximum possible result)

### Step 2: Establish the Search Condition
Define how you'll determine if a middle value is:
- The answer you're looking for
- Too high (should search left)
- Too low (should search right)

This condition must be monotonic, meaning the search space can be clearly divided into two parts where one part satisfies the condition and the other doesn't.

### Step 3: Choose Search Boundaries
Decide whether to:
- Include both boundaries (left <= right)
- Exclude the right boundary (left < right)
- Handle special cases at the boundaries

---

### Summary Table of Boundary Conditions:

| Scenario                           | Condition           | Explanation |
|-------------------------------------|---------------------|-------------|
| Standard binary search for an element | `left <= right`      | Search checks both left and right boundaries until they converge. |
| Finding the first occurrence of a target or insertion point | `left < right` | Excludes the right boundary to ensure the search space narrows down correctly. |
| Special cases at the boundaries (e.g., single-element, edge cases) | Varies | Explicit boundary checks for edge cases. Ensure correct behavior for arrays of length 1, empty arrays, or elements at boundaries. |


### Step 4: Implement the Core Logic
Write the binary search loop with careful attention to:
- How the middle point is calculated
- How boundaries are updated
- When and how potential answers are stored
- The loop termination condition `low > high`

### Step 5: Handle Edge Cases
Consider and handle special situations like:
- Empty array
- Single element array
- Element not present
- Duplicate elements
- Boundary values

## 3. General Template (Java)

```java
public class BinarySearch {
    public int search(int[] nums, int target) {
        // Step 1: Initialize boundaries
        int left = 0;
        int right = nums.length - 1;
        
        // Optional: Store potential answer
        int result = -1;
        
        // Step 2: Binary search loop
        while (left <= right) {  // Or left < right based on problem
            // Calculate middle point safely
            int mid = left + (right - left) / 2;
            
            // Step 3: Check current position
            if (checkCondition(nums, mid, target)) {
                // Found potential answer
                result = mid;  // Store if needed
                // Move boundary based on if we need first/last occurrence
                right = mid - 1;  // For first occurrence
                // OR: left = mid + 1;  // For last occurrence
            }
            // Step 4: Move boundaries based on comparison
            else if (shouldMoveLeft(nums, mid, target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    // Define problem-specific conditions
    private boolean checkCondition(int[] nums, int mid, int target) {
        // Implement based on problem requirements
        return nums[mid] == target;
    }
    
    private boolean shouldMoveLeft(int[] nums, int mid, int target) {
        // Implement based on problem requirements
        return nums[mid] > target;
    }
}
```

## 4. Common Variations and Their Modifications

### First/Last Occurrence
Modification: Store the found index but continue searching in one direction
```java
if (nums[mid] == target) {
    result = mid;
    right = mid - 1;  // For first occurrence
    // OR: left = mid + 1;  // For last occurrence
}
```

### Floor/Ceiling
Modification: Update result when finding a valid candidate
```java
// For floor (greatest element ≤ target)
if (nums[mid] <= target) {
    result = nums[mid];
    left = mid + 1;
}
```

### Rotated Sorted Array
Modification: Add logic to determine which half is sorted
```java
if (nums[left] <= nums[mid]) {  // Left half is sorted
    if (nums[left] <= target && target < nums[mid]) {
        right = mid - 1;
    } else {
        left = mid + 1;
    }
}
```

### Answer Search Problems
Modification: Binary search on answer space instead of array indices
```java
int left = minPossibleAnswer;
int right = maxPossibleAnswer;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (isValid(mid)) {
        result = mid;
        // Move boundary based on whether we want min or max
        right = mid - 1;  // For minimum valid answer
        // OR: left = mid + 1;  // For maximum valid answer
    }
}
```

## 5. Common Error Solutions

### Off-by-One Errors
Solution: Always use consistent boundary handling
- Use `left <= right` when searching for an exact value
- Use `left < right` when searching for a boundary (like first or last occurrences)
- Always update `mid + 1` or `mid - 1`, never just `mid`

### Integer Overflow
Solution: Calculate middle point safely
```java
int mid = left + (right - left) / 2;  // Instead of (left + right) / 2
```

### Infinite Loops
Solution: Ensure boundary updates always change mid
- Always move boundaries to exclude mid
- Verify loop termination condition matches boundary updates

### Missing Answers
Solution: Store potential answers when found
```java
if (isValid(mid)) {
    result = mid;  // Store before continuing search
    // Then update boundaries
}
```

## 6. Critical Edge Cases

1. Empty Array
```java
if (nums == null || nums.length == 0) {
    return -1;
}
```

2. Single Element
- Verify loop conditions work with array size 1
- Check boundary updates don't skip the element

3. All Duplicate Elements
- Ensure boundary updates handle duplicates correctly
- Test if first/last occurrence logic works

4. Target Not Present
- Initialize result to appropriate default value
- Handle cases where target is outside array range

5. Boundary Values
- Test with minimum and maximum possible values
- Verify integer overflow handling

6. Rotated Array Special Cases
- Array not actually rotated (sorted)
- Rotation point at start or end
- Duplicates at rotation point

Remember to always test your solution with these edge cases before submitting.