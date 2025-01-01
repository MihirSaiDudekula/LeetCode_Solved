# Solution Strategies for Common Array and String Problems

I'll break down each problem's solution strategy in clear steps.

## 1. Max Sum Subarray of Size K
- Initialize a sliding window with left and right pointers starting at 0.
- Add elements to the window until size `K` is reached, keeping a running sum.
- Once the window size `K` is reached, update the max sum if the current sum is larger.
- Slide the window by subtracting the leftmost element and adding the next element, repeating the process.

## 2. First Negative Number in Every Window of Size K
- Use a deque to store negative numbers' indices.
- For each element, if negative, add its index to the deque.
- When the window size reaches `K`, output the front of the deque if it exists (first negative number).
- Before sliding the window, if the front of the deque matches the leaving element's index, pop from the deque.
- Critical check: If the front element of the deque is leaving the window (`arr[l]`), remove it.

## 3. Count Occurrences of Anagram
- Create a frequency map of the pattern string.
- Use a sliding window with size equal to the pattern length.
- For each window:
  - Decrease the frequency of the incoming character in the map.
  - If any character's frequency becomes `0`, remove it from the map.
  - When the map is empty, an anagram is found.
  - Before sliding, reset frequencies for characters leaving the window.

## 4. Maximum of All Subarrays of Size K
- Use a deque to maintain potential maximum elements.
- For the current element:
  - Remove all smaller elements from the back of the deque (they can't be the maximum).
  - Add the current element to the back.
  - If the front element is outside the window, remove it.
- Once the window size reaches `K`, the front of the deque holds the maximum for the current window.

## 5. Largest Subarray of Sum K (For Positive Numbers)
- Use a sliding window with a running sum.
- If the sum is less than `K`, expand the window by adding elements.
- If the sum is greater than `K`, shrink the window by removing elements from the left.
- If the sum equals `K`, update the maximum length and continue sliding.
- **Note:** For arrays with negative numbers, use a prefix sum approach instead.

## 6. Max Number of K Sum Pairs
- Sort the array first.
- Use two pointers: one at the start (`left`) and one at the end (`right`).
- If the pair sum equals `K`, increment the count and move both pointers.
- If the sum is less than `K`, move the left pointer right.
- If the sum is greater than `K`, move the right pointer left.

## 7. Longest Substring with K Unique Characters
- Use a hash map to track character frequencies.
- Expand the window by adding characters to the map.
- If the number of unique characters exceeds `K`, shrink the window from the left.
- Remove characters from the map when their frequency becomes `0`.
- Track the maximum window length that satisfies having exactly `K` unique characters.

## 8. Maximum Sum of Distinct Subarrays With Length K
- Use a sliding window with a hash map for frequencies.
- Track the current sum while adding elements.
- **Key optimization:** Only slide the left pointer when either:
  - The window size exceeds `K`, or
  - The current element's frequency is greater than 1.
- When the window size is exactly `K` and all elements are unique, update the max sum.

## 9. Minimum Window Substring
- Create a frequency map of the target string.
- Expand the window until all target characters are found.
- Once a valid window is found:
  - Track the minimum window length.
  - Try to minimize the window by removing characters from the left.
  - If the window becomes invalid, expand it again.
- Keep track of the minimum valid window seen so far.
