// Bellman-Ford
// Difficulty: MediumAccuracy: 48.11%Submissions: 152K+Points: 4
// Given a weighted and directed graph of v vertices and edges, Find the shortest distance of all the vertex's from the source vertex, src and return a list of integers where the ith integer denotes the distance of the ith node from the source node. If a vertices can't be reach from the s then mark the distance as 10^8.
// Note: If the graph contains a negative cycle then return an array consisting of only -1.

// Examples:

// Input: edges = [[0,1,9]], src = 0

// Output: [0, 9]
// Explanation: Shortest distance of all nodes from source is printed.
// Input: edges = [[0,1,5], [1,0,3], [1,2,-1], [2,0,1]], src = 2

// Output: [1, 6, 0]
// Explanation: For nodes 2 to 0, we can follow the path: 2-0. This has a distance of 1. For nodes 2 to 1, we cam follow the path: 2-0-1, which has a distance of 1+5 = 6,
// Constraints:
// 1 ≤ V ≤ 500
// 1 ≤ E ≤ V*(V-1)
// -1000 ≤ data of nodes, weight ≤ 1000
// 0 ≤ S < V

class Solution {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;
        
        for(int i=0;i<V-1;i++)
        {
            for(int[] x:edges)
            {
                if((dist[x[0]]!=(int) 1e8)&&((dist[x[0]]+x[2])<dist[x[1]]))
                {
                    dist[x[1]]=dist[x[0]]+x[2];
                }
            }
        }
        
        // negative cycles keep shrinking infinitely
        // so after we check n-1 times, if nth time also there is a shrink
        // that means theres a cycle with -ves
        for(int[] x:edges)
        {
            if((dist[x[0]]!=(int) 1e8)&&((dist[x[0]]+x[2])<dist[x[1]]))
            {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        
        return dist;
    }
}
