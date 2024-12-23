# Array Swapping/Moving Elements Pattern Guide

## 1. Problem Identification
Key indicators that a problem requires the array swapping pattern:
- Need to rearrange array elements in-place
- Keywords like "sort", "move", "rearrange", "in-place"
- Memory constraint of O(1)
- Problems involving:
  - Moving certain elements to end/beginning
  - Grouping similar elements together
  - Cyclic sort (numbers from 1 to N)
  - Color sorting (limited distinct values)
- Often asks to modify original array without extra space

## 2. General Problem-Solving Steps

### For Two-Way Partitioning:
1. Initialize two pointers (typically left and right)
2. Move left pointer until finding an element to swap
3. Move right pointer until finding an element to swap
4. Swap elements and continue
5. Stop when pointers meet

### For Three-Way Partitioning:
1. Initialize three pointers (low, mid, high)
2. Process middle section with mid pointer
3. Swap elements to appropriate section
4. Adjust relevant pointers
5. Continue until mid crosses high

### For Cyclic Sort:
1. Start from beginning of array
2. Place current element in its correct position
3. Get new element from swap
4. Continue until element is in correct position
5. Move to next index


Two-way partitioning

The code you're showing is implementing a "two-way partition" for an array of integers, specifically focusing on a common pattern for segregating elements (like separating zeros from non-zeros). Here's a breakdown of what it's trying to do:

### Function Explanation:

- **Purpose**: This method (`twoWayPartition`) is designed to rearrange elements in an array `nums[]` such that all non-zero elements are moved to the left side and all zero elements are moved to the right side. The method uses two pointers (`left` and `right`) to do this in a single pass.

### Step-by-Step Breakdown:

1. **Initialization**: 
   - Two pointers are initialized, `left = 0` and `right = 0`.
   - `left` will be used to track where the next non-zero element should go.
   - `right` will be used to scan through the array.

2. **Main Loop**:
   - The loop runs while `right < nums.length`, ensuring that every element of the array is checked.

3. **Checking Non-Zero Elements**:
   - Inside the loop, there's a check `if (nums[right] != 0)`:
     - This means we are looking for non-zero elements in the array.
     - When we find a non-zero element, we want to ensure it is placed in the correct position (which is the left part of the array).

4. **Swapping Elements**:
   - If the element at `right` is non-zero, the code checks if `left != right`. This check ensures that a swap only happens when necessary (i.e., only if `left` is pointing to a position where a zero exists and `right` is pointing to a non-zero).
     - If `left != right`, the `swap(nums, left, right)` function swaps the elements at the `left` and `right` positions.
   
5. **Incrementing the Pointers**:
   - After processing each element, `left++` is incremented to indicate the next potential position for a non-zero element.
   - `right++` is incremented to continue checking the rest of the array.

6. **End Result**:
   - At the end of the loop, all non-zero elements will have been moved to the front of the array, and all zero elements will have been pushed to the end, while maintaining the relative order of non-zero elements.

### Example Walkthrough:

Given the input:
```java
nums = [0, 1, 0, 3, 12]
```

- Initially: `left = 0`, `right = 0`
- Iteration 1: `nums[right] = 0`, so no swap. Move `right++`.
- Iteration 2: `nums[right] = 1` (non-zero). Swap `nums[left]` with `nums[right]`, so now `nums = [1, 0, 0, 3, 12]`. `left++` and `right++`.
- Iteration 3: `nums[right] = 0`, so no swap. Move `right++`.
- Iteration 4: `nums[right] = 3` (non-zero). Swap `nums[left]` with `nums[right]`, so now `nums = [1, 3, 0, 0, 12]`. `left++` and `right++`.
- Iteration 5: `nums[right] = 12` (non-zero). Swap `nums[left]` with `nums[right]`, so now `nums = [1, 3, 12, 0, 0]`. `left++` and `right++`.

Final output: `[1, 3, 12, 0, 0]`, with all non-zero elements at the front and zero elements at the end.

### Key Points:
- **Efficiency**: The method runs in **O(n)** time complexity because it makes a single pass through the array (`right++` moves from 0 to `nums.length - 1`).
- **In-place operation**: The method does not require extra space because the swapping is done in place.
- **Non-zero order preserved**: The relative order of the non-zero elements is maintained throughout the process.


## 3. General Template Code

```java
public class Solution {
    // Two-Way Partitioning Template (e.g., Move Zeroes)
    public void twoWayPartition(int[] nums) {
        int left = 0, right = 0;
        
        while (right < nums.length) {
            if (nums[right] != 0) {  // condition varies by problem
                // Swap only if pointers are different
                if (left != right) {
                    swap(nums, left, right);
                }
                left++;
            }
            right++;
        }
    }
    
    // Three-Way Partitioning Template (e.g., Sort Colors)
    public void threeWayPartition(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }
    
    // Cyclic Sort Template (e.g., Find Missing Numbers)
    public void cyclicSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;  // correct position
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

## 4. Common Variations

1. **Move Zeroes**
   - Modification: Two-way partition with non-zero elements
   - Focus: Maintaining relative order

2. **Sort Colors (Dutch Flag)**
   - Modification: Three-way partition
   - Focus: Handling three distinct values

3. **Find Disappeared Numbers**
   - Modification: Cyclic sort with marking
   - Focus: Using index as hash table

4. **Remove Duplicates**
   - Modification: Two pointers with overwriting
   - Focus: Maintaining unique elements

5. **Partition Array**
   - Modification: Two-way partition with pivot
   - Focus: Elements relative to pivot value

## 5. Common Error Solutions

1. **Unnecessary Swaps**
   - Solution: Check if indices are different before swapping
   - Only swap when necessary
   - Consider element equality

2. **Pointer Movement**
   - Solution: Carefully increment/decrement pointers
   - Consider when to move which pointer
   - Handle boundary cases

3. **Element Ordering**
   - Solution: Consider if relative order matters
   - Use appropriate swapping strategy
   - Handle duplicate elements correctly

4. **Cyclic Dependencies**
   - Solution: Break cycles in cyclic sort
   - Handle elements that form cycles
   - Consider element ranges

5. **Boundary Handling**
   - Solution: Validate array indices
   - Handle array boundaries properly
   - Check for out-of-range elements

## 6. Edge Cases to Consider

1. **Array Content**
   - Empty array
   - Single element array
   - All elements same
   - All elements different
   - Already sorted array

2. **Element Values**
   - Negative numbers
   - Zero values
   - Maximum integer values
   - Duplicates
   - Missing elements

3. **Array Size**
   - Very small arrays (0-2 elements)
   - Large arrays
   - Power of 2 sized arrays
   - Prime sized arrays

4. **Element Order**
   - Reverse sorted
   - Nearly sorted
   - Randomly ordered
   - Partially sorted

5. **Special Patterns**
   - Alternating elements
   - Repeating patterns
   - Palindromic arrays
   - Cyclic arrays
   - Rotated arrays