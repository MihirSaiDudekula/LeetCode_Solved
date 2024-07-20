// 435. Non-overlapping Intervals
// Solved
// Medium
// Topics
// Companies
// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

// Example 1:

// Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
// Example 2:

// Input: intervals = [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
// Example 3:

// Input: intervals = [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

// Constraints:

// 1 <= intervals.length <= 105
// intervals[i].length == 2
// -5 * 104 <= starti < endi <= 5 * 104

import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for (int[] x : intervals) {
            list.add(x);
        }
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // Compare based on the element at index 1 (end time)
                return Integer.compare(o1[1], o2[1]);
            }
        });
        
        int count = 0;
        int end = Integer.MIN_VALUE; // Tracks the end time of the last selected interval
        
        for (int[] interval : list) {
            if (interval[0] < end) {
                // Overlapping interval found
                count++;
            } else {
                // Non-overlapping interval found, update the end time
                end = interval[1];
            }
        }
        
        return count;
    }
}

