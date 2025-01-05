# Arrays

### Set Matrix Zero
Create two boolean arrays, rowZero and colZero, to track which rows and columns need to be set to zero.

Traverse the matrix and for each element that is zero, mark the corresponding row and column in rowZero and colZero.

After marking, loop through the matrix again and set elements to zero if their corresponding row or column is marked in the extra arrays.

### Next Permutation
Find the breaking point: Traverse the array from the end to the beginning and find the first pair where the current number is smaller than the next number (i.e., nums[i] < nums[i+1]). This is the "breaking point," and it indicates the position where the permutation needs to be increased.

Find the smallest number greater than nums[i]: Once the breaking point is found, search for the smallest number greater than nums[i] to the right of i. This can be done by scanning the array from the end to i+1.Do this coz we want the next perm to be smallest and immedeate next instead if a faraway perm.

Swap and reverse: Swap the numbers found in steps 1 and 2. Finally, reverse the subarray after index i to ensure the next permutation is the smallest possible greater permutation.

### Sort colors - Dutch National Flag
uses three pointers: `low`, `mid`, and `high`. 

1. **Low** tracks where the next 0 should go, and **High** tracks where the next 2 should go.
2. **Mid** traverses the array, and depending on the value at `nums[mid]`:
   - If it's 0, it's swapped with `nums[low]` as then both will be correctly positioned. both `low` and `mid` are incremented as both posns are processed.
   - If it's 1, it's already in the right place, so only `mid` is incremented as mid need not make any swap there.
   - If it's 2, By swapping nums[mid] with nums[high], we place the 2 at the end, but since we don’t know what the new nums[mid] is (it could be a 0, 1, or another 2), we do not increment mid immediately.Instead, we decrement high to ensure that 2 is correctly positioned at the end, but mid must be checked again with the new value at nums[mid], which could potentially need further action

3. The process continues until `mid` exceeds `high`, ensuring all elements are in their correct positions.

# Rotate matrix
 You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

1. Transpose the matrix
2. reverse each row of the matrix

# Merge intervals
1. **Sort the intervals** by their start time to ensure they are processed in chronological order.
   - The intervals are added to a `PriorityQueue

2. **Iterate through the sorted intervals**, 

3. If intervals overlap, **update the end time** of the current interval; if not, **add the current interval** to the result list and move to the next.
   - If the start time of the next interval is within the current interval (`next[0] <= current[1]`), we merge them by updating the end time (`current[1] = Math.max(current[1], next[1])`), otherwise, we add `current` to the result.

4. After processing all intervals, **return the merged intervals** as the final result.


# Merge sorted arrays without extra space
1. **Initialize pointers** to the last elements of both arrays and the end of the merged array - the greatest elements in both arrays

   - `i` starts at the last index of `nums1`, `j` starts at the last index of `nums2`, and `k` points to the last index of the merged array (`nums1`).

2. **Compare elements from both arrays** starting from the end, and place the larger element at the end of `nums1`.
   - In a while loop, compare `nums1[i]` and `nums2[j]`, and place the larger element at the `k`-th position of `nums1`, then decrement the corresponding pointer (`i`, `j`, or `k`).

3. **Handle any remaining elements** in `nums1` if `nums2` has been exhausted.
   - If `j` has reached -1 (i.e., `nums2` is exhausted), but `i` still has valid elements, continue moving the elements of `nums1` to the front.


5. **The merged array is now in `nums1`**



