// You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

// You are given an integer n and a 2D integer array ‘roads’ where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

// Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.

// Example 1:



// Input:
// n=7, m=10
// edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
// Output:
// 4
// Explanation: 
// The four ways to get there in 7 minutes (which is the shortest calculated time) are:
// - 0  6
// - 0  4  6
// - 0  1  2  5  6
// - 0  1  3  5  6
// Example 2:



// Input:
// n=6, m=8
// edges= [[0,5,8],[0,2,2],[0,1,1],[1,3,3],[1,2,3],[2,5,6],[3,4,2],[4,5,2]]
// Output:
// 3
// Explanation: 
// The three ways to get there in 8 minutes (which is the shortest calculated time) are:
// - 0  5
// - 0  2  5
// - 0  1  3  4  5

import java.util.*;

public class Solution {
    public int countPaths(int n, int[][] roads) {
        // Modulo value
        final int MOD = 1000000007;
        
        // Build the graph as an adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0], v = road[1], dist = road[2];
            graph.get(u).add(new int[]{v, dist});
            graph.get(v).add(new int[]{u, dist});
        }
        
        // Dijkstra's algorithm to find shortest dists
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        // DP array to count the number of ways to reach each node
        int[] ways = new int[n];
        ways[0] = 1;
        
        // Min-heap (priority queue) to implement Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0}); // Start at node 0 with 0 dist
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDist = current[1];
            
            // If we found a shorter path to the current node, skip it
            if (currentDist > dist[node]) continue;
            
            // Explore all neighbors
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDist = currentDist + edgeWeight;
                
                // If a shorter path to the neighbor is found
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    ways[nextNode] = ways[node]; // Copy the number of ways to reach the current node
                    pq.offer(new int[]{nextNode, newDist});
                } 
                // If we find another shortest path to the neighbor
                else if (newDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD; // Add the number of ways to reach the current node
                }
            }
        }
        
        // The answer is the number of ways to reach node n-1 in the shortest dist
        return ways[n - 1];
    }
}

