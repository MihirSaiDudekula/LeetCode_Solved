# Solution Strategies for Binary Search Problems

I'll break down each binary search problem's solution strategy:

## 1. Binary Search to Find X
- Initialize `left = 0`, `right = array length - 1`
- While `left ≤ right`, calculate `mid = (left + right) // 2`
- If the mid element equals the target, return the index
- If the target is less than the mid element, search the left half (`right = mid - 1`)
- If the target is greater than the mid element, search the right half (`left = mid + 1`)

## 2. Implement Lower Bound (First element >= X)
- Initialize `left = 0`, `right = array length - 1`, `answer = n`
- While `left ≤ right`, calculate `mid`
- If the mid element is greater than or equal to the target, store this as a potential answer (`ans = mid`) and search the left half
- If the mid element is less than the target, search the right half
- Return the answer (this will be the first position where the element is greater than or equal to the target)

## 3. Implement Upper Bound (First element > X)
- Initialize `left = 0`, `right = array length - 1`, `answer = n`
- While `left ≤ right`, calculate `mid`
- If the mid element is greater than the target, store this as a potential answer (`ans = mid`) and search the left half
- If the mid element is less than or equal to the target, search the right half
- Return the answer (this will be the first position where the element is greater than the target)

## 4. Search Insert Position
- Use standard binary search
- If the element is found, return its index
- If not found, return the left pointer position (where the element should be inserted to maintain order)

## 5. Floor/Ceil in Sorted Array

**For Floor (largest element ≤ X):**
- Use modified binary search
- If the mid element is less than or equal to the target, store it as a potential floor and search the right half
- If the mid element is greater than the target, search the left half

**For Ceil (smallest element ≥ X):**
- Same as the lower bound implementation

## 6. First/Last Occurrence

**For First Occurrence:**
- Use binary search, but when the element is found, store it as a potential answer
- Continue searching in the left half

**For Last Occurrence:**
- Use binary search, but when the element is found, store it as a potential answer
- Continue searching in the right half

## 7. Count Occurrences in Sorted Array
- Find the first occurrence using binary search
- Find the last occurrence using binary search
- Return `(last - first + 1)`

## 8. Search in Rotated Sorted Array I
- Find the pivot point where the array is rotated
- Determine which half of the array is sorted
- If the target is in the sorted half, search that half
- Otherwise, search the other half
- Use regular binary search in the chosen half

## 9. Search in Rotated Sorted Array II (with duplicates)
- Similar to Rotated Array I
- Additional handling for duplicates: if `arr[mid] == arr[left]`, increment `left`
- Rest of the approach remains the same as Rotated Array I

## 10. Find Minimum in Rotated Array
- Initialize `left = 0`, `right = n - 1`
- While `left < right`:
  - If the mid element is less than the right element, the minimum is in the left half including `mid`
  - If the mid element is greater than the right element, the minimum is in the right half
- Return the element at the left index

## 11. Number of Array Rotations
- Find the index of the minimum element using binary search
- That index equals the number of rotations
- Use the same approach as finding the minimum in a rotated array

## 12. Single Element in Sorted Array
- Use binary search on even indices
- Check if the current element has a different neighbor than expected
- If the pattern breaks, the answer lies in that half
- Continue binary search in the chosen half

## 13. Find Peak Element
- Initialize `left = 0`, `right = n - 1`
- While `left < right`:
  - Calculate `mid`
  - If `arr[mid] < arr[mid + 1]`, the peak is in the right half
  - Otherwise, the peak is in the left half, including `mid`
- Return the left index

