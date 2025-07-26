// 56. Merge Intervals
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

class Solution {
    public int[][] merge(int[][] intervals) {
        // Prioritize by start time instead of end time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0]; // Sort by start time
        });
        
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            pq.add(interval);
        }

        if (pq.size() == 1) {
            return intervals;
        }
        
        while (!pq.isEmpty()) {
            int[] prev = pq.poll();
            if (pq.isEmpty()) {
                list.add(prev);
                break;
            }
            int[] cur = pq.poll();

            if (prev[1] >= cur[0]) {
                // Fix: Use max of both end times when merging
                pq.add(new int[] { Math.min(prev[0], cur[0]), Math.max(prev[1], cur[1]) });
            } else {
                list.add(prev);
                // Put current interval back in queue to compare with next
                pq.add(cur);
            }
        }
        
        int[][] array = new int[list.size()][];
        return list.toArray(array);
    }
}