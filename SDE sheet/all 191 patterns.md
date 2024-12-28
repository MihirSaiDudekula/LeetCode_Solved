# Arrays

### Set Matrix Zero
Create two boolean arrays, rowZero and colZero, to track which rows and columns need to be set to zero.

Traverse the matrix and for each element that is zero, mark the corresponding row and column in rowZero and colZero.

After marking, loop through the matrix again and set elements to zero if their corresponding row or column is marked in the extra arrays.

### Next Permutation
Find the breaking point: Traverse the array from the end to the beginning and find the first pair where the current number is smaller than the next number (i.e., nums[i] < nums[i+1]). This is the "breaking point," and it indicates the position where the permutation needs to be increased.

Find the smallest number greater than nums[i]: Once the breaking point is found, search for the smallest number greater than nums[i] to the right of i. This can be done by scanning the array from the end to i+1.Do this coz we want the next perm to be smallest and immedeate next instead if a faraway perm.

Swap and reverse: Swap the numbers found in steps 1 and 2. Finally, reverse the subarray after index i to ensure the next permutation is the smallest possible greater permutation.

###