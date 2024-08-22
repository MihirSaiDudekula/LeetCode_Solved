// Undirected Graph Cycle
// Difficulty: MediumAccuracy: 30.13%Submissions: 445K+Points: 4
// Given an undirected graph with V vertices labelled from 0 to V-1 and E edges, check whether it contains any cycle or not. Graph is in the form of adjacency list where adj[i] contains all the nodes ith node is having edge with.

// Example 1:

// Input:  
// V = 5, E = 5
// adj = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}} 
// Output: 1
// Explanation: 

// 1->2->3->4->1 is a cycle.
// Example 2:

// Input: 
// V = 4, E = 2
// adj = {{}, {2}, {1, 3}, {2}}
// Output: 0
// Explanation: 

// No cycle in the graph.
 

// Your Task:
// You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not, return 1 if a cycle is present else return 0.

// NOTE: The adjacency list denotes the edges of the graph where edges[i] stores all other vertices to which ith vertex is connected.

 

// Expected Time Complexity: O(V + E)
// Expected Space Complexity: O(V)


 

// Constraints:
// 1 ≤ V, E ≤ 105

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        
        // Iterate over all vertices to handle disconnected graphs (not needed if graph is connected)
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                if (dfs(i, -1, visited, adj)) {
                    return true; // If cycle found, return true
                }
            }
        }
        
        // No cycle found
        return false;
    }
    
    // DFS function to detect cycle
    public boolean dfs(int src, int parent, Set<Integer> visited, ArrayList<ArrayList<Integer>> adj) {
        visited.add(src);
        for (int neib : adj.get(src)) {
            // If neighbor is already visited and not the parent, cycle is detected
            if (visited.contains(neib) && neib != parent) {
                return true;
            }
            // If neighbor is not visited, continue DFS
            if (!visited.contains(neib)) {
                boolean neibHasCycle = dfs(neib, src, visited, adj);
                if (neibHasCycle) {
                    //even if any neighbour has cycle, it is as good as the entire graph has a cycle,this function call will also return true,hence there may be a chain of true returns here
                    return true;
                }
            }
        }
        return false;
    }
}
