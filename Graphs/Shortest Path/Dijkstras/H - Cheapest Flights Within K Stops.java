// 787. Cheapest Flights Within K Stops
// Solved
// Medium
// Topics
// Companies
// There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

// Example 1:


// Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
// Output: 700
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
// Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
// Example 2:


// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
// Output: 200
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
// Example 3:


// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
// Output: 500
// Explanation:
// The graph is shown above.
// The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

// Constraints:

// 1 <= n <= 100
// 0 <= flights.length <= (n * (n - 1) / 2)
// flights[i].length == 3
// 0 <= fromi, toi < n
// fromi != toi
// 1 <= pricei <= 104
// There will not be any multiple flights between two cities.
// 0 <= src, dst, k < n
// src != dst

import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Build the graph from the flights array
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            // Each node has a list of (destination, cost) pairs
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Step 2: Use a priority queue to explore cities in order of cost
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0, 0});  // {currentNode, currentCost, stopsMade}

        // Step 3: Initialize the cost table to track minimum cost with specific stops
        int[][] costs = new int[n][k + 2];  // costs[node][stops]
        for (int i = 0; i < n; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);  // Initialize with "infinity"
        }
        costs[src][0] = 0;  // The cost to reach the src with 0 stops is 0

        // Step 4: Run modified Dijkstra's algorithm with stop count
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];  // current city
            int cost = cur[1];  // current accumulated cost
            int stops = cur[2];  // number of stops made to reach this city

            // If we reached the destination, return the cost
            if (node == dst) {
                return cost;
            }

            // If we already made more than 'k' stops, continue (pruning)
            if (stops > k) {
                continue;
            }

            // Step 5: Explore neighbors (next cities from the current city)
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int nextCost = neighbor[1];

                // Check if we found a cheaper way to reach 'nextNode' with (stops + 1)
                if (cost + nextCost < costs[nextNode][stops + 1]) {
                    costs[nextNode][stops + 1] = cost + nextCost;
                    pq.offer(new int[]{nextNode, cost + nextCost, stops + 1});
                }
            }
        }

        // If no valid path exists with <= k stops, return -1
        return -1;
    }
}
