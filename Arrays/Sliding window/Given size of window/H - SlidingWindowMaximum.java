// 239. Sliding Window Maximum
// Solved
// Hard
// Topics
// Companies
// Hint
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

 

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int n = nums.length;
        int count = 0;
        int[] res = new int[n - k + 1];

        if (k == 1) {
            return nums;
        }

        // Process the first window of size k
        for (int i = 0; i < k; i++) {
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.removeLast();
            }
            d.offerLast(i);
        }

        // Store the result for the first window
        res[count++] = nums[d.peekFirst()];

        // Process the remaining elements
        for (int i = k; i < n; i++) {
            // Remove elements not in the current window
            if (!d.isEmpty() && d.peekFirst() == i - k) {
                d.pollFirst();
            }

            // Remove elements from the deque which are less than the current element
            while (!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.removeLast();
            }

            d.offerLast(i);

            // Store the maximum element of the current window
            res[count++] = nums[d.peekFirst()];
        }

        return res;
    }
}
