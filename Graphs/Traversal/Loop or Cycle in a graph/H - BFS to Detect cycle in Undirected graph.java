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
        // Code here
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i)) {
                if (checkCycleBFS(i,visited, adj)) {
                    return true; 
                }
            }
        }
        return false;
    }
    public boolean checkCycleBFS(int src, Set<Integer> visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        visited.add(src);
        queue.offer(new int[] { src, -1 }); 
        // Use an array where the first element is the current node and the second is its parent
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];
            
            for (int neighbor : adj.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(new int[] { neighbor, node });
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        
        return false;
    }

}