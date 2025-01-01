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


