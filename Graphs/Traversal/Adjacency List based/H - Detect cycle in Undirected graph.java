import java.util.*;

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList < ArrayList < Integer >> adj) {
        Set < Integer > visited = new HashSet <> ();
        // Iterate over all vertices and check for cycles starting from each vertex
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i) && dfs(i, -1, visited, adj)) {
                return true; // If cycle found, return true
            }
        }
        return false; // No cycle found
    }

    public boolean dfs(int src, int parent, Set < Integer > visited, ArrayList < ArrayList < Integer >> adj) {
        visited.add(src);
        for (int neighbor: adj.get(src)) {
            if (!visited.contains(neighbor)) {
                boolean b = dfs(neighbor, src, visited, adj);
                if (b==true) {
                    return true;
                    break; // Cycle found in the subtree
                }
            } else if (neighbor != parent) {
                return true; // Found a back edge to a visited node (excluding parent)
            }
        }
        return false; // No cycle found from this node
    }
}