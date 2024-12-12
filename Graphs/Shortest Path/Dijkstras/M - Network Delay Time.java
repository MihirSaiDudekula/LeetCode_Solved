// 743. Network Delay Time
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

// We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

// Example 1:


// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
// Example 2:

// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
// Example 3:

// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
 

// Constraints:

// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] item : times) {

            graph.get(item[0] - 1).add(new int[]{item[1] - 1, item[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{k - 1, 0}); 

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[k - 1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int dist = cur[1];

            for (int[] x : graph.get(node)) {
                int dest = x[0];
                int desdist = x[1];

                if (cost[node] + desdist < cost[dest]) {
                    cost[dest] = cost[node] + desdist;
                    pq.offer(new int[]{dest, cost[dest]});
                }
            }
        }

        int max = -1;
        for (int x : cost) {
            if (x == Integer.MAX_VALUE) {
                return -1; 
            } else if (x > max) {
                max = x; 
            }
        }

        return max;
    }
}
